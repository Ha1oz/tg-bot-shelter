package pro.sky.telegrambot.handler.message;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetFileResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.entity.PetType;
import pro.sky.telegrambot.handler.api.MessageChainHandler;
import pro.sky.telegrambot.model.Photo;
import pro.sky.telegrambot.model.Report;
import pro.sky.telegrambot.model.User;
import pro.sky.telegrambot.repository.PhotoRepository;
import pro.sky.telegrambot.repository.ReportRepository;
import pro.sky.telegrambot.service.PhotoService;
import pro.sky.telegrambot.service.ReportService;
import pro.sky.telegrambot.service.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
/**
 * Обработчик для сообщений, содержащих команду <i>bot-mention</i> /form.
 * Возвращает результат отправки отчёта.
 */
@Component
@AllArgsConstructor
public class ReportMessageHandler implements MessageChainHandler {
    private final Logger logger = LoggerFactory.getLogger(ReportMessageHandler.class);
    private final UserService userService;
    private final PhotoService photoService;
    private final ReportService reportService;
    private final TelegramBot telegramBot;


    /**
     * Проверяет, соответствует ли сообщение команде <i>bot-mention</i> /form.
     *
     * @param update Обновление от Telegram API
     * @return true, если сообщение содержит команду <i>bot-mention</i> /form, иначе false.
     */
    @Override
    public boolean check(Update update) {
        Message message = update.message();
        if (message == null || message.caption() == null) {
            return false;
        }
        MessageEntity[] messageEntity = message.captionEntities();
        if (Arrays.stream(messageEntity).noneMatch(e-> e.type().equals(MessageEntity.Type.mention))) {
            return false;
        }

        return message.caption().contains(CommandType.FORM_MESSAGE.getCommand());
    }
    /**
     * Обрабатывает сообщение с командой <i>bot-mention</i> /form и возвращает ответ, сообщающий результат отправки отчёта
     *
     * @param update Обновление от Telegram API
     * @return SendMessage объект с сообщением и клавиатурой для отправки обратно в Telegram
     */
    @Override
    public SendMessage handle(Update update) {
        Message message = update.message();
        Long chatId = message.chat().id();

        MessageEntity commandEntity = Arrays.stream(message.captionEntities())
                .filter(e -> e.type().equals(MessageEntity.Type.bot_command))
                .findFirst()
                .get();

        int offset = commandEntity.offset() + CommandType.FORM_MESSAGE.getCommand().length();

        String petParam = message.caption().substring(offset, commandEntity.offset() + commandEntity.length());
        String textReport = message.caption().substring(commandEntity.offset() + commandEntity.length());

        Optional<User> userOptional = userService.findUserByChatId(chatId);

        if (userOptional.isEmpty()) {
            return new SendMessage(chatId, "You are not allowed to send reports.");
        }

        User user = userOptional.get();

        PhotoSize[] photoSize = update.message().photo();
        Photo photo = null;
        try {
            photo = downloadPhoto(photoSize);
            photoService.addPhoto(photo);
        } catch (IOException e) {
            return new SendMessage(chatId, "Error downloading photo. Some went wrong.");
        }

        Report report = new Report();
        report.setUser(user);
        report.setPhoto(photo);
        report.setNumber(reportService.getReportCountFromUser(user.getChatId())+1);
        report.setPetType(petParam);
        report.setText(textReport);

        reportService.addReport(report);

        return new SendMessage(chatId, "Thanks for sending reports");
    }
    /**
     * Вспомогательный метод, для получения модели <code>Photo</code> из <code>PhotoSize[]</code>
     *
     * @param photoSize объект из Telegram Api
     * @return Photo модель
     */
    private Photo downloadPhoto(PhotoSize[] photoSize) throws IOException {
        GetFile getFile = new GetFile(photoSize[photoSize.length - 1].fileId());
        GetFileResponse response = telegramBot.execute(getFile);
        File file = response.file();

        String urlPath = telegramBot.getFullFilePath(file);

        WebClient webClient = WebClient.create(urlPath);
        MediaType mediaType = MediaType.IMAGE_JPEG;

        byte[] bytes = webClient
                .get().accept(mediaType)
                .retrieve()
                .bodyToMono(byte[].class)
                .block();

        Photo photo = new Photo();
        photo.setFileSize(file.fileSize());
        photo.setData(bytes);
        photo.setMediaType(mediaType.toString());

        return photo;
    }
}
