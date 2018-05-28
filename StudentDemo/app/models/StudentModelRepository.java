package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import play.db.jpa.JPA;

public class StudentModelRepository {
	static Map<Integer, StudentModel> map = new HashMap<Integer, StudentModel>();
	static StudentEntity studentEntity=null;
	static 
	{	
		map.put(1, new StudentModel(1,"sahil",24,"male"));
		map.put(2, new StudentModel(2,"ahil",25,"male"));
		map.put(3, new StudentModel(3,"Motu",26,"female"));
		map.put(4, new StudentModel(4,"sona",27,"female"));
		
	}

	public static StudentModel readStudentDetails(int sid) {
		return map.get(sid);
		
	}

	public static void insertInMap(StudentModel studentModel) {
		map.put(studentModel.getId(), studentModel);
		System.out.println(map);
		
	}

	public static void insertInDB(StudentEntity studentEntity) {
		//StudentEntity studentEntity2=new StudentEntity(1, "sahil", 24, "amle");
		studentEntity.save();
		
	}

	public static StudentEntity readDataFromDB(Long sid) {
		
		studentEntity=studentEntity.findById(sid);
		//System.out.println(studentEntity);
		return studentEntity;
	}

	public static List<StudentEntity> readAllDAtaFromDB() {
		List<StudentEntity> studentEntityList=studentEntity.findAll();
		//System.out.println(studentEntityList);
		return studentEntityList;
	}

	public static StudentEntity readDataBasedOnIDAndName(Long sid, String name) {
		studentEntity=StudentEntity.find("id=? and name=?", sid,name).first();
		System.out.println(studentEntity);
		return studentEntity;
	}

	public static void updateDataBasedOnId(StudentEntity studentEntity,Long sid) 
	{
		String name =   studentEntity.getName();
		int age =       studentEntity.getAge();
		String gender = studentEntity.getGender();
		
		//update student set name="sahil" and age=24 and sex= "male" where id=1
		String update="update StudentEntity set name=:name,age=:age,gender=:gender where id=:id";
		
		Query query =JPA.em().createQuery(update);
		query.setParameter("name", name);
		query.setParameter("age", age);
		query.setParameter("gender", gender);
		query.setParameter("id", sid);
		query.executeUpdate();
		//studentEntity.merge();
		
		
		
	}

	public static void deleteDataBasedOnID(Long sid) 
	{
		int numberOfRows=studentEntity.delete("delete from StudentEntity where id=?", sid);
		System.out.println(numberOfRows+" rows deleted");
	}

	
	
	
	
}
