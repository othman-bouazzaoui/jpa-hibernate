package com.oth.jpa.jpa_hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Entity
@IdClass(EmployeeId.class)
public class Employee {

	@Id
	private int id;
	@Id
	private LocalDate entryDate;
	private String firstName;
	private String lastName;
	private String job;
	private Double salary;

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

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Employee() {
		
	}
	
	public Employee(int id, LocalDate dateEntry, String firstName, String lastName, String job, Double salary) {
		this.id = id;
		this.entryDate = dateEntry;
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", dateEntry=" + entryDate +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", job='" + job + '\'' +
				", salary=" + salary +
				'}';
	}
}
