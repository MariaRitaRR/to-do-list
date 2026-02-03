package tech.ada.java.todolistapi.service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tech.ada.java.todolistapi.dto.external.TodoListResponse;
import tech.ada.java.todolistapi.dto.external.UserListResponse;
import tech.ada.java.todolistapi.entity.Task;
import tech.ada.java.todolistapi.entity.User;
import tech.ada.java.todolistapi.enums.TaskStatus;
import tech.ada.java.todolistapi.repository.TaskRepository;
import tech.ada.java.todolistapi.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeedService {

    private final WebClient webClient;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Transactional
    @PostConstruct
    public void seed() {

        if (userRepository.count() > 0) {
            return;
        }

        try {

            UserListResponse users = webClient
                    .get()
                    .uri("/users")
                    .retrieve()
                    .bodyToMono(UserListResponse.class)
                    .block();

            if (users != null && users.getUsers() != null) {
                List<User> list = users.getUsers().stream().map(u -> {
                    User user = new User();
                    user.setFirstName(u.getFirstName());
                    user.setLastName(u.getLastName());
                    user.setEmail(u.getEmail());
                    return user;
                }).toList();

                userRepository.saveAll(list);
            }

            TodoListResponse todos = webClient
                    .get()
                    .uri("/todos")
                    .retrieve()
                    .bodyToMono(TodoListResponse.class)
                    .block();

            if (todos != null && todos.getTodos() != null) {
                List<Task> tasks = todos.getTodos().stream().map(t -> {
                    Task task = new Task();
                    task.setTitle(t.getTodo());
                    task.setDescription(null);
                    task.setStatus(t.isCompleted() ? TaskStatus.DONE : TaskStatus.TODO);
                    task.setPublic(false);

                    userRepository.findById((long) t.getUserId())
                            .ifPresent(task::setOwner);

                    return task;
                }).toList();

                taskRepository.saveAll(tasks);
            }

        } catch (Exception ex) {
            System.out.println("Seed error: " + ex.getMessage());
        }
    }
}
