package com.solvd.entities.people;

import java.util.Objects;

public class Employee extends Person {
    private final String jobPosition;

    public Employee(String name, String address, String JobPosition) {
        super(name, address);
        this.jobPosition = JobPosition;
    }

    @Override
    public String toString() {
        return super.toString() + ", jobPosition=" + jobPosition + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return jobPosition.equals(employee.jobPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jobPosition);
    }
}
