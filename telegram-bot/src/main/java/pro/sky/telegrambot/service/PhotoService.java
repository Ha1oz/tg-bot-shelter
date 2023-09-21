package pro.sky.telegrambot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Photo;
import pro.sky.telegrambot.repository.PhotoRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;

    public Photo addPhoto(Photo photo) {
        return photoRepository.save(photo);
    }
    public Photo updatePhoto(Photo photo) {
        return photoRepository.save(photo);
    }
    public Optional<Photo> findPhoto(Long id) {
        return photoRepository.findById(id);
    }
    public void deletePhoto(Long id) {
        photoRepository.deleteById(id);
    }
}
