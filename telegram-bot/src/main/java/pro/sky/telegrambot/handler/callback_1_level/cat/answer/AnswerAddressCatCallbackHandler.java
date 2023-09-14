package pro.sky.telegrambot.handler.callback_1_level.cat.answer;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.EditMessageText;
import pro.sky.telegrambot.handler.callback_0_level.CallbackChainHandler;

//import static jdk.internal.org.jline.terminal.Terminal.MouseTracking.Button;

public class AnswerAddressCatCallbackHandler implements CallbackChainHandler {
    /**
     * Проверяет, соответствует ли колбэк необходимым условиям обработчика волонтерства.
     *
     * @param update Обновление от Telegram API
     * @return true, если колбэк соответствует условиям обработчика волонтерства, иначе false.
     */
    @Override
    public boolean check(Update update) {
        CallbackQuery callbackQuery = update.callbackQuery();
        return callbackQuery != null && callbackQuery.data().startsWith("address_cat");
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
        EditMessageText editMessage = new EditMessageText(
                chatId,
                messageId,
                "*Address*:\\n Burnakovsky passage, 16\n" +
                        "Burnakovsky proezd, 16, Nizhny Novgorod, 603079."
        );
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
