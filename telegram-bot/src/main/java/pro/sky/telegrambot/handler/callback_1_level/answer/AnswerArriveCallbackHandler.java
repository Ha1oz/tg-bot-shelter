package pro.sky.telegrambot.handler.callback_1_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;

public class AnswerArriveCallbackHandler implements CallbackChainHandler {
    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith(CommandType.ARRIVE_CALLBACK.getCommand());
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

        String[] params = callbackQuery.data().split("_");

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Back").callbackData(CommandType.INFO_CALLBACK.getCommand()
                        + params[1])
        );

        //TODO: из БД
        String arriveInfoText = "Driving directions:\n" +
                "https://yandex.ru/maps/47/nizhny-novgorod/house/krasnoselskaya_ulitsa_11a/YEoYfwBoT0MHQFtsfX9xeXhrYQ==/?ll=43.978659%2C56.308485&z=16.|" +
                "https://yandex.ru/maps/10662/kameshkovo/house/ulitsa_korunovoy_52/YEgYdgdoTUcCQFtsfX9zcX5lZw==/?ll=41.007326%2C56.319930&z=17.35.";

        String[] text = arriveInfoText.split("\\|");

        return switch (params[1]) {
            case "cat" -> {
                EditMessageText editMessage = new EditMessageText(
                        chatId,
                        messageId,
                        text[0]
                ).replyMarkup(keyboard);
                yield editMessage;
            }
            case "dog"-> {
                EditMessageText editMessage  = new EditMessageText(
                        chatId,
                        messageId,
                        text[1]
                ).replyMarkup(keyboard);
                yield editMessage ;
            }
            default -> throw new IllegalStateException("Unexpected value: " + params[1]);
        };
    }
}






