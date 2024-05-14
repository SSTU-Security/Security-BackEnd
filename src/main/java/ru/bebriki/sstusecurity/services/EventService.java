package ru.bebriki.sstusecurity.services;

import ru.bebriki.sstusecurity.dtos.EventCreateDTO;

public interface EventService {
    void create(EventCreateDTO eventCreateDTO);
}
