package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.handler.callback.CallbackChainHandler;
import pro.sky.telegrambot.handler.message.MessageChainHandler;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

    @Autowired
    private List<MessageChainHandler> messageChainHandlers;
    @Autowired
    private List<CallbackChainHandler> callbackChainHandlers;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            // Process your updates here
            messageChainHandlers.stream()
                    .filter(h -> h.check(update))
                    .forEach(h -> {
                        SendMessage message = h.handle(update);
                        telegramBot.execute(message);
            });

            callbackChainHandlers.stream()
                    .filter(h -> h.check(update))
                    .forEach(h -> {
                        EditMessageText message = h.handle(update);
                        telegramBot.execute(message);
                    });
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
