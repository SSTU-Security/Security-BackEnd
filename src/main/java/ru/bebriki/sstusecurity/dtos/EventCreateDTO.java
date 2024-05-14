package ru.bebriki.sstusecurity.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.bebriki.sstusecurity.entities.User;
import ru.bebriki.sstusecurity.enums.EventType;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventCreateDTO {
    Long userId;
    String image;
    EventType type;
    LocalDateTime dateTime;
}
