package pro.sky.telegrambot.error;

/**
 * Исключение, выбрасываемое при отсутствии отчета.
 */
public class ReportNotFoundException extends RuntimeException{

    /**
     * Создает новый экземпляр исключения без дополнительного сообщения.
     */
    public ReportNotFoundException() {
    }

    /**
     * Создает новый экземпляр исключения с указанным сообщением.
     *
     * @param message сообщение об ошибке
     */
    public ReportNotFoundException(String message) {
        super(message);
    }
}
