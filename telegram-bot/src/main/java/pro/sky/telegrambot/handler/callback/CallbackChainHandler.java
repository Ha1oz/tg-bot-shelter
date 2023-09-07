package pro.sky.telegrambot.handler.callback;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.EditMessageText;

/**
 * Интерфейс для обработчиков цепочки колбэков.
 * Каждый обработчик должен реализовать методы check() и handle().
 */
public interface CallbackChainHandler {

    /**
     * Проверяет, соответствует ли обновление необходимым условиям обработчика колбэков.
     *
     * @param update Обновление от Telegram API
     * @return true, если обновление соответствует условиям обработчика колбэков, иначе false.
     */
    boolean check(Update update);

    /**
     * Обрабатывает обновление колбэков и возвращает EditMessageText объект с обновленным текстом сообщения или null, если обновление не обрабатывается обработчиком.
     *
     * @param update Обновление от Telegram API
     * @return EditMessageText объект с обновленным текстом сообщения или null, если обновление не обрабатывается обработчиком.
     */
    EditMessageText handle(Update update);
}
