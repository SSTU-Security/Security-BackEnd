package ru.bebriki.sstusecurity.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.bebriki.sstusecurity.enums.EventType;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "violators")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Violator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String image;
    EventType type;
    LocalDateTime dateTime;
}
