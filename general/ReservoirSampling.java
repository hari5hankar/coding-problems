import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * we are given a big array (or stream) of numbers 
 * (to simplify), write an efficient function to randomly select 
 * k numbers where 1 <= k <= n
 */
public class ReservoirSampling {

	private int[] reservoir;
	int k;

	public ReservoirSampling(int k) {
		this.k = k;
		reservoir = new int[k];
	}

	public void sample(int[] stream) {

		for (int i = 0; i < stream.length; i++) {
			if (i < k) {
				reservoir[i] = stream[i];
			} else {
				int r = (int) (Math.random() * (i + 1));
				if (r < k) {
					reservoir[r] = stream[i];
				}
			}
		}
	}

	public int[] getReservoir() {
		return reservoir;
	}

	public static void main(String[] args) {

		// a reservoir of size 10
		ReservoirSampling rs = new ReservoirSampling(5);

		// simulate the stream of numbers from 0 through 99
		int STREAM_SIZE = 100;
		int[] stream = new int[STREAM_SIZE];
		for (int i = 0; i < stream.length; i++) {
			stream[i] = i;
		}

		// experiments
		int[] histogram = new int[STREAM_SIZE];
		int NUM_EXPERIMENTS = 1000;
		for (int i = 0; i < NUM_EXPERIMENTS; i++) {
			rs.sample(stream);
			for (int r : rs.getReservoir()) {
				histogram[r]++;
			}
		}

		//results
		for (int i : histogram) {
			System.out.println(i);
		}
	}

}
