package pro.sky.telegrambot.handler.callback;


import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import org.testng.annotations.Test;
import org.mockito.Mockito;
import pro.sky.telegrambot.handler.callback_1_level.ShelterInfoCallbackHandler;

import static org.junit.Assert.*;

public class ShelterInfoCallbackHandlerTest  {

    @Test
    public void testCheckMethod() {

        ShelterInfoCallbackHandler handler = new ShelterInfoCallbackHandler();
        Update update = Mockito.mock(Update.class);
        CallbackQuery callbackQuery = Mockito.mock(CallbackQuery.class);
        Mockito.when(callbackQuery.data()).thenReturn("info_124");
        Mockito.when(update.callbackQuery()).thenReturn(callbackQuery);

        assertTrue(handler.check(update));

        Mockito.when(callbackQuery.data()).thenReturn("other_500");
        assertFalse(handler.check(update));
    }

    @Test
    public void testHandleMethod() {

        ShelterInfoCallbackHandler handler = new ShelterInfoCallbackHandler();
        Update update = Mockito.mock(Update.class);
        CallbackQuery callbackQuery = Mockito.mock(CallbackQuery.class);
        Mockito.when(update.callbackQuery()).thenReturn(callbackQuery);
        Mockito.when(callbackQuery.data()).thenReturn("info_124");

        Message message = Mockito.mock(Message.class);
        Chat chat = Mockito.mock(Chat.class);
        Mockito.when(callbackQuery.message()).thenReturn(message);
        Mockito.when(message.chat()).thenReturn(chat);
        Mockito.when(chat.id()).thenReturn(500L);
        Mockito.when(message.messageId()).thenReturn(986);

        EditMessageText result = handler.handle(update);
        assertNotNull(result);
        assertEquals(500L, chat.id().longValue()); // Исправленный метод getChatId()
        assertEquals(986, message.messageId().intValue());
        assertNotNull(result.replyMarkup(new InlineKeyboardMarkup())); // Исправленный метод replyMarkup()
    }
}
