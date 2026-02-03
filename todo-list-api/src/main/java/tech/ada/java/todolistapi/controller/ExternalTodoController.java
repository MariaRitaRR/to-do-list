package tech.ada.java.todolistapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.java.todolistapi.dto.TodoItemDTO;
import tech.ada.java.todolistapi.dto.TodoListResponseDTO;
import tech.ada.java.todolistapi.service.ExternalTodoService;

@RestController
@RequestMapping("/api/external/todos")
@RequiredArgsConstructor
public class ExternalTodoController {
    private final ExternalTodoService externalTodoService;


    @GetMapping
    public TodoListResponseDTO all() {
        return externalTodoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoItemDTO getById(@PathVariable Long id) {
        return externalTodoService.getTodoById(id);
    }
}
