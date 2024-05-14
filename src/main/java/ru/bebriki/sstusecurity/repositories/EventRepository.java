package ru.bebriki.sstusecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bebriki.sstusecurity.entities.Event;
import ru.bebriki.sstusecurity.enums.EventType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findFirstByUserEmailOrderByDateTimeDesc(String email);

    List<Event> findAllByDateTimeAfter(LocalDateTime dateTime);

    List<Event> findAllByDateTimeAfterAndType(LocalDateTime dateTime, EventType type);
}
