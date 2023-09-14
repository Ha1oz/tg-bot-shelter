package pro.sky.telegrambot.handler.message_;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public interface MessageChainHandlerReg {

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
     * @return
     */
    SendMessage handle(Update update);


}
