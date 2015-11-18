
public class Integral {
	
	double function(double x){
		double fx;
		fx = Math.pow(x, 2); //f(x) = x*x
		return fx;
	}
	
	
	double[] divideSquare(int left, int right, int n){ //区分求積法
		double[] S = new double[3];
		double splitNum = (double)(right - left) / n;
		
		for(int i = 1; i <= n; i++){ //グラフ外での長方形近似
			S[0] +=(splitNum * function(i*splitNum));
		}
		
		for(int i = 0; i <= n - 1; i++){ //グラフ内で長方形近似
			S[1] += (splitNum * function(i*splitNum));
		}
		
		for(int i = 1; i <= n; i++){ //台形近似
			S[2] += (splitNum * (function(i*splitNum) + function((i - 1) * splitNum)))/2;
		}
	
		return S;
	}
	
	
	public static void main(String[] args){
		Integral process = new Integral();
		
		double[] S = process.divideSquare(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		System.out.println("real value: " + (double)1/3);
		System.out.println("calc value1: " + S[0]);
		System.out.println("calc value2: " + S[1]);
		System.out.println("calc value3: " + S[2]);
	}
	
}
