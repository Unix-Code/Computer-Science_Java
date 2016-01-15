public class NewtonMethod {
  public static void main(String[] args) {
  	NewtonMethod test = new NewtonMethod();
  	test.calc("4x^3 + 7x^2 + 5x + 6", -2, 5);
  }
  
  public void calc(String polynomial, double firstGuess, int tolerance) {
      Polynomial p = new Polynomial(polynomial);
      double newGuess = 0;
      double oldGuess = firstGuess;
      for (int i = 0; i < tolerance + 1; i++) {
      	newGuess = oldGuess - (p.evaluate(oldGuess))/(p.differentiate().evaluate(oldGuess));
      	oldGuess = newGuess;
      }
      System.out.println("Root: " + newGuess);
  }
}