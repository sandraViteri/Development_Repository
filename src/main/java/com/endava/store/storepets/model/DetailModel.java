package com.endava.store.storepets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(schema = "public", name = "\"details\"")
public class DetailModel {

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Basic(optional = false)
    @Column(name = "\"invoice\"")
    private UUID invoice;

    @Basic(optional = false)
    @Column(name = "\"product\"")
    private UUID product;

    @Basic(optional = false)
    @Column(name = "\"amount\"")
    private int amount;

    @Basic(optional = false)
    @Column(name = "\"value\"")
    private Double value;

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetailModel)) {
            return false;
        }
        DetailModel other = (DetailModel) object;
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
        return "com.endava.store.storepets.model.DetailModel[id=" + id + "]";
    }
}
