package ru.igo.tasklist.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.igo.tasklist.back.entity.Priority;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
