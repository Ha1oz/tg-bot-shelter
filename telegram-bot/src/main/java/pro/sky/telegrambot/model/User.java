package pro.sky.telegrambot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="users")
@Getter
@Setter
public class User {

    @Id
    @Setter(AccessLevel.NONE)
    private Long chatId;

    private String name;
    @OneToOne
    private Pet pet;
    private String phoneNumber;
    private String mail;

    public User() {
    }
}
