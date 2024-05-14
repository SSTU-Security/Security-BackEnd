package ru.bebriki.sstusecurity.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.bebriki.sstusecurity.dtos.CurrentEventDataDTO;
import ru.bebriki.sstusecurity.services.CurrentEventService;
import ru.bebriki.sstusecurity.services.EventService;
import ru.bebriki.sstusecurity.services.UserService;
import ru.bebriki.sstusecurity.services.ViolatorService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CurrentEventServiceImpl implements CurrentEventService {
    EventService eventService;
    ViolatorService violatorService;
    UserService userService;
    @Override
    public CurrentEventDataDTO getCurrentEventData() {
        Integer countEvents = eventService.countByDateTimeAfter();

        CurrentEventDataDTO.builder();
        return null;
    }
}
