// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(2,3));   // 2 + 3
	    //System.out.println(minus(7,-2));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(-3,-9));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(0,-5));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {

		if((x1 >= 0 && x2 >= 0) || (x1 < 0 && x2 >=0)){
			for(int i = 0; i < x2; i++){

				x1++;
			}
			return x1;
		}
		else {
			for(int i = x2; i < 0; i++)
			{
				x1--;
			}
			return x1;
		}
		
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		
		if((x1 >= 0 && x2 >= 0) || (x1 < 0 && x2 >=0)){
			for(int i = 0; i < x2; i++){

				x1--;
			}
			return x1;
		}
		else{
			for(int i = x2; i < 0; i++)
			{
				x1++;
			}
			return x1;
		}
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {

		if((x1 >= 0 && x2 >= 0) || (x1 < 0 && x2 >=0)){
			int temp = x1;
			if(x2 == 0){
				return 0;
			}
			for(int i = 1; i < x2; i++){

				x1 = plus(x1, temp);
			}
			return x1;
		}
		else if (x1 < 0 && x2 < 0){
			int temp = x1;
			for(int i = x2; i <= 0; i++){

				x1 = minus(x1,temp);
			}
			return x1;
		}
		else{
			int temp = x2;
			for( int i = 1; i < x1; i++){

				x2 = plus(x2, temp);
			}
			return x2;
		}
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {

		int temp = x;
		if (n == 0){
			return 1;
		}
		else if(n < 0){
			return 0;
		}
		else{
			for( int i = 1; i < n ; i++){

				x = times(x,temp);
			}
			return x;
		}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		
		int result = 0;

		if(x1 >= 0){
			if(x2 > 0){
				while(x1 >= x2){
	
					x1 = minus(x1, x2);
					result++;
				}
			return result;
			}
			else{
				x2 = minus(0, x2);
				while(x1 >= x2){
	
					x1 = minus(x1, x2);
					result--;
				}
			return result;
			}
		}
		else {
			x1 = minus(0, x1);
			if(x2 > 0){
				while(x1 >= x2){
	
					x1 = minus(x1, x2);
					result--;
				}
			return result;
			}
			else{
				x2 = minus(0, x2);
				while(x1 >= x2){
	
					x1 = minus(x1, x2);
					result++;
				}
			return result;
			}
		}
			
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
			while(x1 >= x2){

				x1 = minus(x1, x2);
			}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		boolean loop = true;
		int counter =0;
		while(loop){

			if(pow(counter, 2) == x){
				loop = false;
			}
			else if(pow(counter, 2) > x){

				return minus(counter, 1);
			}
			else{
				counter++;
			}

		}
		return counter;
	}	  	  
}