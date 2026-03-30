import java.util.Scanner;

public class ProgrammingEx2_2 {
  public static void main(String [] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    
    // Prompt user to enter length of the sides and height of the equilateral triangle:
    System.out.print("Enter length of the sides and height of the Equilateral triangle: ");
    double length = input.nextDouble();
    
    // Compute the area and volume
    double area = Math.sqrt(3) / 4 * Math.pow(length, 2);
    double volume = area * length;
    
    // Display result
    System.out.println("The area is " + area);
    System.out.println("The volume is " + volume);
  }
}
