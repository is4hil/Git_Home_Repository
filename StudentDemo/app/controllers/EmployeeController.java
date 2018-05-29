package controllers;


import play.mvc.Controller;
import play.mvc.With;

@With(SecurityInceptor.class)
public class EmployeeController extends Controller 
{
	/*@Before
	static void executeBeforeMethods()
	{
		System.out.println("I am executing before executing your actual methods");
	}*/
	
	public static void  method1() {
		System.out.println("Method 1");
	}
	
	public static void method2() {
		System.out.println("Method 2");
		
	}
	
	public static void method3() {
		System.out.println("Method 3");
		
	}

}
