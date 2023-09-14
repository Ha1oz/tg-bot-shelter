package pro.sky.telegrambot.handler.callback_2_level;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;

/**
 * Обработчик для колбэков связанных с приютами.
 */
public class ShelterGetPetCallbackHandler implements CallbackChainHandler {

    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика приютов.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика приютов, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith(CommandType.GET_CALLBACK.getCommand());
    }

    /**
     * Обрабатывает колбэк связанный с приютами и возвращает EditMessageText объект с обновленным текстом сообщения или
     * null, если колбэк не обрабатывается обработчиком.
     *
     * @param update Обновление от Telegram API
     * @return EditMessageText объект с обновленным текстом сообщения или null, если колбэк не обрабатывается обработчиком.
     */
    @Override
    public EditMessageText handle(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        String[] params = callbackQuery.data().split("_");
        Long chatId = callbackQuery.message().chat().id();
        Integer messageId = callbackQuery.message().messageId();
        InlineKeyboardMarkup inlineKeyboard =
                new InlineKeyboardMarkup(
                        new InlineKeyboardButton("Rules").callbackData(CommandType.RULES_CALLBACK.getCommand()
                                + params[1]),
                        new InlineKeyboardButton("Documents for adopt").callbackData(CommandType.DOCUMENTS_CALLBACK.getCommand()
                                + params[1])
                );
        inlineKeyboard.addRow(
                new InlineKeyboardButton("Transporting").callbackData(CommandType.TRANSPORTING_CALLBACK.getCommand()
                        + params[1]),
                new InlineKeyboardButton("How to arrive").callbackData(CommandType.ARRIVE_CALLBACK.getCommand()
                        + params[1])

        );
        inlineKeyboard.addRow(
                new InlineKeyboardButton("Car pass").callbackData(CommandType.CAR_PASS_CALLBACK.getCommand()
                        + params[1]),
                new InlineKeyboardButton("Safety guide").callbackData(CommandType.SAFETY_GUIDE_CALLBACK.getCommand()
                        + params[1])

        );
        inlineKeyboard.addRow(
                new InlineKeyboardButton("Send contact").callbackData(CommandType.SEND_CONTACT_CALLBACK.getCommand()
                        + params[1]),
                new InlineKeyboardButton("Call volunteer").callbackData(CommandType.VOLUNTEER_CALLBACK.getCommand()
                        + callbackQuery.data())
        );
        inlineKeyboard.addRow(
                new InlineKeyboardButton("Back").callbackData(CommandType.START_CALLBACK.getCommand())
        );

        EditMessageText editMessage = new EditMessageText(chatId, messageId, "Updated info shelter for " + params[1])
                .replyMarkup(inlineKeyboard);
        return editMessage;

    }
}
