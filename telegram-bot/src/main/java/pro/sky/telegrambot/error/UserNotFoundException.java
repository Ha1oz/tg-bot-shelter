package pro.sky.telegrambot.error;

/**
 * Исключение, выбрасываемое при отсутствии пользователя.
 */
public class UserNotFoundException extends RuntimeException{

    /**
     * Создает новый экземпляр исключения без дополнительного сообщения.
     */
    public UserNotFoundException() {
    }

    /**
     * Создает новый экземпляр исключения с указанным сообщением.
     *
     * @param message сообщение об ошибке
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
