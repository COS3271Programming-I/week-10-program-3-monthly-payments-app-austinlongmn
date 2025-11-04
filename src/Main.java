import java.util.Scanner;

class Main {

  static Scanner userInput = new Scanner(System.in);

  // I modified this function to give correct output
  static double computePayment(double loanAmt, double rate, int numPeriods) {
    // Interest rate and periods reflect monthly instead of yearly payments
    double interest = (rate / 100.0) / 12;
    int monthlyPeriods = numPeriods * 12;

    // Re-did formula for correctness
    double exponentialPart = Math.pow(1 + interest, monthlyPeriods);
    double rationalPart = (interest * exponentialPart) / (exponentialPart - 1);

    return loanAmt * rationalPart;
  }

  public static void main(String[] args) {
    System.out.println("Welcome to Monthly Mortgage Calculator");
    System.out.print("\nEnter principle: ");
    double principle = userInput.nextDouble();
    System.out.print("Enter yearly interest rate without percent: ");
    double rate = userInput.nextDouble();
    System.out.print("Enter number of years: ");
    int numPeriods = userInput.nextInt();
    System.out.format(
      "\nThe monthly payment is $%.2f\n",
      computePayment(principle, rate, numPeriods)
    );
  }
}
