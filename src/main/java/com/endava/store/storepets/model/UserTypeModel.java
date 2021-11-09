package com.endava.store.storepets.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(schema = "public", name = "\"user_types\"")
public class UserTypeModel extends GenericModel {

    @Builder
    public UserTypeModel(UUID id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public String toString() {
        return "com.endava.store.storepets.model.UserTypeModel[id=" + id + "]";
    }

}

