package less15;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Check implements Serializable{

	private static final long serialVersionUID = 4949694725765247103L;

	private double sum;
	
	private final LocalDateTime date = LocalDateTime.now();

	public Check(double sum) {
		this.sum = sum;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public String toString() {
		return sum + ", date=" + date;
	}
}
