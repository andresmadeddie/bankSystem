package com.solvd.entities.people;

import com.solvd.interfaces.*;

import java.util.Objects;

public abstract  class Person implements IEntity, IGreetable, IPayable, IReceipt, ITalk {
    public String name;
    public String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "name=" + name + ", address=" + address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name.equals(person.name) && address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
