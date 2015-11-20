
public class Jacobi {
	static double[][] A = {{4, 1}, {1, 2}};
	static double[] b = {8, 5.5};
	double[] x0 = {0, 0}; //default value
	
	
	double[] JacobiMethod(double[][] A, double[] b){
		double[] sol = new double[b.length];
		int count = 0, k = 10000;
		double calc_err, sum, eps = 0;
		
		while(count++ < k){
			calc_err = 0;
			for(int i = 0; i < x0.length; i++){ // i:row
				sum = b[i];
				for(int j = 0; j < x0.length; j++){ // j:column
					if(i != j){
						sum -= A[i][j] * x0[j];
					}
				}
				sol[i] = sum / A[i][i];
				System.out.println(i + ", " + sol[i]);
				calc_err += Math.abs(x0[i] - sol[i]);
			}
			
			if(calc_err <= eps){
				System.out.print("count, approximate value: " + count +", ");
				print(sol);
				break;
			}
		
			for(int i = 0; i < x0.length; i++){
				x0[i] = sol[i];
			}
		}
		
		if(count == k) System.out.println("error!");
		
		return sol;
	}
	
	void print(double[] vector){
		for(int i = 0; i < vector.length; i++){
			System.out.print(vector[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Jacobi j = new Jacobi();
		j.JacobiMethod(A, b);
	}
}
