package pro.sky.telegrambot.handler.callback_0_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;

/**
 * Обработчик для колбэков связанных с волонтерством.
 */
public class AnswerVolunteerCallbackHandler implements CallbackChainHandler {

    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith(CommandType.VOLUNTEER_CALLBACK.getCommand());
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

        String backParam = callbackQuery.data().substring(CommandType.VOLUNTEER_CALLBACK.getCommand().length());

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(
            new InlineKeyboardButton("Form").switchInlineQueryCurrentChat(CommandType.SEND_QUESTION_MESSAGE.getCommand()
                    + "\n"
                    + "[Insert text message here]")
        );
        keyboard.addRow(new InlineKeyboardButton("In previous menu").callbackData(backParam));

        EditMessageText editMessage = new EditMessageText(
                chatId,
                messageId,
                "Write text message in form. Please dont delete commands. You can send only text messages."
        ).replyMarkup(keyboard);

        return editMessage;
    }
}
