package ru.igo.tasklist.back.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.igo.tasklist.back.entity.Task;

import javax.websocket.server.PathParam;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT p FROM Task p where " +
            "(:title is null or :title='' or lower(p.title) like lower(concat('%', :title,'%'))) and" +
            "(:completed is null or p.completed=:completed) and " +
            "(:priorityId is null or p.priority.id=:priorityId) and " +
            "(:categoryId is null or p.category.id=:categoryId)")
    public Page<Task> findByParams(
            @PathParam("tittle") String title,
            @PathParam("completed") Integer completed,
            @PathParam("priorityId") Integer priorityId,
            @PathParam("categoryId") Integer categoryId,
            Pageable pageable
    );
}
