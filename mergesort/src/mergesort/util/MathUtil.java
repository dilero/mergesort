package mergesort.util;

import java.util.Random;

public class MathUtil {

	public static int[] generateRandomNumber(int length) {
		int[] randomArray = new int[length];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = new Random().nextInt(10000);
		}
		return randomArray;
	}

}
