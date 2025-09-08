package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	
	public static String currentDate()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		return	dateFormat.format(new Date());
	}
}
