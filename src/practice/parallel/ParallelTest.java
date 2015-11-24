import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelTest {
	 public static void main(String[] args) {
		    int threadNumber = 8; // 8スレッド用意
		    ExecutorService executor = Executors.newFixedThreadPool(threadNumber);

		    String[] results = new String[threadNumber]; // 結果を入れる配列
		    List<Callable<String>> tasks = new ArrayList<Callable<String>>(); // タスクのリストを作る
		    
		    for(int i = 1; i <= threadNumber; i++){
		      tasks.add(new ParallelTasks(i));
		    }

		    try{ // 並列実行
		      List<Future<String>> futures;
		      try{
		        futures = executor.invokeAll(tasks);
		      } catch(InterruptedException e){
		        System.out.println(e);
		        return ;
		      }
		      System.out.println("-----------");

		      for(int i = 0; i< threadNumber; i++){ // 結果をresultsに入れる
		        try{
		          results[i] = (futures.get(i)).get();
		        }catch(Exception e){
		          System.out.println(e);
		        }
		      }
		    } finally{ // 終了
		      if(executor != null) executor.shutdown();
		      for(String result : results) System.out.println(result); // 結果の配列の中身
		    }
		  }
}
