package com.company.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers_tbl")
public class Customer {
    @Id
    @Column(name="cust_id")
    private int customerId;

    @Column(name="cust_name")
    private String customerName;

    @Column(name="cust_email")
    private String customerEmailAddress;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="CustomerSubscriptionLink",
            joinColumns={@JoinColumn(name="cid")},
            inverseJoinColumns={@JoinColumn(name="sid")})
    Set<Subscription> subscriptions = new HashSet<Subscription>();

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
/*
Customer                                            Subscription
cust_id cust_name  cust_email                       sub_id  sub_type  sub_duration
101     Arun        ..                                  1   Books       1 month
102     Ramji          ..                               2   Dvds        3 months
103     Piyush      ..

CustomerSubscriptionLink
    fk      fk
    cid     sid
    101     1
    103     2
    101     2
    102     1
    102     2
    103     1


 */
