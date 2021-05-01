package dev.coder400.statisticsj;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Float> dataset = new ArrayList<Float>();
		for(int i=0; i < 10; i++) {
			dataset.add((float) (i+1));
		}
		ContinuousDataHandle handle = new ContinuousDataHandle(dataset);
		System.out.println("Data: "+ handle.toString());
		System.out.println("Min: " + handle.getMin());
		System.out.println("Max: " + handle.getMax());
		System.out.println("Mean: " + handle.getMean());
		System.out.println("Median: " + handle.getMedian());
		System.out.println("LQ: " + handle.getLQ());
		System.out.println("UQ: " + handle.getUQ());
	}

}
