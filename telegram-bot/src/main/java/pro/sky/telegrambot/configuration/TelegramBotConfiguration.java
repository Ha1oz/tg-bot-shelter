package pro.sky.telegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.sky.telegrambot.handler.callback_0_level.*;
import pro.sky.telegrambot.handler.callback_0_level.answer.AnswerGetCallbackHandlerImpl;
import pro.sky.telegrambot.handler.callback_0_level.answer.AnswerReportCallbackHandlerImpl;
import pro.sky.telegrambot.handler.callback_0_level.answer.AnswerVolunteerCallbackHandlerImpl;
import pro.sky.telegrambot.handler.callback_1_level.cat.ShelterInfoCatCallbackHandler;
import pro.sky.telegrambot.handler.callback_1_level.cat.answer.*;
import pro.sky.telegrambot.handler.callback_1_level.dog.ShelterInfoDogCallbackHandler;
import pro.sky.telegrambot.handler.callback_1_level.dog.answer.*;
import pro.sky.telegrambot.handler.message_.MessageChainHandler;
import pro.sky.telegrambot.handler.message_.MessageChainHandlerReg;
import pro.sky.telegrambot.handler.message_.StartMessageHandlerImpl;
import pro.sky.telegrambot.handler.message_.StartMessagePhoneHandlerImpl;

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
                new StartMessageHandlerImpl()

//                new StartMessageInfoHandlerImpl()
        );
    }

    @Bean
    public List<MessageChainHandlerReg> messageChainHandlersReg() {
        return List.of(
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
                new ShelterCatCallbackHandlerImpl(),
                new  ShelterDogCallbackHandlerImpl(),

                new AnswerVolunteerCallbackHandlerImpl(),
                new AnswerReportCallbackHandlerImpl(),
                new AnswerGetCallbackHandlerImpl(),

                new ShelterInfoCatCallbackHandler(),
                new ShelterInfoDogCallbackHandler(),



                new AnswerOurShelterDogCallbackHandlerImpl(),
                new AnswerScheduleDogCallbackHandler(),
                new AnswerAddressDogCallbackHandler(),
                new AnswerDrivingDogCallbackHandler(),
                new AnswerOurContactsDogCallbackHandler(),
                new AnswerRecommendationsDogCallbackHandler(),
                new AnswerAcceptDogCallbackHandler(),

                new AnswerAddressCatCallbackHandler(),



                new AnswerScheduleCatCallbackHandler(),
                new AnswerAddressCatCallbackHandler(),
                new AnswerDrivingCatCallbackHandler(),
                new AnswerOurContactsCatCallbackHandler(),
                new AnswerRecommendationsCatCallbackHandler(),
                new AnswerAcceptCatCallbackHandler(),
                new AnswerOurShelterCatCallbackHandlerImpl()



        );
    }
}
