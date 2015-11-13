import java.util.ArrayList;
import java.io.*;

public class MargeSort {
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
	
	int[] margeSort(int[] array){ //ascending order
		
		if(1 < array.length){
			int median = array.length / 2;
			int[] left = new int[median];
			int[] right = new int[array.length - median];
			
			for(int i = 0; i < median; i++){
				left[i] = array[i];
			}
			
			for(int i = median; i < array.length; i++){
				right[i - median] = array[i];
			}
			
			margeSort(left);
			margeSort(right);
			marge(left, right, array);
		}			
		return array;		
	}			
	
	
	void marge(int[] left, int[] right, int[] marge){
		int i = 0, j = 0;
		
		while(i < left.length || j < right.length){
			if(right.length <= j || (i < left.length && left[i] < right[j])){
				marge[i + j] = left[i];
				i++;
			}
			else{
				marge[i + j] = right[j];
				j++;
			}
		}
	}
	
	
	void print(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args){
		MargeSort process = new MargeSort();
		process.input(args[0]);
		
		int[] array = process.toArray(list);
		
		long start = System.currentTimeMillis();
		
		process.margeSort(array);
		
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");
		
		process.print(array);
	}	
	
}
