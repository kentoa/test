import java.util.ArrayList;
import java.io.*;

public class BubbleSort {
	static ArrayList<Integer> list = new ArrayList<>(); 

	void input(String path){
		try {
	         BufferedReader br = new BufferedReader(new FileReader(path));
	         String line;
	         while((line = br.readLine()) != null){
	        	 String[] str = line.split(","); //split ","
	        	 
	        	 for(int i = 0; i < str.length; i++){
	        		 list.add(Integer.parseInt(str[i]));
	        	 }
	        	 
	         }
	         br.close();
		 } catch(IOException ex) {
			 ex.printStackTrace();
		 }	
	}
	
	int[] toArray(ArrayList<Integer> list){
		int[] array = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			array[i] = list.get(i);
		}
		return array;
	}
	
	int[] bubbleSort(int[] array){ //ascending order
		int tmp;
		
		for(int i = 0; i < array.length; i++){
			for(int j = array.length - 1; i < j; j--){
				if(array[j] < array[j - 1]){
					tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
			}
		}
		return array;
	}
	
	
	void print(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args){
		BubbleSort process = new BubbleSort();
		process.input(args[0]);
		
		int[] array = process.toArray(list);
		
		long start = System.currentTimeMillis();
		
		int[] result = process.bubbleSort(array);
		
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");
		
		process.print(result);
	}
}
