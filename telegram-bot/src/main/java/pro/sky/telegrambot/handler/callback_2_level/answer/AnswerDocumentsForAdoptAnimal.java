package pro.sky.telegrambot.handler.callback_2_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;

    /**
    * Обработчик для колбэков, связанных с документами для усыновления животных.
    */
public class AnswerDocumentsForAdoptAnimal implements CallbackChainHandler {

    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика документов для усыновления животных.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика документов для усыновления животных, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith(CommandType.DOCUMENTS_CALLBACK.getCommand());
    }

    /**
     * Обрабатывает колбэк, связанный с документами для усыновления животных, и возвращает
     * объект EditMessageText с обновленным текстом сообщения и клавиатурой в предыдущем меню.
     *
     * @param update Обновление от Telegram API
     * @return Объект EditMessageText с обновленным текстом сообщения и клавиатурой в предыдущем меню
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
        String rulesText = "Чтобы взять животное из приюта, Вам необходимо подготовить следующие документы:\n" +
                "1. ...\n" +
                "2. ...\n" +
                "...\n" +
                "n. ...\n ";

        EditMessageText editMessage = new EditMessageText(chatId, messageId, rulesText)
                .replyMarkup(keyboard);

        return editMessage;
    }
}
