package com.endava.store.storepets.repository;
import com.endava.store.storepets.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {
}
