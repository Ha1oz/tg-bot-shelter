package pro.sky.telegrambot.handler.callback_2_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;

/**
 * Обработчик для колбэков связанных с правилами знакомства с животными на встрече.
 */
public class AnswerRulesForMeetingAnimal implements CallbackChainHandler {

    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика правил знакомства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика правил знакомства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith(CommandType.RULES_CALLBACK.getCommand());
    }

    /**
     * Обрабатывает колбэк связанный с правилами знакомства с животными и возвращает EditMessageText
     * объект с обновленным текстом сообщения и клавиатурой в предыдущем меню
     *
     * @param update Обновление от Telegram API
     * @return EditMessageText объект с обновленным текстом сообщения и клавиатурой в предыдущем меню
     */
    @Override
    public EditMessageText handle(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        Long chatId = callbackQuery.message().chat().id();
        Integer messageId = callbackQuery.message().messageId();
        String[] params = callbackQuery.data().split("_");

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton("In previous menu").callbackData(CommandType.GET_CALLBACK.getCommand()
                        + params[1])
        );

        //TODO: из БД
        String rulesText = "Некоторые правила знакомства с животным до того, как забрать его из приюта:\n" +
                "1. ...\n" +
                "2. ...\n" +
                "...\n" +
                "n. ...";

        EditMessageText editMessage = new EditMessageText(chatId, messageId, rulesText)
                .replyMarkup(keyboard);

        return editMessage;
    }
}
