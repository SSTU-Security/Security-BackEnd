package ru.bebriki.sstusecurity.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.bebriki.sstusecurity.enums.EventType;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ViolatorCreateDTO {
    String image;
    EventType type;
    LocalDateTime dateTime;
}
