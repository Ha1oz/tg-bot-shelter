package pro.sky.telegrambot.model.response;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.Getter;
import pro.sky.telegrambot.entity.CommandType;

public class Answer extends ResponseModel{
    public Answer(Long userId, String textMessage) {
        super(userId, textMessage);
    }

    @Override
    public SendMessage formatMessage() {
        return new SendMessage(this.userId, toStringMessageStructure());
    }

    @Override
    public String toStringMessageStructure() {
        return "Answer from volunteer:\n" +
                this.textMessage;
    }
}
