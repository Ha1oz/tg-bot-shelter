package pro.sky.telegrambot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Photo;
import pro.sky.telegrambot.repository.PhotoRepository;

import java.util.Optional;

/**
 * Сервис для управления данными о фотографиях.
 */
@Service
@AllArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;

    /**
     * Добавляет фотографию в базу данных.
     *
     * @param photo Объект фотографии для добавления.
     * @return Добавленный объект фотографии.
     */
    public Photo addPhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    /**
     * Обновляет информацию о фотографии.
     *
     * @param photo Объект фотографии с обновленными данными.
     * @return Обновленный объект фотографии.
     */
    public Photo updatePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    /**
     * Ищет фотографию по ее идентификатору.
     *
     * @param id Идентификатор фотографии.
     * @return Optional с объектом фотографии, если найден, иначе пустой Optional.
     */
    public Optional<Photo> findPhoto(Long id) {
        return photoRepository.findById(id);
    }

    /**
     * Удаляет фотографию из базы данных.
     *
     * @param id Идентификатор фотографии для удаления.
     */
    public void deletePhoto(Long id) {
        photoRepository.deleteById(id);
    }
}
