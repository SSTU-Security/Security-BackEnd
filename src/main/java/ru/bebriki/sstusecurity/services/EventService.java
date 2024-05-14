package ru.bebriki.sstusecurity.services;

import ru.bebriki.sstusecurity.dtos.CurrentEventDataDTO;
import ru.bebriki.sstusecurity.dtos.EventCreateDTO;

public interface EventService {
    void create(EventCreateDTO eventCreateDTO);

    CurrentEventDataDTO getCurrentEventData();
}
