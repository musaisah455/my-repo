class Question1 {
  public static void main(String[] args) {
    Question1 main = new Question1();
    var result = main.sumofDigits(111);
    System.out.println(result);

  }

  // Question 1

  public int sumofDigits(int n) {
   
    if (n==0 || n < 0) {
      return 0;
    }
    return n%10 + sumofDigits(n/10);
  }



}
