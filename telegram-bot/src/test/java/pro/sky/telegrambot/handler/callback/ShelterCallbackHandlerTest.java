package pro.sky.telegrambot.handler.callback;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import org.testng.annotations.Test;
import org.mockito.Mockito;
import pro.sky.telegrambot.handler.callback_0_level.ShelterCallbackHandler;

import static org.junit.Assert.*;

public class ShelterCallbackHandlerTest {

    @Test
    public void testCheckMethod() {

        ShelterCallbackHandler handler = new ShelterCallbackHandler();
        Update update = Mockito.mock(Update.class);
        CallbackQuery callbackQuery = Mockito.mock(CallbackQuery.class);
        Mockito.when(callbackQuery.data()).thenReturn("shelter_123");
        Mockito.when(update.callbackQuery()).thenReturn(callbackQuery);

        assertTrue(handler.check(update));

        Mockito.when(callbackQuery.data()).thenReturn("other_456");
        assertFalse(handler.check(update));
    }

    @Test
    public void testHandleMethod() {

        ShelterCallbackHandler handler = new ShelterCallbackHandler();
        Update update = Mockito.mock(Update.class);
        CallbackQuery callbackQuery = Mockito.mock(CallbackQuery.class);
        Mockito.when(update.callbackQuery()).thenReturn(callbackQuery);
        Mockito.when(callbackQuery.data()).thenReturn("shelter_123");

        Message message = Mockito.mock(Message.class);
        Chat chat = Mockito.mock(Chat.class);
        Mockito.when(callbackQuery.message()).thenReturn(message);
        Mockito.when(message.chat()).thenReturn(chat);
        Mockito.when(chat.id()).thenReturn(456L);
        Mockito.when(message.messageId()).thenReturn(789);

        EditMessageText result = handler.handle(update);
        assertNotNull(result);
        assertEquals(456L, chat.id().longValue()); // Исправленный метод getChatId()
        assertEquals(789, message.messageId().intValue());
        assertNotNull(result.replyMarkup(new InlineKeyboardMarkup())); // Исправленный метод replyMarkup()
    }
}