package pro.sky.telegrambot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PetType {
    CAT("cat"), DOG("dog");

    private final String pet;
}
