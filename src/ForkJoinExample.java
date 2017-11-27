import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {


	static ForkJoinPool pool = ForkJoinPool.commonPool();
	
	public static void main(String args[]) {

		CustomRecursiveAction action = new CustomRecursiveAction("ajaypavithra");
		//pool.invoke(action);
		
		Fibonacci fib =new Fibonacci(5);
		fib.invoke();

	}
}


class Fibonacci extends RecursiveTask<Integer> {
	   final int n;
	   Fibonacci(int n) { this.n = n; }
	   
	   @Override
	   protected Integer compute() {
	     if (n == 1||n==0)
	       return n;
	     Fibonacci f1 = new Fibonacci(n - 1);
	     f1.fork();
	     Fibonacci f2 = new Fibonacci(n - 2);
	     
	     int f1Join = f1.join();
	     
	    
	     
	     int f2Compute = f2.compute();
	     
	     System.out.println(f2Compute);
	     System.out.println(f1Join);
	     
	     
	     int digit = f1Join + f2Compute;
	     
	     //System.out.println(digit);
	     
	     return digit; 
	   }
	 }


class CustomRecursiveAction extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String workLoad = "";
	private static final int THRESHOLD = 4;
	
	
	public CustomRecursiveAction(String workLoad) {
		super();
		this.workLoad = workLoad;
	}

	@Override
	protected void compute() {
	
		
		if (workLoad.length() > THRESHOLD) {
			ForkJoinTask.invokeAll(createSubTask());
		} else {
			processing(workLoad);
		}

	}

	private List<CustomRecursiveAction> createSubTask() {
		List<CustomRecursiveAction> tasks = new ArrayList<>();
		tasks.add(new CustomRecursiveAction(workLoad.substring(0, workLoad.length() / 2)));
		tasks.add(new CustomRecursiveAction(workLoad.substring(workLoad.length() / 2, workLoad.length())));
		return tasks;
	}

	private void processing(String workLoad) {
		System.out.println("Processed by Thread==>" + Thread.currentThread().getName() + " 	" + workLoad.toUpperCase());
	}

}
