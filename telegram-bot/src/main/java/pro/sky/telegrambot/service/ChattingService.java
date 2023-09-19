package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.model.response.ResponseModel;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ChattingService {
    private final VolunteerService volunteerService;

    public SendMessage getSMFromResponse(ResponseModel responseModel) {
        return responseModel.formatMessage();
    }

    public Volunteer getFreeVolunteer() {
        //TODO: check free volunteer
        // Now is very bad code
        Optional<Volunteer> optionalVolunteer = volunteerService.findVolunteerByRandom();
        return optionalVolunteer.orElse(null);

    }
}
