package alex.algorithms.arrays;

public class MaximumDifference {

	public static int maxDiff(int arr[]) {
		int diff = arr[1] - arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - min > diff) {
				diff = arr[i] - min;
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return diff;
	}

	public static int maxIndexDiff(int array[]) {
		int[] LMIN = new int[array.length];
		int[] RMAX = new int[array.length];
		LMIN[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			LMIN[i] = Math.min(array[i], LMIN[i - 1]);
		}
		RMAX[array.length - 1] = array[array.length - 1];
		for (int i = array.length - 2; i >= 0; i--) {
			RMAX[i] = Math.max(array[i], RMAX[i + 1]);
		}
		int maxDiff = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		while (i < array.length && j < array.length) {
			if (LMIN[i] < RMAX[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			} else {
				i++;
			}
		}
		return maxDiff;
	}

	// O(2^n)???
	public static int maxIndexDiffRec(int[] array, int start, int end) {
		if (end < start)
			return -1;
		if (array[end] > array[start]) {
			int x = end - start;
			return x;
		} else {
			int x = maxIndexDiffRec(array, start + 1, end);
			int y = maxIndexDiffRec(array, start, end - 1);
			return Math.max(x, y);
		}
	}

	public static int maxDiffKadane(int[] array) {
		int diff = array[1] - array[0];
		int currentSum = diff;
		int maxSum = currentSum;
		for (int i = 1; i < array.length - 1; i++) {
			diff = array[i + 1] - array[i];
			if (currentSum > 0) {
				currentSum += diff;
			} else
				currentSum = diff;
			if (currentSum > maxSum)
				maxSum = currentSum;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int array[] = { 80, 2, 6, 3, 100 };
		System.out.printf("%d\n", maxDiff(array));
		System.out.printf("%d\n", maxDiffKadane(array));
	}

}