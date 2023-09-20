package pro.sky.telegrambot.model.response;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.Getter;
import pro.sky.telegrambot.entity.CommandType;
public class Question extends ResponseModel {
    private final Long fromId;
    public Question(Long fromId, Long toId, String textMessage) {
        super(toId, textMessage);
        this.fromId = fromId;
    }

    //TODO: add some parameters like questionTime for more details


    @Override
    public SendMessage formatMessage() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(
                new InlineKeyboardButton("Answer Form").switchInlineQueryCurrentChat(
                        CommandType.ANSWER_QUESTION_MESSAGE.getCommand()
                                + this.fromId + "\n" +
                                "[Write answer for question]"
                )
        );
        SendMessage sendMessage = new SendMessage(this.userId, toStringMessageStructure())
                .replyMarkup(keyboardMarkup);

        return sendMessage;
    }

    @Override
    public String toStringMessageStructure() {
        return "Question from user:\n" +
                textMessage;
    }
}
