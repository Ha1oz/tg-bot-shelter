package pro.sky.telegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.sky.telegrambot.handler.callback.CallbackChainHandler;
import pro.sky.telegrambot.handler.callback.ShelterCallbackHandler;
import pro.sky.telegrambot.handler.callback.VolunteerCallbackHandler;
import pro.sky.telegrambot.handler.message.MessageChainHandler;
import pro.sky.telegrambot.handler.message.StartMessageHandler;

import java.util.List;

/**
 * Конфигурация Telegram бота.
 */
@Configuration
public class TelegramBotConfiguration {

    @Value("${telegram.bot.token}")
    private String token;

    /**
     * Метод создает и настраивает экземпляр Telegram бота.
     *
     * @return TelegramBot объект Telegram бота.
     */
    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        return bot;
    }
    /**
     * Метод создает список обработчиков цепочки сообщений.
     *
     * @return Список обработчиков цепочки сообщений.
     */
    @Bean
    public List<MessageChainHandler> messageChainHandlers() {
        return List.of(
                new StartMessageHandler()
        );
    }

    /**
     * Метод создает список обработчиков цепочки колбэков.
     *
     * @return Список обработчиков цепочки колбэков.
     */
    @Bean
    public List<CallbackChainHandler> callbackChainHandlers() {
        return List.of(
                new ShelterCallbackHandler(),
                new VolunteerCallbackHandler()
        );
    }
}
