package ru.bebriki.sstusecurity.services;

import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;
import ru.bebriki.sstusecurity.dtos.EventCreateDTO;
import ru.bebriki.sstusecurity.entities.Event;
import ru.bebriki.sstusecurity.enums.EventType;
import ru.bebriki.sstusecurity.exceptions.UserNotFoundException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    List<Event> findAll(Integer page, Integer size);

    Integer countByDateTimeAfter();

    List<Event> findAllByDateTimeAfterAndType(LocalDateTime dateTime, EventType type);


    void create(EventCreateDTO eventCreateDTO, MultipartFile photo) throws UserNotFoundException, ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;
}
