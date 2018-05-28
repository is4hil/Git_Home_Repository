package Jobs;

import play.jobs.Every;
import play.jobs.Job;


@Every("2s")
public class MyRepeatedJob extends Job{

	@Override
	public void doJob() throws Exception {
		
		System.out.println("I am repeating");
	}
	
}
