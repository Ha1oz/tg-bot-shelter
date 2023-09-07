package pro.sky.telegrambot.handler.callback;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;

public class ShelterCallbackHandler implements CallbackChainHandler{
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith("shelter");
    }
    @Override
    public EditMessageText handle(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();

        String[] params = callbackQuery.data().split("_");
        Long chatId = callbackQuery.message().chat().id();
        Integer messageId = callbackQuery.message().messageId();
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Info").callbackData("info_" + params[1]),
                new InlineKeyboardButton("Get animal").callbackData("get_" + params[1]),
                new InlineKeyboardButton("Report").callbackData("report"),
                new InlineKeyboardButton("Call volunteer").callbackData("volunteer")
        );

        EditMessageText editMessage = new EditMessageText(chatId, messageId, "Updated for " + params[1])
                .replyMarkup(inlineKeyboard);

        return editMessage;
    }
}
