package pro.sky.telegrambot.error;

public class VolunteerNotFoundException extends RuntimeException{
    public VolunteerNotFoundException() {
    }

    public VolunteerNotFoundException(String message) {
        super(message);
    }
}
