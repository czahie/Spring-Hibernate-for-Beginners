package hibernate.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="first_name")
	private String fisrtName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="company")
	private String company;
	
	public Employee() {
		
	}

	public Employee(String fisrtName, String lastName, String company) {
		super();
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.company = company;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", company=" + company
				+ "]";
	}
}
