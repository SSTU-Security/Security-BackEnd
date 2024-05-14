package ru.bebriki.sstusecurity.services;

import ru.bebriki.sstusecurity.dtos.TaskCreateByEmailDTO;
import ru.bebriki.sstusecurity.dtos.TaskCreateDTO;
import ru.bebriki.sstusecurity.dtos.TaskDTO;
import ru.bebriki.sstusecurity.entities.User;
import ru.bebriki.sstusecurity.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
<<<<<<< HEAD
    User findById(Long userId) throws UserNotFoundException;
=======
    void addHoursToTotal(String email, Double hours);
    User findById(Long userId);
>>>>>>> oleg

    User findByEmail(String email) throws UserNotFoundException;

    void addTask(TaskCreateDTO taskCreateDTO);

    List<TaskDTO> findAllByUserId(Long userId);

    void addTask(TaskCreateByEmailDTO taskCreateDTO);

    List<TaskDTO> findAllByUserEmail(String email);

    void deleteTaskById(Long taskId);
}
