package pro.sky.telegrambot.handler.message;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.entity.PetType;
import pro.sky.telegrambot.handler.api.MessageChainHandler;

/**
 * Обработчик для сообщений, содержащих команду /start.
 * Возвращает сообщение с клавиатурой выбора приюта для кошек или собак.
 */
public class StartMessageHandler implements MessageChainHandler {
    /**
     * Проверяет, соответствует ли сообщение команде /start.
     *
     * @param update Обновление от Telegram API
     * @return true, если сообщение содержит команду /start, иначе false.
     */
    @Override
    public boolean check(Update update) {
        Message message = update.message();
        return message != null && message.text() != null && message.text().contains(CommandType.START_MESSAGE.getCommand());
    }

    /**
     * Обрабатывает сообщение с командой /start и возвращает сообщение с клавиатурой выбора приюта.
     *
     * @param update Обновление от Telegram API
     * @return SendMessage объект с сообщением и клавиатурой для отправки обратно в Telegram.
     */
    @Override
    public SendMessage handle(Update update) {
        Message message = update.message();
        Long chatId = message.chat().id();
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Cats").callbackData(CommandType.SHELTER_CALLBACK.getCommand()
                        + PetType.CAT.getPet()),
                new InlineKeyboardButton("Dogs").callbackData(CommandType.SHELTER_CALLBACK.getCommand()
                        + PetType.DOG.getPet())
        );
        SendMessage sendMessage = new SendMessage(chatId, "Hello, choose your option")
                .replyMarkup(inlineKeyboard);

        return sendMessage;
    }
}
