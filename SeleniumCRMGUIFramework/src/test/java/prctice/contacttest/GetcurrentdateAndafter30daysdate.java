package prctice.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetcurrentdateAndafter30daysdate {

	public static void main(String[] args) 
	{
	Date dateobj=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyy-MM-dd");
	String startdate = sim.format(dateobj);
	System.out.println(startdate);
	
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, +30);
		String enddate = sim.format(cal.getTime());
		System.out.println(enddate);
			
		
	}

}
