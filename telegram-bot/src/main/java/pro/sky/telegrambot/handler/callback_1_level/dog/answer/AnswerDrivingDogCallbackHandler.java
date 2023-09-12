package pro.sky.telegrambot.handler.callback_1_level.dog.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.handler.callback_0_level.CallbackChainHandler;

public class AnswerDrivingDogCallbackHandler implements CallbackChainHandler {
    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith("driving_dog");
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
                "Driving directions:\n https://yandex.ru/maps/10662/kameshkovo/house/ulitsa_korunovoy_52/YEgYdgdoTUcCQFtsfX9zcX5lZw==/?ll=41.007326%2C56.319930&z=17.35."
        );
        return editMessage;
    }
}



