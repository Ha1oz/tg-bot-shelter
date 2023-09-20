package pro.sky.telegrambot.handler.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pro.sky.telegrambot.error.ReportNotFoundException;
import pro.sky.telegrambot.error.UserNotFoundException;
import pro.sky.telegrambot.error.VolunteerNotFoundException;

import java.io.IOException;

/**
 * Глобальный обработчик исключений для REST контроллеров.
 */
@RestControllerAdvice
public class RestExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * Обрабатывает исключение ReportNotFoundException.
     *
     * @param e исключение ReportNotFoundException
     * @return объект ResponseEntity с сообщением об ошибке и статусом NOT_FOUND
     */
    @ExceptionHandler(ReportNotFoundException.class)
    public ResponseEntity<Object> handleReportNotFoundException(ReportNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Report is not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * Обрабатывает исключение IOException.
     *
     * @param e исключение IOException
     * @return объект ResponseEntity с сообщением об ошибке и статусом NOT_FOUND
     */
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleIOException(IOException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Report data is not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * Обрабатывает исключение UserNotFoundException.
     *
     * @param e исключение UserNotFoundException
     * @return объект ResponseEntity с сообщением об ошибке и статусом NOT_FOUND
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("User is not found.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(VolunteerNotFoundException.class)
    public ResponseEntity<Object> handleVolunteerNotFoundException(VolunteerNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Volunteer is not found.", HttpStatus.NOT_FOUND);
    }
}
