
public class SUM {
	
	int sum(int[] array){ //連続する整数の和を求める
		int s = 0;
		for(int i = 0; i < array.length; i++){
			s += array[i];
		}
		return s;
	}
	
	int combsum(int[] array){
		int s = 0;
		int size = array.length;
		
		for(int i = 0; i < size/2; i++){
			s += array[i] + array[size - i - 1];
		}
		
		if(size %2 != 0){
			s += array[size / 2];
		}
		
		return s;
	}
	
	int multisum(int[] array){
		int s = 0;
		int size = array.length;
		
		s = (size / 2) * (array[0] + array[size - 1]);
		
		if(size %2 != 0){
			s += array[size / 2];
		}
		return s;
	}
	
	
	public static void main(String[] args){
		SUM s = new SUM();
		int N = 1000, k = 100000, calc = 0;
		int[] list = new int[N];
		int[] listodd = new int[N - 1];
		
		for(int i = 0; i < N; i++){
			list[i] = i;
		}
		for(int i = 0; i < N - 1; i++){
			listodd[i] = i;
		}
		
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < k; i++){
			calc = s.sum(listodd); 
		}
		long end = System.currentTimeMillis();
		
		System.out.println(calc);
		System.out.println("普通のやつ: " + (end - start)  + "ms");
		
		start = System.currentTimeMillis();
		for(int i = 0; i < k; i++){
			calc = s.combsum(listodd); 
		}
		end = System.currentTimeMillis();
		
		System.out.println(calc);
		System.out.println("ペアごと足す: " + (end - start)  + "ms"); //k =100,000とかだと普通に足すより遅い

		start = System.currentTimeMillis();
		for(int i = 0; i < k; i++){
			calc = s.multisum(listodd); 
		}
		end = System.currentTimeMillis();
		
		System.out.println(calc);
		System.out.println("ペアにして足して（要素数/2）をかける: " + (end - start)  + "ms");
		
		
	}
	
}
