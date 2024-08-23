package main.java.com.solvd.entities.people;

import java.util.Objects;

public class Customer extends Person {
    private String customerId;

    public Customer(String name, String address, String customerId) {
        super(name, address);
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return super.toString() + ", customerId=" + customerId + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return customerId.equals(customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerId);
    }
}
