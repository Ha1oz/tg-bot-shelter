package pro.sky.telegrambot.model;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity(name = "volunteers")
public class Volunteer {

    @Id
    @GeneratedValue
    private Long id;

    private Long chatId;
    private String name;

    public Volunteer() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
}

