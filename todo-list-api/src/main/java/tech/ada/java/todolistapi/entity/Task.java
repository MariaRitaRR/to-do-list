package tech.ada.java.todolistapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import tech.ada.java.todolistapi.enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(length = 2000)
    private String description;
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)//para salvar a String
    private TaskStatus status;

    private boolean isPublic;//apenas o dono vizualiza

    @ManyToOne
    private User owner;

    @ManyToMany
    @JoinTable(name = "taks_participants",
            joinColumns = @JoinColumn(name ="task_id"),
            inverseJoinColumns  = @JoinColumn(name = "user_id"))
    private List<User> participants =  new ArrayList<>();


}
