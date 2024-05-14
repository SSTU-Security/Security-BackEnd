package ru.bebriki.sstusecurity.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bebriki.sstusecurity.dtos.CurrentEventDataDTO;
import ru.bebriki.sstusecurity.services.CurrentEventService;

@RestController
@RequestMapping("/current")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CurrentEventController {
    CurrentEventService currentEventService;

    ResponseEntity<CurrentEventDataDTO> current() {
        CurrentEventDataDTO current = currentEventService.getCurrentEventData();
        return ResponseEntity.ok(current);
    }
}
