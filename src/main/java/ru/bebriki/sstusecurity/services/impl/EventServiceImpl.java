package ru.bebriki.sstusecurity.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.bebriki.sstusecurity.dtos.EventCreateDTO;
import ru.bebriki.sstusecurity.entities.Event;
import ru.bebriki.sstusecurity.entities.User;
import ru.bebriki.sstusecurity.enums.EventType;
import ru.bebriki.sstusecurity.repositories.EventRepository;
import ru.bebriki.sstusecurity.services.EventService;
import ru.bebriki.sstusecurity.services.UserService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static ru.bebriki.sstusecurity.enums.EventType.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventServiceImpl implements EventService {
    EventRepository eventRepository;
    UserService userService;

    @Override
    public void create(EventCreateDTO eventCreateDTO) {
        User user = userService.findById(eventCreateDTO.getUserId());
        Event event = Event.builder()
                .user(user)
                .image(eventCreateDTO.getImage())
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
