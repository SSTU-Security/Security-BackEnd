package ru.bebriki.sstusecurity.services;

import ru.bebriki.sstusecurity.dtos.EventCreateDTO;
import ru.bebriki.sstusecurity.exceptions.UserNotFoundException;

public interface EventService {
    void create(EventCreateDTO eventCreateDTO) throws UserNotFoundException;
}
