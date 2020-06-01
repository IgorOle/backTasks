package ru.igo.tasklist.back.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskSearch {
    private String title;
    private Integer completed;
    private Integer priorityId;
    private Integer categoryId;

    private String sortColumn;
    private String sortDirection;
    private Integer pageNumber;
    private Integer pageSize;
}
