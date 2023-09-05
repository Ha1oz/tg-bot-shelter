package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);

            String incomingMessage = update.message().text();
            Long chatId = update.message().chat().id();

            if (incomingMessage.equalsIgnoreCase("/start")) {
                welcomeMessage(update, chatId);
            }

            if (incomingMessage.equalsIgnoreCase("Приют для кошек")) {
                catShelterMenu(chatId);

            }

            if (incomingMessage.equalsIgnoreCase("Приют для собак")) {
                dogShelterMenu(chatId);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    public void welcomeMessage(Update update, Long chatId) {
        SendMessage message = new SendMessage(chatId, update.message().chat().firstName() +
                ", привет! Я бот-помощник и я помогу тебе выбрать верного друга! \n" +
                "Выбери приют")
                .replyMarkup(new ReplyKeyboardMarkup(
                        new KeyboardButton("Приют для кошек"),
                        new KeyboardButton("Приют для собак"))
                        .oneTimeKeyboard(true)
                );
        SendResponse response = telegramBot.execute(message);
    }

    public void catShelterMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId, "Что Вы хотите узнать?")
                .replyMarkup(new ReplyKeyboardMarkup(new String[][]{
                        {"Информация о приюте", "Как взять питомца из приюта"},
                        {"Прислать отчет о питомце", "Позвать волонтера"}
                }));
        SendResponse response = telegramBot.execute(message);
    }

    public void dogShelterMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId, "Что Вы хотите узнать?")
                .replyMarkup(new ReplyKeyboardMarkup(new String[][]{
                        {"Информация о приюте", "Как взять питомца из приюта"},
                        {"Прислать отчет о питомце", "Позвать волонтера"}
                }));
        SendResponse response = telegramBot.execute(message);
    }
}
