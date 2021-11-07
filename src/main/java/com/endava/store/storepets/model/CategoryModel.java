package com.endava.store.storepets.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(schema = "public", name = "\"categories\"")
public class CategoryModel extends GenericModel {

    @Builder
    public CategoryModel(UUID id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CategoryModel)) {
            return false;
        }
        CategoryModel other = (CategoryModel) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.endava.store.storepets.model.CategoryModel[id=" + id + "]";
    }

}

