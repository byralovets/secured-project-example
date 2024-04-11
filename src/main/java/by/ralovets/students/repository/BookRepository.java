package by.ralovets.students.repository;

import by.ralovets.students.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<User, Long> {

}
