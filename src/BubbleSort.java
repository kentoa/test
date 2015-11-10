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
	
	
	void bubbleSort(ArrayList<Integer> list){ //ascending order
		int tmp;
		int[] array = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			array[i] = list.get(i);
		}
		
		for(int i = 0; i < array.length; i++){
			for(int j = array.length - 1; i < j; j--){
				if(array[j] < array[j - 1]){
					tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
			}
		}
		
		list.clear();
		
		for(int i = 0; i < array.length; i++){
			list.add(array[i]);
		}
		
	}
	
	
	void print(ArrayList<Integer> list){
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args){
		BubbleSort process = new BubbleSort();
		process.input(args[0]);
		
		long start = System.currentTimeMillis();
		
		process.bubbleSort(list);
		
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");
		
		process.print(list);
	}
}
