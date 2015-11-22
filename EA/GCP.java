import java.util.Random;


public class GCP { //グラフ色塗り問題(Graph Coloring Problem)
	static long[] seed = {149, 151, 157, 161, 163, 167, 173, 179, 181, 191};
	static int N = 9; //ノード数(3の倍数)
	static int M = N * (N - 1) / 4; //密結合問題のリンク数
	static int m = 3 * N; //疎結合問題のリンク数
	
	void graphGen(long seed, int link){
		int[][] graph = new int[N][N];
		Random rnd = new Random(seed);
		int count = 0;
		
		while(count < link){
			for(int i = 0; i < N; i++){
				for(int j = i + 1; j < N -1; j++){
					double r = rnd.nextDouble();//0-1のランダム値の生成
					if(0.5 <= r && graph[i][j] == 0){
						graph[i][j] = 1;
						count++;
					}
				}
			}
		}
	print(graph);
	}
	
	void print(int[][] graph){
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph[0].length; j++){
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		GCP process = new GCP();
		process.graphGen(seed[0], M);
	}
}
