package ru.bebriki.sstusecurity.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.bebriki.sstusecurity.dtos.TaskCreateByEmailDTO;
import ru.bebriki.sstusecurity.dtos.TaskCreateDTO;
import ru.bebriki.sstusecurity.dtos.TaskDTO;
import ru.bebriki.sstusecurity.entities.Task;
import ru.bebriki.sstusecurity.entities.User;
import ru.bebriki.sstusecurity.repositories.TaskRepository;
import ru.bebriki.sstusecurity.repositories.UserRepository;
import ru.bebriki.sstusecurity.services.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    TaskRepository taskRepository;

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public void addTask(TaskCreateDTO taskCreateDTO) {
        User user = userRepository.findById(taskCreateDTO.getUserId()).orElseThrow();
        String text = taskCreateDTO.getText();
        Task task = Task.builder()
                .text(text)
                .user(user)
                .build();
        taskRepository.save(task);
    }

    @Override
    public List<TaskDTO> findAllByUserId(Long userId) {
        return null;
    }

    @Override
    public void addTask(TaskCreateByEmailDTO taskCreateDTO) {

    }

    @Override
    public List<TaskDTO> findAllByUserEmail(String email) {
        return null;
    }

    @Override
    public void deleteTaskById(Long taskId) {

    }
}
