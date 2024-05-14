package ru.bebriki.sstusecurity.services;

import ru.bebriki.sstusecurity.dtos.ViolatorCreateDTO;

public interface ViolatorService {
    void create(ViolatorCreateDTO violatorCreateDTO);

    int getCountOfAllViolatorsByDateTimeAfter();
}
