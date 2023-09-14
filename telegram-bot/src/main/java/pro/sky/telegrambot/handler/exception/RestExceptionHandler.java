package pro.sky.telegrambot.handler.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pro.sky.telegrambot.error.ReportNotFoundException;
import pro.sky.telegrambot.error.UserNotFoundException;

import java.io.IOException;

@RestControllerAdvice
public class RestExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(ReportNotFoundException.class)
    public ResponseEntity<Object> handleReportNotFoundException(ReportNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Report is not found.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleIOException(IOException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Report data is not found.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("User is not found.", HttpStatus.NOT_FOUND);
    }
}
