package pro.sky.telegrambot.error;

public class ReportNotFoundException extends RuntimeException{
    public ReportNotFoundException() {
    }

    public ReportNotFoundException(String message) {
        super(message);
    }
}
