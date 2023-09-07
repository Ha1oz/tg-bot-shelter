package pro.sky.telegrambot.handler.message;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

public class StartMessageHandler implements MessageChainHandler {
    @Override
    public boolean check(Update update) {
        Message message = update.message();
        return message != null && message.text().contains("/start");
    }
    @Override
    public SendMessage handle(Update update) {
        Message message = update.message();

        Long chatId = message.chat().id();
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Cats").callbackData("shelter_cats"),
                new InlineKeyboardButton("Dogs").callbackData("shelter_dogs")
        );

        SendMessage sendMessage = new SendMessage(chatId, "Hello, choose your option")
                .replyMarkup(inlineKeyboard);

        return sendMessage;
    }
}
