package tech.ada.java.todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.java.todolistapi.entity.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByOwnerId(Long ownerId);

    List<Task> findByParticipantsId(Long participantsId);

    List<Task> findByOwnerIdOrParticipantsId(Long ownerId, Long participantId);

    List<Task> findByDueDate(LocalDateTime dueDate);

}
