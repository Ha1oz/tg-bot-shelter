package pro.sky.telegrambot.handler.callback_1_level.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.entity.CommandType;
import pro.sky.telegrambot.handler.api.CallbackChainHandler;

public class AnswerAddressCallbackHandler implements CallbackChainHandler {
    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith(CommandType.ADDRESS_CALLBACK.getCommand());
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

        //TODO подтягивать текст об адресе из БД, в зависимости от выбранного варианта в меню (cat или dog)
        String addressText = "*Address*:\\n Burnakovsky passage, 16\n" +
                "Burnakovsky proezd, 16, Nizhny Novgorod, 603079.";

        EditMessageText editMessage = new EditMessageText(
                chatId,
                messageId,
                addressText
        ).replyMarkup(keyboard);
        return editMessage;
    }
}

//    StartMessageHandlerImpl StartMessageHandlerImpl = new StartMessageHandlerImpl();
//        StartMessageHandlerImpl.handle(update);
//        if (update.callbackQuery().data().equals("shelter_cats"))
//
//
//
//        {
//            EditMessageText editMessage = new EditMessageText(
//                    chatId,
//                    messageId,
//                    "Address:\nVladimir region, Kameshkovsky m.r.n., city of Kameshkovo, Kameshkovo, Korunova str., 52, p. 3, FL/ROOM 2/6."
//            );
//            return editMessage;
//
//        } else {
//            EditMessageText editMessage = new EditMessageText(
//                    chatId,
//                    messageId,
//                    "g, 52, p. 3, FL/ROOM 2/6."
//            );
//            return editMessage;
//        }
//    }







//            @Override
//        public void actionPerformed(ActionEvent e) {
//            if(){
//                allCheckBoxesSelected = false;
//                allButton.setText("Select all");
//            } else {
//                allCheckBoxesSelected = true;
//                allButton.setText("Unselect all");
//                NodeSelectionCheckBoxJDialog.this.pack();
//            }
//        }
//
//
//
//
//