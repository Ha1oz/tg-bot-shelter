package pro.sky.telegrambot.handler.callback_1_level.cat;



import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.handler.callback_0_level.CallbackChainHandler;

/**
 * Обработчик для колбэков связанных с приютами.
 */
public class ShelterInfoCatCallbackHandler implements CallbackChainHandler {

    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика приютов.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика приютов, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith("info_cat");
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
                        new InlineKeyboardButton("Our shelter").callbackData("our_shelter_cat" + params[1]),
                        new InlineKeyboardButton("Schedule").callbackData("about_schedule_cat" + params[1])
                );
        inlineKeyboard.addRow(
                new InlineKeyboardButton("Our address").callbackData("address_cat" + params[1]),
                new InlineKeyboardButton("Driving directions").callbackData("driving_cat")

        );
        inlineKeyboard.addRow(
                new InlineKeyboardButton("Our contacts").callbackData("our_contacts_cat"),
                new InlineKeyboardButton("Recommendations").callbackData("recommendations_cat")

        );
        inlineKeyboard.addRow(
                new InlineKeyboardButton("To accept contact").callbackData("contact" ),
                new InlineKeyboardButton("Call volunteer").callbackData("volunteer")

        );
        EditMessageText editMessage = new EditMessageText(chatId, messageId, "Updated for " + params[1])
                .replyMarkup(inlineKeyboard);
        return editMessage;

    }
}
