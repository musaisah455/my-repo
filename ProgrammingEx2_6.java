import java.util.Scanner;

public class ProgrammingEx2_6 {
  public static void main(String [] args) {
    Scanner input = new Scanner(System.in);
    
    // Prompt the user to enter a number between 0 and 1000
    System.out.print("Enter a number betwenn 0 and 1000: ");
    int number = input.nextInt();
    
    // Compute the sum of the digits in the integer
    int lessThan10 = number % 10;
    number /= 10;
    int tens = number % 10;
    number /= 10;
    int hundreds = number % 10;
    number /= 10;
    int sum = hundreds * tens * lessThan10;
    
    // Display result
    System.out.println("The sum of the digits is " + sum);
  }
}
