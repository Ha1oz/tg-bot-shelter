package pro.sky.telegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.sky.telegrambot.handler.ChainHandler;
import pro.sky.telegrambot.handler.ShelterHandler;
import pro.sky.telegrambot.handler.StartHandler;

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
    public List<ChainHandler> chainHandlers() {
        return List.of(
                new StartHandler(),
                new ShelterHandler()
        );
    }

}
