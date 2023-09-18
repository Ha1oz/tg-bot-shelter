package pro.sky.telegrambot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Модель отчета.
 */
@Entity(name = "reports")
@Getter
@Setter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @OneToOne
    private Photo photo;
    @OneToOne
    private User user;
    private String petType;
    private int number;

    /**
     * Создает новый экземпляр отчета.
     */
    public Report() {
    }

    /**
     * Проверяет, является ли указанный объект эквивалентным данному отчету.
     *
     * @param o объект для сравнения
     * @return true, если объекты эквивалентны, в противном случае - false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id == report.id;
    }

    /**
     * Возвращает хэш-код данного отчета.
     *
     * @return хэш-код отчета
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Возвращает строковое представление данного отчета.
     *
     * @return строковое представление отчета
     */
    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", photo=" + photo +
                ", user=" + user +
                ", petType='" + petType + '\'' +
                ", number=" + number +
                '}';
    }
}
