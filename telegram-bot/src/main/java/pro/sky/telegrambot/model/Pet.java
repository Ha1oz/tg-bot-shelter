package pro.sky.telegrambot.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity(name = "pets")
@Getter
@Setter
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;
    private String petType;
    private String breed;
    private boolean isHealthy;

    public Pet() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", petType='" + petType + '\'' +
                ", breed='" + breed + '\'' +
                ", isHealthy=" + isHealthy +
                '}';
    }
}
