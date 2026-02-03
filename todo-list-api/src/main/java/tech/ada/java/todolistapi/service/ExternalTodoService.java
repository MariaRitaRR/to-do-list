package tech.ada.java.todolistapi.service;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tech.ada.java.todolistapi.dto.TodoItemDTO;
import tech.ada.java.todolistapi.dto.TodoListResponseDTO;

@Service
public class ExternalTodoService {

    private final WebClient webClient;

    public ExternalTodoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public TodoListResponseDTO getAllTodos() {
        return webClient.get()
                .uri("/todos")
                .retrieve()
                .bodyToMono(TodoListResponseDTO.class)
                .block();
    }

    public TodoItemDTO getTodoById(Long id) {
        return webClient.get()
                .uri("/todos/{id}", id)
                .retrieve()
                .bodyToMono(TodoItemDTO.class)
                .block();
    }
}
