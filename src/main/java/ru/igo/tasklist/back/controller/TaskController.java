package ru.igo.tasklist.back.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.igo.tasklist.back.entity.Task;
import ru.igo.tasklist.back.model.TaskSearch;
import ru.igo.tasklist.back.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Task> add(@RequestBody Task task) {
        Task save = taskRepository.save(task);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/save")
    public ResponseEntity<Task> save(@RequestBody Task task) {
        Task save = taskRepository.save(task);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/all")
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Task>> search(@RequestBody TaskSearch taskSearch) {
        String title = taskSearch.getTitle() != null ? taskSearch.getTitle() : null;
        Integer completed = taskSearch.getCompleted() != null ? taskSearch.getCompleted() : null;
        Integer priorityId = taskSearch.getPriorityId() != null ? taskSearch.getPriorityId() : null;
        Integer categoryId = taskSearch.getCategoryId() != null ? taskSearch.getCategoryId() : null;
        String sortColumn = taskSearch.getSortColumn() != null ? taskSearch.getSortColumn() : "title";
        String sortDirection = taskSearch.getSortDirection() != null ? taskSearch.getSortDirection() : null;
        Integer pageNumber = taskSearch.getPageNumber() != null ? taskSearch.getPageNumber() : null;
        Integer pageSize = taskSearch.getPageSize() != null ? taskSearch.getPageSize() : null;
        
        Sort.Direction direction =
                sortDirection == null || sortDirection.trim().equalsIgnoreCase("asc")
                ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortColumn);

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        Page<Task> byParams = taskRepository.findByParams(title, completed, priorityId, categoryId, pageRequest);
        return ResponseEntity.ok(byParams);
    }
}
