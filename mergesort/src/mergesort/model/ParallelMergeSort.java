package mergesort.model;

import java.util.Arrays;

public class ParallelMergeSort extends MergeSort {

	public int numberOfThreads;

	public ParallelMergeSort(int[] unsortedArray, int threads) {
		super(unsortedArray);
		numberOfThreads = threads;
	}
@Override
	public void sortArray() {
		if (numberOfThreads <= 1) {
			mergeSort(sortingArray);
		} else if (sortingArray.length >= 2) {
			// split array in half
			int[] leftArray = Arrays.copyOfRange(sortingArray, 0, sortingArray.length / 2);
			int[] rightArray = Arrays.copyOfRange(sortingArray, sortingArray.length / 2, sortingArray.length);
			numberOfThreads= numberOfThreads/2;
			Sorter leftSorter = new Sorter(leftArray, numberOfThreads);
			Thread leftThread = new Thread(leftSorter);
			Sorter rightSorter = new Sorter(rightArray, numberOfThreads);
			Thread rightThread = new Thread(rightSorter);
			leftThread.start();
			rightThread.start();
			try {
				leftThread.join();
				rightThread.join();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			merge(leftArray, rightArray, sortingArray);
		}

	}

}
