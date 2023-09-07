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

@Configuration
public class TelegramBotConfiguration {

    @Value("${telegram.bot.token}")
    private String token;

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        return bot;
    }
    @Bean
    public List<MessageChainHandler> messageChainHandlers() {
        return List.of(
                new StartMessageHandler()
        );
    }
    @Bean
    public List<CallbackChainHandler> callbackChainHandlers() {
        return List.of(
                new ShelterCallbackHandler(),
                new VolunteerCallbackHandler()
        );
    }

}
