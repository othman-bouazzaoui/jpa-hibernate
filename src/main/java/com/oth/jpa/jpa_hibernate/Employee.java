package com.oth.jpa.jpa_hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String job;
	private Double salary;

	@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	private EmployeeAddress address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "employees_projects",
	joinColumns = {
			@JoinColumn(name = "employee_id", referencedColumnName = "id")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "project_id", referencedColumnName = "id")
	})
	private Set<Project> projects = new HashSet<>();

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Project project) {
		this.projects.add(project);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeAddress getAddress() {
		return address;
	}

	/*
	 * I use this setter to ensure that the relation OneToOne is OK
	 */

	public void setAddress(EmployeeAddress address) {
		if (address == null) {
			if (this.address != null) {
				this.address.setEmployee(null);
			}
		} else {
			address.setEmployee(this);
		}
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Employee(String firstName, String lastName, String job, Double salary, EmployeeAddress address) {
		/*
		 * I use this setter to ensure that the relation OneToOne is OK
		 */
		if (address == null) {
			if (this.address != null) {
				this.address.setEmployee(null);
			}
		} else {
			address.setEmployee(this);
		}
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.salary = salary;
	}

	public Employee(String firstName, String lastName, String job, Double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", job='" + job + '\'' +
				", salary=" + salary +
				", address=" + address +
				", department=" + department +
				", projects=" + projects +
				'}';
	}
}
