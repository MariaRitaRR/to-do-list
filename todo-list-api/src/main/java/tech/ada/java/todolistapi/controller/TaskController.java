package tech.ada.java.todolistapi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.ada.java.todolistapi.dto.ShareRequest;
import tech.ada.java.todolistapi.dto.TaskDTO;
import tech.ada.java.todolistapi.dto.TaskResponse;
import tech.ada.java.todolistapi.entity.Task;
import tech.ada.java.todolistapi.repository.TaskRepository;
import tech.ada.java.todolistapi.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> list(@RequestParam Long userId) {
        return taskService.listVisible(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@Validated @RequestBody TaskDTO taskDTO) {
        return taskService.create(taskDTO);
    }

    @GetMapping("/{id}")
    public TaskResponse getById(@PathVariable Long id, @RequestParam Long userId) {
        return taskService.getById(id, userId);
    }

    @PutMapping("/{id}")
    public TaskResponse update(@PathVariable Long id, @RequestParam Long userId, @Validated @RequestBody TaskDTO dto) {
        return taskService.update(id, userId, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, @RequestParam Long userId) {
        taskService.delete(id, userId);
    }

    @PostMapping("/{id}/share")
    public TaskResponse share(@PathVariable Long id, @RequestParam Long userId, @RequestBody ShareRequest req) {
        return taskService.share(id, userId, req.getParticipantIds());
    }

}
