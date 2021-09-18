import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Calendar;


/**
 * 
 */
public class JavaDateAndTime {


    /**
     * You are given a date.
     * You just need to write the method, getDay, which returns the day on that date.
     * To simplify your task, we have provided a portion of the code in the editor.
     */
    public static String findDay(int month, int day, int year) throws DateTimeParseException {

        // **** sanity check(s) **** 
        if (month < 1 || month > 12) return "";
        if (day < 1 || day > 31) return "";
        if (year < 2000 || year >= 3000) return "";

        // **** format the date string ****
        String dateStr = String.format("%4d-%02d-%02d", year, month, day);

        // **** generate specified date ****
        LocalDate date = LocalDate.parse(dateStr);

        // **** get the day of week from the date ****
        DayOfWeek dayOfWeekInt = date.getDayOfWeek();

        // **** return the day of the week as a string ****
        return dayOfWeekInt.toString();
    }


    /**
     * You are given a date.
     * You just need to write the method, getDay, which returns the day on that date.
     * To simplify your task, we have provided a portion of the code in the editor.
     */
    public static String findDay1(int month, int day, int year) throws DateTimeParseException {

        // **** sanity check(s) **** 
        if (month < 1 || month > 12) return "";
        if (day < 1 || day > 31) return "";
        if (year < 2000 || year >= 3000) return "";

        // **** initialization ****
        String[] dayNames = {   "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY",
                                "FRIDAY", "SATURDAY"};

        // **** instantiate a calendar ****
        Calendar cal = Calendar.getInstance();

        // **** set the calendar for the specified date ****
        cal.set(year, month - 1, day);

        // **** get the day of the week ****
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        // **** return the associated name of the day ****
        return dayNames[dayOfWeek - 1];
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read the date string ****
        String[] date = br.readLine().trim().split(" ");

        // **** close buffered reader ****
        br.close();

        // **** call function of interest and display result ****
        System.out.println("main <<< ==>" + 
            findDay(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])) + "<==");

        // **** call function of interest and display result ****
        System.out.println("main <<< ==>" + 
            findDay1(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])) + "<==");
    }
}