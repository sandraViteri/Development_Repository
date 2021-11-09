package com.endava.store.storepets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class GenericModel implements Serializable {

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    public UUID id;
    @Basic(optional = false)
    @Column(name = "\"name\"")
    public String name;
    @Basic(optional = false)
    @Column(name = "\"description\"")
    public String description;

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GenericModel)) {
            return false;
        }
        GenericModel other = (GenericModel) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
}
