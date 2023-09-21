package pro.sky.telegrambot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Перечисление, содержащее типы питомцев.
 */
@AllArgsConstructor
@Getter
public enum PetType {
    CAT("cat"), DOG("dog");

    private final String pet;
}
