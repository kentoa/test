
public class BinarySearch {
	static int[] array = {1, 2, 3, 4, 5, 6}; //sorted array(ascending order)
	
	public static void binarySearch(int[] array, int target){
		int index = -1;
		int median = array.length / 2;
		
		if(array[median] < target){
			for(int i = median + 1; i < array.length; i++){
				if(target == array[i]){
					index = i;
					break;
				}
			}
		}
		else if(target < array[median]){
			for(int i = median - 1; 0 <= i; i--){
				if(target == array[i]){
					index = i;
					break;
				}
			}
		}
		else index = median;
		
		if(index == -1) System.out.println(target + " is not found.");
		else System.out.println(target + "'s index is " + index);
	}
	
	public static void main(String[] args){
		binarySearch(array, Integer.parseInt(args[0]));
	}
	
}
