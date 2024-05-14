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

import static ru.bebriki.sstusecurity.enums.EventType.IN;
import static ru.bebriki.sstusecurity.enums.EventType.OUT;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CurrentEventServiceImpl implements CurrentEventService {
    EventService eventService;
    ViolatorService violatorService;
    UserService userService;

    @Override
    public CurrentEventDataDTO getCurrentEventData() {
        Integer in = eventService.findAllByDateTimeAfterAndType(IN).size();
        Integer out = eventService.findAllByDateTimeAfterAndType(OUT).size();
        Integer violators = violatorService.getCountOfAllViolatorsByDateTimeAfter();
        Integer countInUniversity = userService.getCountByInUniversityTrue();
        return CurrentEventDataDTO.builder()
                .people(Long.valueOf(countInUniversity))
                .in(Long.valueOf(in))
                .out(Long.valueOf(out))
                .violators(Long.valueOf(violators))
                .build();
    }
}
