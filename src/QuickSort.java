import java.util.ArrayList;
import java.io.*;

public class QuickSort {
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
	
	int[] quickSort(int[] array, int left, int right){ //ascending order
		int tmp, i = left, j = right, pivot = array[(left + right) / 2];

		while(true){
			while(array[i] < pivot)
				i++;         
			
			while (pivot < array[j])
				j--;
		    
			if (j <= i)
				break;

				tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
		        i++;
		        j--;
		}

	    if (left < i - 1)
	    	quickSort(array, left, i - 1);
		if (j + 1 <  right)
			quickSort(array, j + 1, right);

		return array;
	}
	
	
	void print(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args){
		QuickSort process = new QuickSort();
		process.input(args[0]);
		
		int[] array = process.toArray(list);
		
		long start = System.currentTimeMillis();
		
		process.quickSort(array, 0, array.length - 1);
		
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");
		
		process.print(array);
	}	
	
}
