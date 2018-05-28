package controllers.MySecurityModule;

import play.mvc.Before;
import play.mvc.Controller;

public class GateKeeper extends Controller{

	@Before(only = { "StudentController.putJsonDataBasedOnId" })
	static void AuthenticateUser() 
	{
		System.out.println("********Authenticating**********Í");
	}
}
