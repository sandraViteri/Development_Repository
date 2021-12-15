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
@Table(schema = "public", name = "\"invoices\"")
public class InvoiceModel {

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;


    @Basic(optional = false)
    @Column(name = "\"user\"")
    private UUID user;

    @Basic(optional = false)
    @Column(name = "\"payment_mode\"")
    private UUID paymentMode;

    @Basic(optional = false)
    @Column(name = "\"date\"")
    private Date date;

    @Basic(optional = false)
    @Column(name = "\"total_value\"")
    private Double totalValue;

    @Basic(optional = false)
    @Column(name = "\"taxes\"")
    private Double taxes;

    @Column(name = "\"discount\"")
    private Double discount;


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof InvoiceModel)) {
            return false;
        }
        InvoiceModel other = (InvoiceModel) object;
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
        return "com.endava.store.storepets.model.InvoiceModel[id=" + id + "]";
    }
}
