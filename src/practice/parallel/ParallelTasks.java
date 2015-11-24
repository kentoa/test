import java.util.concurrent.Callable;

public class ParallelTasks implements Callable<String>{
	int taskNumber;
	  public ParallelTasks(int taskNumber){
	    this.taskNumber = taskNumber;
	  }

	  @Override
	  public String call() throws Exception{
	    // sleep 
	    Thread.sleep((long)(1000 * (8 - taskNumber))); // 開始が速いタスクほど時間がかかるように設定

	    System.out.println("task " + taskNumber + " end."); // タスクの番号を出力
	    return "task " + taskNumber ;
	  }
}
