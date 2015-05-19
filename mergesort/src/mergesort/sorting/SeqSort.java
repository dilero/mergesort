package mergesort.sorting;

import mergesort.model.SequentialMergeSort;
import mergesort.util.MathUtil;

public class SeqSort {
	static int LENGTH = 1000;
	static int RUNS = 16;
	public static void main(String[] args) {
		for (int i = 1; i <= RUNS; i++) {
			//sequential 
			int[] randomArrayForSeq = MathUtil.generateRandomNumber(LENGTH);
			long startTimeSeq = System.currentTimeMillis();
			SequentialMergeSort sms = new SequentialMergeSort(randomArrayForSeq);
			sms.sortArray();
			long endTimeSeq = System.currentTimeMillis();
		//	 System.out.println(Arrays.toString(randomArrayForSeq));
			
			
			
			System.out.println(LENGTH + " elements");
			System.out.printf("=>  %6d ms \n", endTimeSeq - startTimeSeq);
			LENGTH *= 2; // double size of array for next time
		}
		System.out.println(" Sequential Finished");
		

	}

}
