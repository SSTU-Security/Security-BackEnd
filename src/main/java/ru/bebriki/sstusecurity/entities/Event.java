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
@Table(name = "events")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    User user;
    String image;
    @Enumerated(EnumType.STRING)
    EventType type;
    LocalDateTime dateTime;
}
