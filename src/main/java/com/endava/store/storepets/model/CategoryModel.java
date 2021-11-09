package com.endava.store.storepets.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(schema = "public", name = "\"categories\"")
public class CategoryModel extends GenericModel {

    @Builder
    public CategoryModel(UUID id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public String toString() {
        return "com.endava.store.storepets.model.CategoryModel[id=" + id + "]";
    }

}

