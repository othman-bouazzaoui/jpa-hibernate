package com.oth.jpa.jpa_hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class EmployeeId implements Serializable {

    int id;
    LocalDate entryDate;

    public EmployeeId() {
    }

    public EmployeeId(int id, LocalDate entryDate) {
        this.id = id;
        this.entryDate = entryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeId)) return false;
        EmployeeId employeeId = (EmployeeId) o;
        return ((employeeId.getId() == this.getId()) &&
                (Objects.equals(employeeId.getEntryDate(), this.getEntryDate())));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entryDate);
    }
}
