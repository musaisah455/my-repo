import java.util.Scanner;

public class ProgrammingEx2_8 {
  public static void main(String [] args) {
    Scanner input = new Scanner(System.in);
    
    // Prompt user to enter the time offset of GMT
    System.out.print("Enter the time zone offset to GMT: ");
    int offset = input.nextInt();
    
    // Obtain the total miliseconds since midnight, jan 1, 1970
    long totalMilliseconds = System.currentTimeMillis();
    
    // Obtain the total seconds since midnight , jan 1, 1970
    long totalSeconds = totalMilliseconds / 1000;
    
    // Compute the current seconds in the minutes in the hour
    long currentSecond = totalSeconds % 60;
    
    // Obtain the total minutes
    long totalMinute = totalSeconds / 60;
    
    // Compute the current minute in the hour
    long currentMinute = totalMinute % 60;
    
    // Obtain the total hour
    long totalHour = totalMinute / 60;
    
    // Compute the current hour
    long currentHour = totalHour % 24;
    currentHour += offset;
    
    // Display results
    System.out.println("Current time is " + currentHour + ":" + currentMinute + ":" + currentSecond);
  }
}
