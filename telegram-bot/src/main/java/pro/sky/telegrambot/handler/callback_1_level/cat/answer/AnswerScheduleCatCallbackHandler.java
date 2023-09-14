package pro.sky.telegrambot.handler.callback_1_level.cat.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.handler.callback_0_level.CallbackChainHandler;

public class AnswerScheduleCatCallbackHandler implements CallbackChainHandler {
    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith("about_schedule_cat");
    }

    /**
     * Обрабатывает колбэк связанный с волонтерством и возвращает EditMessageText объект с обновленным текстом сообщения
     * или null, если колбэк не обрабатывается обработчиком.
     *
     * @param update Обновление от Telegram API
     * @return EditMessageText объект с обновленным текстом сообщения или null, если колбэк не обрабатывается обработчиком.
     */
    @Override
    public EditMessageText handle(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        Long chatId = callbackQuery.message().chat().id();
        Integer messageId = callbackQuery.message().messageId();
        EditMessageText editMessage = new EditMessageText(
                chatId,
                messageId,
                "*Schedule*:\nMonday:  " + "08:30–19:30\n" +
                     "Tuesday:  " + "08:30–19:30\n" +
                     "Wednesday:  " + "08:30–19:30\n" +
                     "Thursday:  " + "08:30–19:30\n" +
                     "Friday:  " +"08:30–19:30\n" +
                     "Saturday:  " +  "Выходной\n" +
                     "Sunday:  " + "Выходной\n "+
                     "*WITH A BREAK FOR LUNCH EVERY DAY (13.00-14.00)!*."
        );
        return editMessage;
    }
}


