package pro.sky.telegrambot.handler.callback_1_level.dog.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.handler.callback_0_level.CallbackChainHandler;

public class AnswerScheduleDogCallbackHandler implements CallbackChainHandler {
    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith("about_schedule_dog");
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
                "Schedule:\nMonday:  " + "07:30–19:30\n" +
                     "Tuesday:  " + "07:30–19:30\n" +
                     "Wednesday:  " + "07:30–19:30\n" +
                     "Thursday:  " + "07:30–19:30\n" +
                     "Friday:  " +"07:30–19:30\n" +
                     "Saturday:  " +  "Выходной\n" +
                     "Sunday:  " + "Выходной\n "+
                     "*WITHOUT A BREAK FOR LUNCH!*."
        );
        return editMessage;
    }
}


