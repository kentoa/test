import java.util.*;

public class MonteCarlo {

	double Montecarlo(int n){ //n : a number of points 
		double pi = 0, dist = 0;
		double[] x = new double[n], y = new double[n];
		long seed = 149L;
		Random r =  new Random(seed);
		
		int count = 0;
		
		for(int i = 0; i < n; i++){ 
			x[i] = r.nextDouble(); //generate points
			y[i] = r.nextDouble();
			
			dist = Math.sqrt(Math.pow(x[i], 2) + Math.pow(y[i], 2));
			
			if(dist < 1){
				count++;
			}
		}
		
		System.out.println("(count, n), " + "(" + count + ", " + n + ")");
		
		pi = 4 * (double)count / n;
		return pi;
	}
	
	
	public static void main(String[] args){
		MonteCarlo m = new MonteCarlo();
		
		double pi = m.Montecarlo(Integer.parseInt(args[0]));
		System.out.println("(real pi, calc pi), "+ "(" + Math.PI + ", " + pi + ")");
		
	}
	
}
