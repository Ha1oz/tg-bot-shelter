package pro.sky.telegrambot.model.response;

import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class ResponseModel {
    protected Long userId;
    protected String textMessage;

    public abstract SendMessage formatMessage();

    public abstract String toStringMessageStructure();
}
