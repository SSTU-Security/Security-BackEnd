package ru.bebriki.sstusecurity.services;

import ru.bebriki.sstusecurity.dtos.TaskCreateByEmailDTO;
import ru.bebriki.sstusecurity.dtos.TaskCreateDTO;
import ru.bebriki.sstusecurity.dtos.TaskDTO;
import ru.bebriki.sstusecurity.entities.User;

import java.util.List;

public interface UserService {
    User findById(Long userId);

    User findByEmail(String email);

    void addTask(TaskCreateDTO taskCreateDTO);

    List<TaskDTO> findAllByUserId(Long userId);

    void addTask(TaskCreateByEmailDTO taskCreateDTO);

    List<TaskDTO> findAllByUserEmail(String email);

    void deleteTaskById(Long taskId);
}
