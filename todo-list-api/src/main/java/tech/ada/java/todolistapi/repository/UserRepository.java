package tech.ada.java.todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.java.todolistapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
