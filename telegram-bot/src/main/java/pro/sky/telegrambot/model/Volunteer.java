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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

