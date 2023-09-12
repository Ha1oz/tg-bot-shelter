package pro.sky.telegrambot.handler.callback_0_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.handler.callback_0_level.CallbackChainHandler;

public class AnswerReportCallbackHandlerImpl implements CallbackChainHandler {

    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery  = update.callbackQuery();
        return callbackQuery  != null && callbackQuery .data().equals("report");
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
        CallbackQuery callbackQuery  = update.callbackQuery();
        Long chatId = callbackQuery .message().chat().id();
        Integer messageId = callbackQuery .message().messageId();
        EditMessageText editMessage = new EditMessageText(
                chatId,
                messageId,
                "R."
        );
        return editMessage;
    }
}

