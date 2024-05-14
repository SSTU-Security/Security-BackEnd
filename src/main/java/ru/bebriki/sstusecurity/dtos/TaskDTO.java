package ru.bebriki.sstusecurity.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDTO {
    Long id;
    String text;
    Long userId;
}
