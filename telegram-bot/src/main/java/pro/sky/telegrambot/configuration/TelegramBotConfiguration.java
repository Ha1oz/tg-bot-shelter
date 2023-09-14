package pro.sky.telegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.sky.telegrambot.handler.callback_0_level.*;
import pro.sky.telegrambot.handler.callback_0_level.answer.AnswerGetCallbackHandler;
import pro.sky.telegrambot.handler.callback_0_level.answer.AnswerReportCallbackHandler;
import pro.sky.telegrambot.handler.callback_0_level.answer.AnswerStartCallbackHandler;
import pro.sky.telegrambot.handler.callback_0_level.answer.AnswerVolunteerCallbackHandler;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;
import pro.sky.telegrambot.handler.callback_1_level.*;
import pro.sky.telegrambot.handler.callback_1_level.answer.*;
import pro.sky.telegrambot.handler.api.MessageChainHandler;
import pro.sky.telegrambot.handler.message.StartMessageHandlerImpl;
import pro.sky.telegrambot.handler.message.StartMessagePhoneHandlerImpl;

import java.util.List;

/**
 * Конфигурация Telegram бота.
 */
@Configuration
public class TelegramBotConfiguration {

    @Value("${telegram.bot.token}")
    private String token;

    /**
     * Создает и настраивает экземпляр Telegram бота.
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
     * Создает список обработчиков цепочки сообщений.
     *
     * @return Список обработчиков цепочки сообщений.
     */
    @Bean
    public List<MessageChainHandler> messageChainHandlers() {
        return List.of(
                new StartMessageHandlerImpl(),
                new StartMessagePhoneHandlerImpl()
        );
    }

    /**
     * Создает список обработчиков цепочки колбэков.
     *
     * @return Список обработчиков цепочки колбэков.
     */
    @Bean
    public List<CallbackChainHandler> callbackChainHandlers() {
        return List.of(
                new ShelterCallbackHandler(),

                new AnswerVolunteerCallbackHandler(),
                new AnswerReportCallbackHandler(),
                new AnswerGetCallbackHandler(),
                new AnswerStartCallbackHandler(),

                new ShelterInfoCatCallbackHandler(),

                new AnswerAddressCallbackHandler(),
                new AnswerWorkingTimeCallbackHandler(),
                new AnswerAddressCallbackHandler(),
                new AnswerArriveCallbackHandler(),
                new AnswerPassCallbackHandler(),
                new AnswerSafetyGuideCallbackHandler(),
                new AnswerSendContactCallbackHandler(),
                new AnswerAboutShelterCallbackHandler()
        );
    }
}
