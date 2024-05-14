package ru.bebriki.sstusecurity.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateByEmailDTO {
    String text;
    String email;
}
