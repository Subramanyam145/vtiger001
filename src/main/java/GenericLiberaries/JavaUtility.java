package GenericLiberaries;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;








public class JavaUtility {
	
	public int generateRandomNum(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}
	/**
	 * This method return current time
	 * @return
	 * 
	 */
	
	public String getCurrentTime() {
		 Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_HH_mm_sss");
		return sdf.format(date);
		
	}
	
	/**
	 * This method is used to convert String type month to integer
	 * @param args
	 * @return
	 */
	
	public int convertMonthToInt(String month) {
		return DateTimeFormatter
				.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(month)
				.get(ChronoField.MONTH_OF_YEAR);
	}

	
		}

