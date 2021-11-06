package com.endava.store.storepets.model;
import lombok.*;

import javax.persistence.*;
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
    public String toString() { return "com.endava.store.storepets.model.CategoryModel[id=" + id + "]";
    }

}

