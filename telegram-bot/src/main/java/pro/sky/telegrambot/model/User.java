package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class User {

    @Id
    private Long chatId;

    private String name;
    private Long petId;
    private String phoneNumber;
    private String mail;

}
