package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.model.response.Answer;
import pro.sky.telegrambot.model.response.Question;
import pro.sky.telegrambot.model.response.ResponseModel;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ChattingService {
    private final VolunteerService volunteerService;

    public SendMessage getSMFromQuestion(Question response) {
        volunteerService.keepVolunteerBusy(response.getUserId(), true);
        return response.formatMessage();
    }
    public SendMessage getSMFromAnswer(Answer response) {
        volunteerService.keepVolunteerBusy(response.getUserId(), false);
        return response.formatMessage();
    }

    public Volunteer getFreeVolunteer() {
        Optional<Volunteer> optionalVolunteer = volunteerService.findFreeVolunteer();
        return optionalVolunteer.orElse(null);

    }
}
