package pro.sky.telegrambot.handler;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

public class ShelterHandler implements ChainHandler{
    @Override
    public boolean check(Update update) {
        Message message = update.message();
        return message != null && message.text().startsWith("Приют для");
    }

    @Override
    public SendMessage handle(Update update) {
        Long chatId = update.message().chat().id();
        SendMessage sendMessage = new SendMessage(chatId, "Что Вы хотите узнать?");
        ReplyKeyboardMarkup replyKeyboardMarkup =
                new ReplyKeyboardMarkup(
                        new KeyboardButton("Информация о приюте"),
                        new KeyboardButton("Как взять питомца из приюта")
                );
        replyKeyboardMarkup.addRow(
                new KeyboardButton("Прислать отчет о питомце"),
                new KeyboardButton("Позвать волонтера")
                );
        sendMessage.replyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
