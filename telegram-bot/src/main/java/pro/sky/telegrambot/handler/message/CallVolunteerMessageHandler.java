package pro.sky.telegrambot.handler.message;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.handler.api.MessageChainHandler;
import pro.sky.telegrambot.model.response.Question;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.model.response.ResponseModel;
import pro.sky.telegrambot.service.ChattingService;

import java.util.Arrays;

/**
 * Обработчик сообщений для вызова добровольцев для ответов на вопросы.
 */
@AllArgsConstructor
public class CallVolunteerMessageHandler implements MessageChainHandler {
    private final ChattingService service;
    private final TelegramBot telegramBot;

    /**
     * Проверяет, соответствует ли сообщение условиям для обработки.
     *
     * @param update Объект с обновлением от Telegram.
     * @return true, если сообщение подходит для обработки, иначе false.
     */
    @Override
    public boolean check(Update update) {
        Message message = update.message();

        if (message == null || message.text() == null) {
            return false;
        }
        MessageEntity[] messageEntity = message.entities();
        if (messageEntity == null) {
            return false;
        }
        if (Arrays.stream(messageEntity).noneMatch(e -> e.type().equals(MessageEntity.Type.mention))) {
            return false;
        }

        return message.text().contains(CommandType.SEND_QUESTION_MESSAGE.getCommand());

    }

    /**
     * Обрабатывает сообщение и вызывает добровольца для ответа на вопрос клиента.
     *
     * @param update Объект с обновлением от Telegram.
     * @return Объект SendMessage, представляющий ответ на сообщение.
     */
    @Override
    public SendMessage handle(Update update) {
        Message message = update.message();
        Long chatId = message.chat().id();

        MessageEntity commandEntity = Arrays.stream(message.entities())
                .filter(e -> e.type().equals(MessageEntity.Type.bot_command))
                .findFirst()
                .get();

        Long userId = message.chat().id();
        String textReport = message.text().substring(commandEntity.offset() + commandEntity.length());

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Back").callbackData(CommandType.START_CALLBACK.getCommand())
        );



        // TODO: queue of questions and do uniform distribution for volunteers
        Volunteer volunteer = service.getFreeVolunteer();

        if (volunteer == null) {
            return new SendMessage(chatId, "Call volunteers doesn't available now. Please try again later.").replyMarkup(keyboardMarkup);
        }

        Question question = new Question(chatId, volunteer.getChatId(), textReport);

        telegramBot.execute(service.getSMFromQuestion(question));

        return new SendMessage(chatId, "Volunteer is called. Please wait his response.").replyMarkup(keyboardMarkup);
    }

}
