package ru.bebriki.sstusecurity.services.impl;

import io.minio.errors.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.bebriki.sstusecurity.dtos.EventCreateDTO;
import ru.bebriki.sstusecurity.entities.Event;
import ru.bebriki.sstusecurity.entities.User;
import ru.bebriki.sstusecurity.exceptions.UserNotFoundException;
import ru.bebriki.sstusecurity.enums.EventType;
import ru.bebriki.sstusecurity.photo.dtos.FileDTO;
import ru.bebriki.sstusecurity.photo.services.FileService;
import ru.bebriki.sstusecurity.repositories.EventRepository;
import ru.bebriki.sstusecurity.services.EventService;
import ru.bebriki.sstusecurity.services.UserService;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static ru.bebriki.sstusecurity.enums.EventType.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventServiceImpl implements EventService {
    EventRepository eventRepository;
    UserService userService;
    FileService fileService;

    @Override
    public Integer countByDateTimeAfter() {
        LocalDateTime time = LocalDateTime.now().minusHours(1);
        List<Event> events = eventRepository.findAllByDateTimeAfter(time);
        return events.size();
    }

    @Override
    public List<Event> findAll(Integer page, Integer size) {
        eventRepository.findAll(PageRequest.of(page, size));
        return null;
    }

    @Override
    public void create(EventCreateDTO eventCreateDTO, MultipartFile photo) throws UserNotFoundException, ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        User user = userService.findById(eventCreateDTO.getUserId());
        FileDTO file = fileService.uploadFile(photo);
        Event event = Event.builder()
                .user(user)
                .image(file.getFilename())
                .type(eventCreateDTO.getType())
                .dateTime(eventCreateDTO.getDateTime())
                .build();
        Event eventDB = eventRepository.save(event);
        EventType type = eventDB.getType();
        if (type.equals(OUT)) {
            Event eventIN = eventRepository.findFirstByUserEmailOrderByDateTimeDesc(user.getEmail()).orElseThrow();
            LocalDateTime in = eventIN.getDateTime();
            LocalDateTime out = eventDB.getDateTime();
            Double hours = ChronoUnit.MINUTES.between(in, out) / 60D;
            userService.addHoursToTotal(user.getEmail(), hours);
        }
    }
}
