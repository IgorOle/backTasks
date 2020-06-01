package ru.igo.tasklist.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.igo.tasklist.back.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
