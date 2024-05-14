package ru.bebriki.sstusecurity.controllers;

import io.minio.errors.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.bebriki.sstusecurity.dtos.EventCreateDTO;
import ru.bebriki.sstusecurity.entities.Event;
import ru.bebriki.sstusecurity.exceptions.UserNotFoundException;
import ru.bebriki.sstusecurity.services.EventService;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventController {
    EventService eventService;

    @PostMapping
    void create(@RequestPart EventCreateDTO eventCreateDTO, @RequestPart MultipartFile photo) throws UserNotFoundException, ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        eventService.create(eventCreateDTO, photo);
    }

    @GetMapping("/{page}/{size}")
    ResponseEntity<List<Event>> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        List<Event> events = eventService.findAll(page, size);
        return ResponseEntity.ok(events);
    }
}
