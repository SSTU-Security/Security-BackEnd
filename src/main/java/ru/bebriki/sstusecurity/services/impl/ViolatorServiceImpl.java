package ru.bebriki.sstusecurity.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.bebriki.sstusecurity.dtos.ViolatorCreateDTO;
import ru.bebriki.sstusecurity.entities.Violator;
import ru.bebriki.sstusecurity.repositories.ViolatorRepository;
import ru.bebriki.sstusecurity.services.ViolatorService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ViolatorServiceImpl implements ViolatorService {
    ViolatorRepository violatorRepository;

    @Override
    public void create(ViolatorCreateDTO violatorCreateDTO) {
        Violator violator = Violator.builder()
                .image(violatorCreateDTO.getImage())
                .type(violatorCreateDTO.getType())
                .dateTime(violatorCreateDTO.getDateTime())
                .build();
        violatorRepository.save(violator);
    }
}
