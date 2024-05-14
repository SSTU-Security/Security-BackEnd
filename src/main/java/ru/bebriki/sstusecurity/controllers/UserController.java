package ru.bebriki.sstusecurity.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.sstusecurity.dtos.TaskCreateByEmailDTO;
import ru.bebriki.sstusecurity.dtos.TaskCreateDTO;
import ru.bebriki.sstusecurity.dtos.TaskDTO;
import ru.bebriki.sstusecurity.entities.User;
import ru.bebriki.sstusecurity.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    void addHoursToTotal(@PathVariable String email, @PathVariable Double hours) {
        userService.addHoursToTotal(email, hours);
    }

    @GetMapping("/{userId}")
    ResponseEntity<User> findById(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email/{email}")
    ResponseEntity<User> findByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/addTask")
    void addTask(@RequestBody TaskCreateDTO taskCreateDTO) {
        userService.addTask(taskCreateDTO);
    }

    @GetMapping("/{userId}/tasks")
    ResponseEntity<List<TaskDTO>> findAllByUserId(@RequestBody Long userId) {
        List<TaskDTO> tasks = userService.findAllByUserId(userId);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/email/addTask")
    void addTask(@RequestBody TaskCreateByEmailDTO taskCreateDTO) {
        userService.addTask(taskCreateDTO);
    }

    @GetMapping("/email/{email}/tasks")
    ResponseEntity<List<TaskDTO>> findAllByUserEmail(String email) {
        List<TaskDTO> tasks = userService.findAllByUserEmail(email);
        return ResponseEntity.ok(tasks);

    }

    @DeleteMapping("/task/delete/{taskId}")
    void deleteTaskById(Long taskId) {
        userService.deleteTaskById(taskId);
    }
}