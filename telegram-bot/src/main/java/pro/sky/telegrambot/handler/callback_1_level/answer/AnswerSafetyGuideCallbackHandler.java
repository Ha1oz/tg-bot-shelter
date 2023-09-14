package pro.sky.telegrambot.handler.callback_1_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;

public class AnswerSafetyGuideCallbackHandler implements CallbackChainHandler {
    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith(CommandType.SAFETY_GUIDE_CALLBACK.getCommand());
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
        String safetyGuideText = "*General safety recommendations on the territory of the shelter*:\n " +
                "\n" +
                "\n" +
                "\n" +"Visiting a shelter for children of preschool and primary school age unaccompanied by adults. "+"\n" +
                "\n" +"The presence on the territory of the shelter of children of middle and high school " +
                "age unaccompanied by adults or a written certificate-permission from parents or legal representatives" +"\n" +
                "\n"+ "Independently enter the cattery without the permission of the shelter staff" +"\n";

        EditMessageText editMessage = new EditMessageText(
                chatId,
                messageId,
                safetyGuideText
        ).replyMarkup(keyboard);
        return editMessage;
    }
}





