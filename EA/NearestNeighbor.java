import java.io.*;
import java.util.ArrayList;

public class NearestNeighbor {
	
	double[][] init(String path){ //都市データの読み込み
		ArrayList<double[]> points = new ArrayList<>(); 
		try{
	         BufferedReader br = new BufferedReader(new FileReader(path));
	         String line;
	         int count = 0;
	         
	         while((line = br.readLine()) != null){
	        	 count++;
	        	 if(count > 6 && line.split(" ").length == 3){
	        		 String[] str = line.split(" "); //split " "
	        		 double[] vector = {Double.parseDouble(str[1]), Double.parseDouble(str[2])};
		        	 points.add(vector);
		         }
	         }
	         br.close(); 
		 }catch(IOException ex){
			 ex.printStackTrace();
		 }	
		
		double[][] city = new double[points.size()][2];
		
		for(int i = 0; i < city.length; i++){
			city[i][0] = points.get(i)[0];
			city[i][1] = points.get(i)[1];
		}
		return city;
	}
	
	double[][] calcDist(double[][] city){ //都市間の距離を計算
		double[][] dist = new double[city.length][city.length];
		
		for(int i = 0; i < city.length; i++){
			for(int j = 0; j < city.length; j++){
				dist[i][j] = Math.sqrt((Math.pow(city[i][0] - city[j][0], 2) + Math.pow(city[i][1] - city[j][1], 2)));
				dist[j][i] = dist[i][j];
			}
		}
		return dist;
	}
	
	int[] NNMethod(double[][] dist){
		int[][] solution = new int[dist.length][dist.length + 1];
		
		for(int i = 0; i < solution.length; i++){
			solution[i][0] = i;
			solution[i][dist.length] = i;
			int ishere = i; //今いる都市番号
			boolean[] visited = new boolean[dist.length]; //訪問した都市の番号にはtrueが入る
			visited[i] = true;
			
			for(int j = 1; j < dist.length; j++){ //generate a solution
					solution[i][j] = min(dist, ishere, visited);
					ishere = solution[i][j];
					visited[ishere] = true;
			}
		}

		int solIndex = selectSolution(solution, dist);
		
		double avg = calcAvg(solution, dist);
		calcMindist(solution[solIndex], dist);
		calcStddev(solution, dist, avg);
		
		return solution[solIndex];
	}
	
	int min(double[][] dist, int ishere, boolean[] visited){ //都市間の距離が最小となるよう次の都市を選択する
		int index = -1;
		double min_dist = Double.MAX_VALUE;
		
		for(int i = 0; i < dist.length; i++){
			if(!isVisited(visited, i)){
				if(dist[ishere][i] != 0 && dist[ishere][i] < min_dist){
					min_dist = dist[ishere][i];
					index = i;
				}	
			}
		}
		return index;
	}
	
	boolean isVisited(boolean[] visited, int i){ //i番目の都市を訪問したか調べる
		boolean flag = false;
		if(visited[i] == true) flag = true;	
		return flag;
	}
		
	int selectSolution(int[][] solution, double[][] dist){ //解候補の中から最短経路を選択する
		double sum, tmp = Double.MAX_VALUE;
		int index = -1;
		
		for(int i = 0; i < solution.length; i++){
			sum = 0;
			for(int j = 0; j < solution.length; j++){
				sum += dist[solution[i][j]][solution[i][j + 1]];
			}
			if(sum < tmp){
				tmp = sum;
				index = i;
			}
		}
		return index;
	}
	
	void calcMindist(int[] solution, double[][] dist){
		double sum = 0;
		
		for(int i = 0; i < solution.length - 1; i++){
				sum += dist[solution[i]][solution[i + 1]];
			}
		System.out.println("min distance is " + sum);
	}
	
	double calcAvg(int[][] solution, double[][] dist){
		double sum = 0;
		
		for(int i = 0; i < solution.length; i++){
			for(int j = 0; j < solution[0].length - 1; j++){
				sum += dist[solution[i][j]][solution[i][j + 1]];
			}
		}
		System.out.println("avarage is " + sum/solution.length);
		return sum/solution.length;
	}
	
	double calcStddev(int[][] solution, double[][] dist, double avg){
		double tmp = 0, var, stddev;
		double[] eachpath = new double[solution.length]; 
		
		for(int i = 0; i < solution.length; i++){
			for(int j = 0; j < solution[0].length -1; j++){
				eachpath[i] += dist[solution[i][j]][solution[i][j + 1]];
			}
			tmp += Math.pow((eachpath[i] - avg), 2);
		}
		
		var = tmp / solution.length;
		stddev = Math.sqrt(var);
		
		System.out.println("stddev is " + stddev);
		return stddev;
	}
	
	
	void print(double[][] city){
		for(int i = 0; i < city.length; i++){
			for(int j = 0; j < city[0].length; j++){
				System.out.print(city[i][j] + " ");
			}
		System.out.println();
		}
	}
	
	public static void main(String[] args){
		NearestNeighbor nn = new NearestNeighbor();
		double[][] city = nn.init(args[0]);
		double[][] dist = nn.calcDist(city);
		int[] solution = nn.NNMethod(dist);
		
		System.out.print("Min path: ");
		for(int i = 0; i < solution.length; i++){
			System.out.print(solution[i]);
			if(i != solution.length - 1) System.out.print(" -> ");
		}
		
	}
}
