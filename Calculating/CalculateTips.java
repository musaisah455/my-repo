import java.util.Scanner; // Scanner is in java.util package

public class CalculateTips {
   public static void main(String [] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);
      
      // Prompt the user to enter subtotal and gratuity rate
      System.out.print("Enter the subtotal and gratuity rate: ");
      double subtotal = input.nextDouble();
      double gratuityRate = input.nextDouble();
      
      // Obtain the gratuity
      double gratuity = subtotal * gratuityRate / 100;
      
      // Compute the total
      double total = gratuity + subtotal;
      
      // Display results
      System.out.println("The gratuity is $" + gratuity + " and total is $" + total);
   } 
}
