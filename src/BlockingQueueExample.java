import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] argv) throws Exception {
		int capacity = 10;
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(capacity);

		int numWorkers = 2;
		Worker[] workers = new Worker[numWorkers];
		for (int i = 0; i < workers.length; i++) {
			workers[i] = new Worker(queue,i);
			workers[i].start();
			System.out.println("Worker Thread "+workers[i].getName()+" created and waiting....");
		}

		for (int i = 0; i < 10; i++) {
			queue.put(i);
		}
	}
}

class Worker extends Thread {
	BlockingQueue<Integer> q;

	Worker(BlockingQueue<Integer> q, int i) {
		this.q = q;
		this.setName("Thread"+i);
	}

	public void run() {
		try {
			while (true) {
				Integer x = q.poll();
				if (x == null) {
					break;
				}
				System.out.println(x+" Processed by "+this.getName());
			}
		} catch (Exception e) {
		}
	}
}
