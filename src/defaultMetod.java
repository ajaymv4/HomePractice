import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;


class Response{

	long count;
	double sum;
	double avg;
	double min;
	double max;
	/**
	 * @return the count
	 */
	public long getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(long count) {
		this.count = count;
	}
	/**
	 * @return the sum
	 */
	public double getSum() {
		return sum;
	}
	/**
	 * @param sum the sum to set
	 */
	public void setSum(double sum) {
		this.sum = sum;
	}
	/**
	 * @return the avg
	 */
	public double getAvg() {
		return avg;
	}
	/**
	 * @param avg the avg to set
	 */
	public void setAvg(double avg) {
		this.avg = avg;
	}
	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}
	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}
	
	
	
}

public class defaultMetod {
	
	public static void main(String arg[]) {

		Map<Long,Double> input = new TreeMap<>();
		
		Long currentTime = 90L;
		
		input.put(10L, 15.5);
		input.put(20L, 20.5);
		input.put(30L, 10.5);
		input.put(35L, 0.5);
		input.put(40L, 25.5);
		input.put(50L, 30.5);
		
		DoubleSummaryStatistics stats = input.entrySet().stream()
													  .filter(e->(currentTime-e.getKey() <= 60))
													  .collect(Collectors.summarizingDouble(Entry::getValue));
	
		Response response = new Response();
		response.setCount(stats.getCount());
		response.setSum(stats.getSum());
		response.setAvg(stats.getAverage());
		response.setMax(stats.getMax());
		response.setMin(stats.getMin());
		
		
		
}
	
}	
	
	
