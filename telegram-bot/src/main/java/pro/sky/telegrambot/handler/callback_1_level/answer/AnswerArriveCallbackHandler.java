package pro.sky.telegrambot.handler.callback_1_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.entity.PetType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;
import pro.sky.telegrambot.entity.PetType;
import static pro.sky.telegrambot.constants.Constants.*;

import static pro.sky.telegrambot.constants.Constants.*;

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
                new InlineKeyboardButton("In previous menu").callbackData(CommandType.INFO_CALLBACK.getCommand()
                        + params[1])
        );

        return processAnimal(params[1], chatId, messageId).replyMarkup(keyboard);
    }
//TODO подтягивать текст об адресе из БД, в зависимости от выбранного варианта в меню (cat или dog)


    private EditMessageText processAnimal(String petType, Long chatId,  Integer messageId) {

        if (petType.equals(PetType.CAT.getPet())) {
            EditMessageText editMessage = new EditMessageText(
                    chatId,
                    messageId,
                    TEXTCATARRIVE);
            return editMessage;

        } else if (petType.equals(PetType.DOG.getPet())) {
            EditMessageText editMessage = new EditMessageText(
                    chatId,
                    messageId,
                    TEXTDOGARRIVE);
            return editMessage;
        }
        return  null ;
    }
}













