package com.endava.store.storepets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(schema = "public", name = "\"users\"")
public class UsersModel{

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    @Basic(optional = false)
    @Column(name = "\"id_number\"")
    private String idNumber;
    @Basic(optional = false)
    @Column(name = "\"id_number_type\"")
    private String idNumberType;
    @Basic(optional = false)
    @Column(name = "\"name\"")
    private String name;
    @Basic(optional = false)
    @Column(name = "\"lastname\"")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "\"address\"")
    private String address;
    @Basic(optional = false)
    @Column(name = "\"birthday_date\"")
    private Date birthdayDay;
    @Column(name = "\"email_address\"")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "\"type\"")
    private UUID type;
    @Column(name = "\"phone\"")
    private String phone;

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsersModel)) {
            return false;
        }
        UsersModel other = (UsersModel) object;
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
        return "com.endava.store.storepets.model.UsersModel[id=" + id + "]";
    }
}
