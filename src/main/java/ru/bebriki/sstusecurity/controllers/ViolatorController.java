package ru.bebriki.sstusecurity.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.sstusecurity.dtos.ViolatorCreateDTO;
import ru.bebriki.sstusecurity.services.ViolatorService;

@CrossOrigin
@RestController
@RequestMapping("/violators")
@RequiredArgsConstructor
public class ViolatorController {

    private final ViolatorService violatorService;

    @PostMapping
    public void saveViolator(@RequestBody ViolatorCreateDTO violatorCreateDTO) {
        violatorService.create(violatorCreateDTO);
    }

    @GetMapping("/time-after")
    public ResponseEntity<Integer> getCountOfAllViolatorsByDateTimeAfter() {
        return new ResponseEntity<>(violatorService.getCountOfAllViolatorsByDateTimeAfter(), HttpStatus.OK);
    }

}
