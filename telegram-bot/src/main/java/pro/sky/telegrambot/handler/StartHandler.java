package pro.sky.telegrambot.handler;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

public class StartHandler implements ChainHandler{
    @Override
    public boolean check(Update update) {
        Message message = update.message();
        return message != null && message.text().equalsIgnoreCase("/start");
    }

    @Override
    public SendMessage handle(Update update) {
        Long chatId = update.message().chat().id();
        SendMessage sendMessage = new SendMessage(chatId, update.message().chat().firstName() +
                ", привет! Я бот-помощник и я помогу тебе выбрать верного друга! \n" +
                "Выбери приют");
        ReplyKeyboardMarkup replyKeyboardMarkup =
                new ReplyKeyboardMarkup(
                        new KeyboardButton("Приют для кошек"),
                        new KeyboardButton("Приют для собак")
                );
        sendMessage.replyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
