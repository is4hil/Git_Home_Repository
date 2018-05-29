package Jobs;

import play.jobs.Every;
import play.jobs.Job;
@Every("1s")
public class MyJobDemo /*extends Job*/
{

	//@Override
	public void doJob() throws Exception {
		//super.doJob();
		System.out.println("Hello I am Repeating every 2 second");
	}
	
	
}
