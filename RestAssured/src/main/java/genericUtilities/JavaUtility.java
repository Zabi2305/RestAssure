package genericUtilities;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Zabiulla
 *
 */
public class JavaUtility {
	/**
	 * To get the Random Number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		return ranNum;
	}



	/**
	 * To get the System Date and Time
	 * @return
	 */
	public String SystemDateAndTime() 
	{
		Date date = new Date();
		String dateTime = date.toString();
		return dateTime;
	}

	/**
	 * To get the System date and Time in Required Format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date datte = new Date();
		String dateTime = datte.toString();
		String[] dateArr = dateTime.split(" ");
		int month = datte.getMonth()+1;
		//String month = dateArr[1];
		String date = dateArr[2];
		String year = dateArr[5];
		//String day = dateArr[0];
		int day = datte.getDay();
		String time = dateArr[3];

		String finalFormat= month+" "+date+" "+year+" "+day+" "+time;
		return finalFormat; 
		//System.out.println(finalFormat);
	}	
}
