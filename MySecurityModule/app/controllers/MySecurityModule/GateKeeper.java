package controllers.MySecurityModule;

import play.mvc.Before;

public class GateKeeper {

	@Before(only = { "StudentController.putJsonDataBasedOnId" })
	static void AuthenticateUser() 
	{
		System.out.println("********Authenticating**********Í");
	}
}
