import java.util.*;
import java.io.*;

public class MakeData {
	static ArrayList<Integer> list = new ArrayList<>();
	long seed = System.currentTimeMillis();
	Random rnd = new Random(seed);
	
	void vector(int num){ //generate vector
		for(int i = 0; i < num; i++){
			list.add(rnd.nextInt(num));
		}
	}
	
	void output(String path){
		try{
			File file = new File(path);
			
			if(existfile(file)){
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

		        for(int i = 0; i < list.size(); i++){
		        	pw.print(list.get(i));
		     
		        	if(i != list.size() - 1){
		        		pw.print(",");
		        	}
		        }
		        pw.close();
			}else{
				System.out.println("do not write!");
			}
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	boolean existfile(File file){
		if (file.exists()){
			if (file.isFile() && file.canWrite()){
				return true;
		    }
		}
		return false;
	}
	
	void print(ArrayList<Integer> list){
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		MakeData process = new MakeData();
		process.vector(Integer.parseInt(args[0]));
		process.output(args[1]);
		//process.print(list);
	}
	
}
