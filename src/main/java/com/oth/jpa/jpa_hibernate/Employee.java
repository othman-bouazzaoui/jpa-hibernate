package com.oth.jpa.jpa_hibernate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Employee {

	@EmbeddedId
	private EmployeeId idPlusDate;
	private String firstName;
	private String lastName;
	private String job;
	private Double salary;

	public EmployeeId getIdPlusDate() {
		return idPlusDate;
	}

	public void setIdPlusDate(EmployeeId idPlusDate) {
		this.idPlusDate = idPlusDate;
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
		this.idPlusDate = new EmployeeId(id, dateEntry);
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"idPlusDate=" + idPlusDate +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", job='" + job + '\'' +
				", salary=" + salary +
				'}';
	}
}
