// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		//bisectionSolver(loan, rate, n, epsilon);


	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		rate = (rate + 100.0) / 100.0;

		for (int i = 0; i < n; i++){

			loan = (loan - payment) * rate;
		}
		return loan;
		//while(loan > payment){
		//	System.out.println(loan);
		//	loan = (loan - payment) * rate;
		//	if (loan <= payment) {
		//		loop = false;
		//	}
		//}
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		boolean loop = true;
		double increment = 0.0001;
		double value = 0;
		while(loop){

			if(endBalance(loan, rate, n, value) > epsilon){
				value = value + increment;
			}
			else {
				loop = false;
			}
			iterationCounter++;
		}
		return value;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        iterationCounter = 0;
		double L = 0.0, H = loan;
		double value = (L + H) / 2.0;
		boolean loop = true;
		while(loop){
		//for(int i = 0;i < 50;i++){
			//System.err.println(endBalance(loan, rate, n, value));
			//System.err.println(value + " " + endBalance(loan, rate, n, value));
			if(loan - endBalance(loan, rate, n, value) > loan - epsilon){
				H = value;
			}
			else{
				L = value;
			}
			value = (L + H) / 2.0;
			iterationCounter++;
			if(endBalance(loan, rate, n, value) < epsilon && endBalance(loan, rate, n, value) > -epsilon){
				loop = false;
			}
		}
		return value;
    }
}