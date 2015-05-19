package mergesort.sorting;

import mergesort.model.ParallelMergeSort;
import mergesort.util.MathUtil;

public class ParSort {
	static int LENGTH = 1000;
	static int RUNS = 16;
	static int NPARALLELSORT = 8;
	/*
	 * Number of threads = 2+4+8= 14
	 * 2^1 (dept=1) + 2^2 (dept=2) + 2^3 (dept=3)
	 * 
	 * 
	 * Produces 1000* 2 ^ RUNS element in every loop
	 * 
	 */

	public static void main(String[] args) throws Throwable {
		// int cores = Runtime.getRuntime().availableProcessors();
		for (int i = 1; i <= RUNS; i++) {

			// parallel
			int[] randomArrayForParallel = MathUtil.generateRandomNumber(LENGTH);
			long startTimeParallel = System.currentTimeMillis();
			ParallelMergeSort pms = new ParallelMergeSort(randomArrayForParallel, NPARALLELSORT);
			pms.sortArray();
			long endTimeParallel = System.currentTimeMillis();
			// System.out.println(Arrays.toString(randomArrayForParallel));
			
			
			System.out.println(LENGTH + " elements");
			System.out.printf("=>  %6d ms \n", endTimeParallel - startTimeParallel);
			LENGTH *= 2; // double size of array for next time
		}
		System.out.println("Parallel Finished");

	}

}
