package pro.sky.telegrambot.handler.message;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartMessageHandlerTest {

    @Test
    public void testCheckShouldReturnTrueWhenMessageContainsStartCommand() {
        Update update = mock(Update.class);
        Message message = mock(Message.class);
        when(update.message()).thenReturn(message);
        when(message.text()).thenReturn("/start");

        StartMessageHandler handler = new StartMessageHandler();
        boolean result = handler.check(update);

        assertEquals(true, result);
    }

    @Test
    public void testCheckShouldReturnFalseWhenMessageDoesNotContainStartCommand() {
        Update update = mock(Update.class);
        Message message = mock(Message.class);
        when(update.message()).thenReturn(message);
        when(message.text()).thenReturn("Hello");

        StartMessageHandler handler = new StartMessageHandler();
        boolean result = handler.check(update);

        assertEquals(false, result);
    }
}