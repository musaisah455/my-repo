class Question4 {
  public static void main(String[] args) {
    Question4 main = new Question4();
    var result = main.decimalToBinary((int)(1.5));
    System.out.println(result);

  }

  // Question 4 - Decimal to Binary

  public int decimalToBinary(int n) {
    if (n==0) {
      return 0;
    }
    return n%2 + 10*decimalToBinary(n/2);
  }


}
