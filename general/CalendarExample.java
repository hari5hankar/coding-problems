import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExample {
	
	enum FREQ { hourly, daily, monthly};
	static FREQ freq = FREQ.daily;

	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		Calendar calendar2 = new GregorianCalendar(2015, 10, 3);
		
		switch (freq){
		case hourly:
			System.out.println("h");
			break;
		case daily:
			System.out.println("d");
			break;
		default:
			break;
		}
			
		
		System.out.println(calendar2.getTime());
		int i = 0;
		while(calendar2.compareTo(calendar) < 0){
			System.out.print(i++ + " ");
			calendar2.add(Calendar.DATE, 1);
		}
			

		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(date_format.format(calendar.getTime()));
	}
	
}
