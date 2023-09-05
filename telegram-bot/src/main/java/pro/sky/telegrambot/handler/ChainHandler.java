package pro.sky.telegrambot.handler;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public interface ChainHandler {
    boolean check(Update update);
    SendMessage handle(Update update);
}
