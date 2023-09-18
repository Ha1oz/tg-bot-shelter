package pro.sky.telegrambot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Long id;
    private Long chatId;

    private String name;
    private String phoneNumber;
    private String mail;

    public User() {
    }
}
