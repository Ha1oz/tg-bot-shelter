package pro.sky.telegrambot.handler.callback_0_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.entity.PetType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;

/**
 * Обработчик коллбэков для стартовой команды.  */
public class AnswerStartCallbackHandler implements CallbackChainHandler {

    /**
     * Проверяет, соответствует ли коллбэк стартовой команде.      *
     * @param update объект Update из Telegram
     * @return true, если коллбэк соответствует стартовой команде, в противном случае - false
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith(CommandType.START_CALLBACK.getCommand());
    }

    /**
     * Обрабатывает коллбэк для стартовой команды и возвращает сообщение для редактирования.
     * @param update объект Update из Telegram
     * @return объект EditMessageText для редактирования сообщения
     */
    @Override
    public EditMessageText handle(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        Long chatId = callbackQuery.message().chat().id();
        Integer messageId = callbackQuery.message().messageId();

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Cats").callbackData(CommandType.SHELTER_CALLBACK.getCommand()
                        + PetType.CAT.getPet()),
                new InlineKeyboardButton("Dogs").callbackData(CommandType.SHELTER_CALLBACK.getCommand()
                        + PetType.DOG.getPet())
        );
        EditMessageText editMessageText = new EditMessageText(chatId, messageId, "Choose your option")
                .replyMarkup(inlineKeyboard);

        return editMessageText;
    }
}
