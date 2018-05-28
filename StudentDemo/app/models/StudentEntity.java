package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import play.db.jpa.Model;

@Entity
@Table(name="student")
public class StudentEntity extends Model {
	//private int id;
	
	@Column(name="name")
	@SerializedName("stu_name")
	private String name;
	
	
	@Column(name="age")
	@SerializedName("stu_age")
	private int age;
	
	@Column(name="sex")
	@SerializedName("stu_gender")
	private String gender;

	public StudentEntity(String name, int age, String gender) {
		super();
		//this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public StudentEntity()
	{
		
	}

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + "]";
	}

}
