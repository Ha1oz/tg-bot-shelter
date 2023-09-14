package pro.sky.telegrambot.handler.callback_1_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;

public class AnswerSafetyGuideCallbackHandler implements CallbackChainHandler {
    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith(CommandType.SAFETY_GUIDE_CALLBACK.getCommand());
    }

    /**
     * Обрабатывает колбэк связанный с волонтерством и возвращает EditMessageText объект с обновленным текстом сообщения
     * или null, если колбэк не обрабатывается обработчиком.
     *
     * @param update Обновление от Telegram API
     * @return EditMessageText объект с обновленным текстом сообщения или null, если колбэк не обрабатывается обработчиком.
     */
    @Override
    public EditMessageText handle(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        Long chatId = callbackQuery.message().chat().id();
        Integer messageId = callbackQuery.message().messageId();

        String[] params = callbackQuery.data().split("_");

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Back").callbackData(CommandType.INFO_CALLBACK.getCommand()
                        + params[1])
        );

        //TODO: из БД
        String safetyGuideText = "*General safety recommendations on the territory of the shelter*:\n " +
                "\n" +
                "\n" +
                "\n" +"Visiting a shelter for children of preschool and primary school age unaccompanied by adults. "+"\n" +
                "\n" +"The presence on the territory of the shelter of children of middle and high school " +
                "age unaccompanied by adults or a written certificate-permission from parents or legal representatives" +"\n" +
                "\n"+ "Independently enter the cattery without the permission of the shelter staff|" +
                "*General safety recommendations on the territory of the shelter*:\n " +
                "\n" +
                "\n" +
                "Like every organization, our shelter also has its own rules - these are the rules of visiting the shelter\n"+
                "and behavior on the territory of the shelter. Please read and remember them! These simple rules will help both you and us!\n" +
                "\n" +
                " If you are going to the shelter for the first time, please read the additional instructions.\n" +
                "\n" +
                "Before the trip, call Victoria + 7 98432818590 or Elena Viktorovna + 7 968768554350 and warn about your arrival.\n" +
                "\n" +
                " You can see the shelter and chat with the animals on Saturday and Sunday from 11 to 16 o'clock.\n" +
                "\n" +
                "Take a change of clothes with you and dress according to the weather.\n" +
                "\n" +
                "Be sure to register in the visit log!\n" +
                "\n" +
                "While on the territory of the shelter, please observe our rules and safety precautions!\n" +
                "\n" +
                "\n" +
                "*It is prohibited:*\n" +
                "\n" +
                "Independently open paddocks and aviaries without the permission of an employee of the shelter.\n" +
                "\n" +
                "Feed the animals. This can provoke a fight. Treats are allowed only to permanent guardians and volunteers,\n" +
                "\n" +
                "while walking with animals on a leash.\n" +
                "\n" +
                "Leaving behind garbage on the territory.";


        String[] text = safetyGuideText.split("\\|");

        return switch (params[1]) {
            case "cat" -> {
                EditMessageText editMessage = new EditMessageText(
                        chatId,
                        messageId,
                        text[0]
                ).replyMarkup(keyboard);
                yield editMessage;
            }
            case "dog"-> {
                EditMessageText editMessage  = new EditMessageText(
                        chatId,
                        messageId,
                        text[1]
                ).replyMarkup(keyboard);
                yield editMessage ;
            }
            default -> throw new IllegalStateException("Unexpected value: " + params[1]);
        };
    }
}







