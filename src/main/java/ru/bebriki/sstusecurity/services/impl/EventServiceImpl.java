package ru.bebriki.sstusecurity.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.bebriki.sstusecurity.dtos.EventCreateDTO;
import ru.bebriki.sstusecurity.repositories.EventRepository;
import ru.bebriki.sstusecurity.services.EventService;
import ru.bebriki.sstusecurity.services.UserService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventServiceImpl implements EventService {
    EventRepository eventRepository;
    UserService userService;

    @Override
    public void create(EventCreateDTO eventCreateDTO) {

    }
}
