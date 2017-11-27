import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TimeOfTheDay {

	public static void main(String ars[]) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("enter the time in hh:mm format");

			String inputDate = input.next();
			
			LocalTime time = LocalTime.parse(inputDate, DateTimeFormatter.ISO_TIME);
			
			if (time.getHour() == 12 && time.getMinute() == 00) {
				System.out.println("Time is"+inputDate + " Noon");
			} else if (time.getHour() == 23 && time.getMinute() == 59) {
				System.out.println("Time is"+inputDate + " Midnight");
			}else if (time.getHour() < 12 || (time.getHour() == 00 && time.getMinute() > 0)) {
				System.out.println("Time is "+inputDate + " AM");
			} else if (time.getHour() > 12) {
				System.out.println("Time is"+inputDate + " PM");
			}  else {
				System.out.println("Not a valid time");
			}
		} catch (DateTimeParseException dateTimeParseException) {
			System.out.println("Entered date time is not hh:mm format");
		}

	}

}
