package ru.bebriki.sstusecurity.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCreateDTO {
    String text;
    Long userId;
}
