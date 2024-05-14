package ru.bebriki.sstusecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bebriki.sstusecurity.dtos.TaskDTO;
import ru.bebriki.sstusecurity.entities.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUserId(Long userId);

    List<Task> findAllByUserEmail(String email);

}
