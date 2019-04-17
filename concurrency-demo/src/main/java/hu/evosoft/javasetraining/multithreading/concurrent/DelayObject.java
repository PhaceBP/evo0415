package hu.evosoft.javasetraining.multithreading.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayObject implements Delayed {

	private String data;
	private long startTime;

	public DelayObject(String data, long delayInMilliseconds) {
		this.data = data;
		this.startTime = System.currentTimeMillis() + delayInMilliseconds;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		return (int) (this.startTime - ((DelayObject) o).startTime);
	}

	public long getStartTime() {
		return startTime;
	}

	public String getData() {
		return data;
	}

}