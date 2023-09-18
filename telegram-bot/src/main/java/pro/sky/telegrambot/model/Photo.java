package pro.sky.telegrambot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Photo {
    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Long id;
    private long fileSize;
    private String mediaType;
    private byte[] data;

    /**
     * Проверяет, является ли указанный объект эквивалентным данной фотографии.
     *
     * @param o объект для сравнения
     * @return true, если объекты эквивалентны, в противном случае - false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id);
    }

    /**
     * Возвращает хэш-код данной фотографии.
     *
     * @return хэш-код фотографии
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Возвращает строковое представление данной фотографии.
     *
     * @return строковое представление фотографии
     */
    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", fileSize=" + fileSize +
                ", mediaType='" + mediaType + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
