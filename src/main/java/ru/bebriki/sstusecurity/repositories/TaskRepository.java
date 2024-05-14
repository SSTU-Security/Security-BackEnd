package ru.bebriki.sstusecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bebriki.sstusecurity.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
