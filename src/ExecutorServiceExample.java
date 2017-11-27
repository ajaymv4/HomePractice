
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

	
	private static ExecutorService workerPool = Executors.newFixedThreadPool(5); 
	
	public static void main(String[] argv) throws Exception {
		int capacity = 10;
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(capacity);

		for (int i = 0; i < 10; i++) {
			queue.put(i);
		}
		
		Work task1 = new Work(queue);
		Work task2 = new Work(queue);
		
		workerPool.execute(task1);
		workerPool.execute(task2);
		
		workerPool.shutdown();
        while (!workerPool.isTerminated()) {
        }
        System.out.println("Finished all threads");
	}
}

class Work implements Runnable {
	BlockingQueue<Integer> q;

	Work(BlockingQueue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Integer x = q.poll();
				if (x == null) {
					break;
				}
				Thread.sleep(5000);
				System.out.println(x + " Processed by " +Thread.currentThread().getName());
			}
		} catch (Exception e) {
		}
	}

}
