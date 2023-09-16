package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Модель, представляющая питомца.
 */
@Entity(name = "pets")
public class Pet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;
    private String typeOfPet;
    private String breed;
    private boolean isHealthy;

    public Pet() {

    }

    /**
     * Конструктор класса Pet.
     *
     * @param name       Имя питомца
     * @param age        Возраст питомца
     * @param typeOfPet  Тип питомца
     * @param breed      Порода питомца
     * @param isHealthy  Признак здоровья питомца
     */
    public Pet(String name, int age, String typeOfPet, String breed, boolean isHealthy) {
        this.name = name;
        this.age = age;
        this.typeOfPet = typeOfPet;
        this.breed = breed;
        this.isHealthy = isHealthy;
    }

    public Long getId() {
        return id;
    }

    /**
     * Возвращает строковое представление объекта Pet.
     *
     * @return Строковое представление объекта Pet.
     */
    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", typeOfPet='" + typeOfPet + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

    /**
     * Проверяет, равен ли данный объект Pet указанному объекту.
     *
     * @param o Объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    /**
     * Возвращает хэш-код объекта Pet.
     *
     * @return Хэш-код объекта Pet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTypeOfPet() {
        return typeOfPet;
    }

    public void setTypeOfPet(String typeOfPet) {
        this.typeOfPet = typeOfPet;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }
}
