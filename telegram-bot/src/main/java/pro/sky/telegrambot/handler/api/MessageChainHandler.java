package pro.sky.telegrambot.handler.api;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * Интерфейс для обработчиков цепочки сообщений.
 * Каждый обработчик должен реализовать методы check() и handle().
 */
public interface MessageChainHandler {

    /**
     * Проверяет, соответствует ли обновление необходимым условиям обработчика.
     *
     * @param update Обновление от Telegram API
     * @return true, если обновление соответствует условиям обработчика, иначе false.
     */
    boolean check(Update update);



    /**
     * Обрабатывает обновление и возвращает SendMessage объект с ответным сообщением или null, если обновление не
     * обрабатывается обработчиком.
     *
     * @param update Обновление от Telegram API
     * @return SendMessage объект с ответным сообщением или null, если обновление не обрабатывается обработчиком.
     */
    SendMessage handle(Update update);


}
