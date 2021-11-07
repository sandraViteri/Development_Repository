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
@Table(schema = "public", name = "\"user_types\"")
public class UserTypeModel extends GenericModel {

    @Builder
    public UserTypeModel(UUID id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UserTypeModel)) {
            return false;
        }
        UserTypeModel other = (UserTypeModel) object;
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
        return "com.endava.store.storepets.model.UserTypeModel[id=" + id + "]";
    }

}

