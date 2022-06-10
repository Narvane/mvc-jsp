package com.narvane.singleprojects.mvcjsp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_client")
public class Client extends EntityWithUUID {

    private String name;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
