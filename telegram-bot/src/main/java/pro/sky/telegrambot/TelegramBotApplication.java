package pro.sky.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Главный класс приложения Telegram бота.
 */
@SpringBootApplication
@EnableScheduling
public class TelegramBotApplication {
	/**
	 * Главный метод, выполняющий запуск приложения Telegram бота.
	 * @param args аргументы командной строки
	 */
	public static void main(String[] args) {
		SpringApplication.run(TelegramBotApplication.class, args);
	}


}
