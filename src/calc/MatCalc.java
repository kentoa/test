
public class MatCalc {
	static int[][] A = {{1, 2, 3}, {4, 5, 6},{7, 8, 9}};
	static int[][] B = {{1, 2, 3}, {4, 5, 6},{7, 8, 9}};
	static int[][] C = {{1, 2}, {3, 4}, {5, 6}};
	
	int[][] Add(int[][] matA, int[][] matB){
		int[][] matC = new int[matA.length][matA.length];
		
		if(matA.length != matB.length || matA[0].length != matB[0].length){
			System.out.println("matrix size is not match.");
			return matC;
		}
		
		for(int i = 0; i < matA.length; i++){
			for(int j = 0; j < matB.length; j++){
					matC[i][j] = matA[i][j] + matB[i][j];
			}		
		}
		printMatrix(matC);
		return matC;
	}
	
	
	int[][] Sub(int[][] matA, int[][] matB){
		int[][] matC = new int[matA.length][matA.length];
		
		if(matA.length != matB.length || matA[0].length != matB[0].length){
			System.out.println("matrix size is not match.");
			return matC;
		}
		
		for(int i = 0; i < matA.length; i++){
			for(int j = 0; j < matB.length; j++){
					matC[i][j] = matA[i][j] - matB[i][j];
			}		
		}
		printMatrix(matC);
		return matC;
	}
	
	
	int[][] Multiply(int[][] matA, int[][] matB){
		int[][] matC = new int[matA.length][matB[0].length];
		
		if(matA[0].length != matB.length){
			System.out.println("matrix size is not match.");
			return matC;
		}
		
		for(int i = 0; i < matA.length; i++){
			for(int k = 0; k < matB[0].length; k++){
				for(int j = 0; j < matB.length; j++){
					matC[i][k] += matA[i][j] * matB[j][k];
				}		
			}
		}
		printMatrix(matC);
		return matC;
	}
	
	
	void printMatrix(int[][] matM){
		for(int i = 0; i < matM.length; i++){
			for(int j = 0; j < matM[0].length; j++){
				System.out.print(matM[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args){
		MatCalc mc = new MatCalc();
		
		//mc.Add(A, B);
		//mc.Sub(A, B);
		mc.Multiply(A, B);
	}
	
}
