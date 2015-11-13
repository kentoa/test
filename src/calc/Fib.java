public class Fib {
	
	int[] fib(int a0, int a1, int n){ //calculate Fib(n)  2<=n
		int[] an = new int[n];
		
		if(n < 2){
			System.out.println("error!");
		}
		
		an[0] = a0;
		an[1] = a1;
		
		for(int i = 2; i < n; i++){
			an[i] = an[i - 1] + an[i - 2];
		}
		
		return an;
	}
	
	int sumFib(int[] an, int m){ //sum Fib(n) from n = 0 to n = m 
		int sum = 0;
		
		if(an.length < m){
			System.out.println("error!");
		}
		
		for(int i = 0; i < m; i++){
			sum+= an[i];
		}
		
		return sum;
	}
	
	void printFib(int[] an){
		for(int i = 0; i < an.length; i++){
			System.out.print(an[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args){
		Fib f = new Fib();
		
		int[] an = f.fib(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		
		f.printFib(an);
		
		int sum = f.sumFib(an, Integer.parseInt(args[2]));
		System.out.println(sum);
		
		
	}
	
}
