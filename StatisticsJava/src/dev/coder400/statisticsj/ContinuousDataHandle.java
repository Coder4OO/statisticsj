package dev.coder400.statisticsj;

import java.util.ArrayList;

public class ContinuousDataHandle {

	private ArrayList<Float> data = new ArrayList<Float>();
	private float mean;
	private float uq;
	private float lq;
	private float median;
	private float min;
	private float max;
	
	private float calculateQuartile(ArrayList<Float> data, int quartile) {
		quartile %= 5;
		int length = data.size()+1;
		float value = 0;
		if(length % 4 == 0) {
			int index = length/4 * quartile;
			value = data.get(index-1);
		}
		else if(length % 2 == 0 && quartile == 2) {
			int index = length/2;
			value = data.get(index-1);
		}
		else {
			double index = length/4*quartile;
			int i1 = (int) Math.floor(index);
			int i2 = (int) Math.ceil(index);
			value = data.get(i1) + data.get(i2);
			value /= 2;
		}
		return value;
	}
	
	private float calculateMean(ArrayList<Float> data) {
		float sum = 0;
		for(int i=0; i < data.size(); i++) {
			sum += data.get(i);
		}
		return sum/data.size();
	}
	
	private float calculateMin() {
		float min = Float.POSITIVE_INFINITY;
		for(int i=0; i < data.size(); i++) {
			if(data.get(i) < min) {
				min = data.get(i);
			}
		}
		return min;
	}
	
	private float calculateMax() {
		float max = Float.NEGATIVE_INFINITY;
		for(int i=0; i < data.size(); i++) {
			if(data.get(i) > max) {
				max = data.get(i);
			}
		}
		return max;
	}
	
	public ContinuousDataHandle(ArrayList<Float> data) {
		this.data = data;
		this.lq = calculateQuartile(data, 1);
		this.median = calculateQuartile(data, 2);
		this.uq = calculateQuartile(data, 3);
		this.mean = calculateMean(data);
		this.min = calculateMin();
		this.max = calculateMax();
	}
	
	
	public ArrayList<Float> getData() {
		return data;
	}

	public float getMean() {
		return mean;
	}

	public float getUQ() {
		return uq;
	}

	public float getLQ() {
		return lq;
	}

	public float getMedian() {
		return median;
	}
	
	public float getMin() {
		return min;
	}
	
	public float getMax() {
		return max;
	}
	
	public float getSumofSquares() {
		float sum = 0;
		for(int i=0; i < data.size(); i++) {
			sum += Math.pow(data.get(i), 2);
		}
		return sum;
	}
	
	public float getStandardDeviation() {
		float calc1 = getSumofSquares()/data.size();
		float calc2 = (float) Math.pow(mean, 2);
		float sigma = (float) Math.sqrt(calc1 - calc2);
		return sigma;
	}
	
	public float getStandardisedScore(float rawscore) {
		return rawscore-mean/getStandardDeviation();
	}
	
	@Override
	public String toString() {
		String output = "";
		
		for(int i = 0; i < data.size(); i++) {
			output += " "+Float.toString(data.get(i));
		}
		
		return output;
	}
	
}
