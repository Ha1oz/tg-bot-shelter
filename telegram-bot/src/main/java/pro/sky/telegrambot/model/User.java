package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Модель, представляющая пользователя.
 */
@Entity(name = "users")
public class User {

    @Id
    private Long chatId;

    private String name;
    private Long petId;
    private String phoneNumber;

    public User() {
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
