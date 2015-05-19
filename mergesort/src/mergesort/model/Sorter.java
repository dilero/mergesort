package mergesort.model;


public class Sorter extends ParallelMergeSort implements Runnable {
	public static int threadCounter=0;

	public Sorter(int[] unsortedArray, int threads) {
		super(unsortedArray, threads);
		threadCounter++;
//		System.out.println("New thread is created. #"+threadCounter);
	}

	@Override
	public void run() {
		sortArray();

	}

}
