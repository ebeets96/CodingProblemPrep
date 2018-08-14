import java.util.Arrays;

public class MergeSort {
	public static <T extends Comparable<T>> void mergeSort (T[] arr) {
		if(arr.length <= 1) {
			return;
		}
		
		T[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
		T[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
		
		mergeSort(left);
		mergeSort(right);
		
		int leftI = 0;
		int rightI = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(leftI == left.length) {
				System.arraycopy(right, rightI, arr, i, arr.length - i);
				return;
			}
			
			if(rightI == right.length) {
				System.arraycopy(left, leftI, arr, i, arr.length - i);
				return;
			}
			
			T leftVal = left[leftI];
			T rightVal = right[rightI];
			
			if(leftVal.compareTo(rightVal) < 0 ){
				arr[i] = leftVal;
				leftI++;
			} else {
				arr[i] = rightVal;
				rightI++;
			}
		}
	}
}
