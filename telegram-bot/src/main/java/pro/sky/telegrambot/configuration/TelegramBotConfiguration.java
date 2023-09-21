package pro.sky.telegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Autowired;
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

import pro.sky.telegrambot.handler.callback_2_level.ShelterGetPetCallbackHandler;
import pro.sky.telegrambot.handler.callback_2_level.answer.*;

import pro.sky.telegrambot.handler.message.*;

import pro.sky.telegrambot.service.*;


import java.util.List;

/**
 * Конфигурация Telegram бота.
 */
@Configuration
public class TelegramBotConfiguration {

    @Autowired
    private UserService userService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private ChattingService chattingService;

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
                new StartMessageHandler(),
                new StartMessagePhoneHandler(),
                new ReportMessageHandler(userService, photoService, reportService, telegramBot()),
                new CallVolunteerMessageHandler(chattingService, telegramBot()),
                new AnswerClientMessageHandler(chattingService, telegramBot())

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

                new ShelterInfoCallbackHandler(),

                new AnswerAddressCallbackHandler(),
                new AnswerWorkingTimeCallbackHandler(),
                new AnswerAddressCallbackHandler(),
                new AnswerArriveCallbackHandler(),
                new AnswerPassCallbackHandler(),
                new AnswerSafetyGuideCallbackHandler(),
                new AnswerSendContactCallbackHandler(),
          
                new AnswerAboutShelterCallbackHandler(),

                new ShelterGetPetCallbackHandler(),

                new AnswerRulesForMeetingAnimal(),
                new AnswerDocumentsForAdoptAnimal(),
                new AnswerRecommendationsForTransportingAnimal(),
                new AnswerArrangeForAnAdultAnimal(),
                new AnswerArrangeForPuppy(),
                new AnswerArrangeForKitten(),
                new AnswerProvenDogHandlers(),
                new AnswerAdviceFromADogHandler(),
                new AnswerArrangeForAnAnimalWithDisabilities(),
                new AnswerReasonForRefusal()
        );
    }
}
