package controllers;

import java.util.List;

import com.google.gson.Gson;

import controllers.MySecurityModule.GateKeeper;
import models.StudentEntity;
import models.StudentModel;
import models.StudentModelRepository;
import play.mvc.Controller;
import play.mvc.With;

@With(GateKeeper.class)
public class StudentController extends Controller
{
	/*@Before(only={"putJsonDataBasedOnId"})
	 static void AuthenticateUser()
		{
			System.out.println("********Authenticating******");
		}
	*/
	
	static Gson gson=new Gson();
	public static void methodToPrintWhatUserInserts(String msg) 
	{
		System.out.println("You Have Inserted: "+ msg);
		render();
	}
	
	public static void getJsonDataBasedOnId(int sid) 
	{
		StudentModel studentModel=StudentModelRepository.readStudentDetails(sid);
		renderJSON(studentModel);
		
		// GET JSON DATA IN SNAKE_CASE FORMATE
		//Gson gson=new Gson();
		gson.toJson(studentModel);
	}
	
	public static void postJsonDataAndSaveInMap() 
	{
		// FETCHING ALL THE DATA  FROM USER PASSED IN BODY OF HTTP REQUEST
		String body=params.get("body");
		
		                              //CONVERTING FROM JSON FORMATE TO OBJECT FORMATE
		StudentModel studentModel=gson.fromJson(body, StudentModel.class);
		
		int id=studentModel.getId();
		String name=studentModel.getName();
		int age=studentModel.getAge();
		String gender=studentModel.getGender();
		
		System.out.println(id+"--->"+name+"--->"+age+"--->"+gender);
		
		//StudentModel studentModel2=new StudentModel(id, name, age, gender);
		StudentModelRepository.insertInMap(studentModel);
		
	}
	
	public static void postJsonDataAndSaveInDB() 
	{
		String body=params.get("body");
		
		//StudentEntity studentEntity=gson.fromJson(body, StudentEntity.class);
		StudentEntity studentEntity =gson.fromJson(body, StudentEntity.class);
		
		
		//int id=studentEntity.getId();
		/*String name=studentEntity.getName();
		int age=studentEntity.getAge();
		String gender=studentEntity.getGender();*/
		
		//System.out.println(studentEntity);  // CREATE OPERATION
		StudentModelRepository.insertInDB(studentEntity);
	}
	
	public static void getJsonDataFromDBBasedOnId(Long sid) 
	{
		StudentEntity studentEntity=StudentModelRepository.readDataFromDB(sid);
		//System.out.println(studentEntity);
		renderJSON(studentEntity);
		
	}
	 // GETTIG ALL DATA FROM DB AND CONVERTING THEM IN JSON FORMATE AND GIVING TO USER
	public static void getAllJsonDataFromDB()
	{
		List<StudentEntity> studentEntityList=StudentModelRepository.readAllDAtaFromDB();
		renderJSON(studentEntityList);
	}
	
	public static void getJsonDataFromDBBasedOnIdAndName(Long sid, String name)
	{
		StudentEntity studentEntity=StudentModelRepository.readDataBasedOnIDAndName(sid,name);
		renderJSON(studentEntity);
	}
	
	
	public static void putJsonDataBasedOnId(Long sid)
	{
		String body=params.get("body");
		StudentEntity studentEntity = gson.fromJson(body,StudentEntity.class);
		StudentModelRepository.updateDataBasedOnId(studentEntity,sid);
	}
	
	
	
	public static void deleteJsonDataBasedOnId(Long sid)
	{
		StudentModelRepository.deleteDataBasedOnID(sid);
	}
	
	
	
	
}
