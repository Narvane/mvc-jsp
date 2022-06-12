package com.narvane.singleprojects.mvcjsp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tbl_order")
public class Order extends EntityWithUUID {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private List<Sale> sales;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    public Order() {
    }

    public Order(UUID id) {
        super(id);
    }

    public void addSale(Sale sale) {
        if (sale == null) sales = new ArrayList<>();

        if (sale != null) {
            sale.setOrder(this);
            sales.add(sale);
        }
    }

    public List<Sale> getSales() {
        return sales;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
