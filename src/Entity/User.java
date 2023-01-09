package Entity;

import MyORM.Annotation.Column;
import MyORM.Annotation.Id;
import MyORM.Annotation.Table;

@Table(value="users")
public class User {
	@Id
	@Column(value="user_id")
	private int userId;
	@Column
	private int age;
	@Column(value="firstname")
	private String firstName;
	@Column(value="lastname")
	private String lastName;
	@Column
	private String address;
	@Column
	private String phone;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phone=" + phone + "]";
	}


}
