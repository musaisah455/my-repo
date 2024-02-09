import java.util.Scanner;

public class CalculatingEnergy {
  public static void main(String[] args) {
      // Creat a Scanner
      Scanner input = new Scanner(System.in);
      
      // Prompt the user to enter amount of water
      System.out.print("Enter the amount of water in kilograms: ");
      double M = input.nextDouble();
      
      // Prompt the user to enter the initial temperature
      System.out.print("Enter the initial temperature: ");
      double initialTemperature = input.nextDouble();
      
      // Prompt the user to enter final temperature
      System.out.print("Enter the final temperature: ");
      double finalTemperature = input.nextDouble();
      
      // Compute Q
      double Q = M * (finalTemperature - initialTemperature) * 4184;
      
      // Display results
      System.out.println("The energy needed is " + Q);
      
  }
}
