package pro.sky.telegrambot.handler.message;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pro.sky.telegrambot.handler.api.MessageChainHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StartMessagePhoneHandler implements MessageChainHandler {
    private Logger logger = LoggerFactory.getLogger(StartMessagePhoneHandler.class);

    /**
     * Проверяет, соответствует ли сообщение команде /start.
     *
     * @param update Обновление от Telegram API
     * @return true, если сообщение содержит команду /start, иначе false.
     */

    @Override
    public boolean check(Update update) {
        Message message = update.message();

        return message != null && message.text() != null && message.text().startsWith("9");

    }

    /**
     * Обрабатывает сообщение с командой /start и возвращает сообщение с клавиатурой выбора приюта.
     *
     * @param update Обновление от Telegram API
     * @return
     */
    @Override
    public SendMessage handle(Update update) {
        Message message = update.message();
        Long chatId = message.chat().id();

        Pattern pattern = Pattern.compile ("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");

        Matcher matcher = pattern.matcher( message.toString());
        try {
            if (!matcher.find()    &&  (message.text().length()>10) || (message.text().length()<10) ) {
                throw new IllegalStateException("Not a perfect string");
            }
        } catch (IllegalStateException e) {
            logger.error("Could not parse MAT date {}, expected format [{}].", matcher, message);
            SendMessage sendMessage = new SendMessage(chatId,
                    "Contact not saved: invalid characters or invalid number of characters");
            return sendMessage; }
        SendMessage sendMessage = new SendMessage(chatId, "OK, the contact is saved");
        return sendMessage;
    }
}



