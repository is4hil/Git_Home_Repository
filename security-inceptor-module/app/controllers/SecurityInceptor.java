package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class SecurityInceptor extends Controller 
{
	@Before( only = {"EmployeeController.method1","EmployeeController.method2"})
	static void executeBeforeMethods()
	{
		System.out.println("I am executing before executing your actual methods");
	} 
}
