import java.util.Arrays;

public class CodingProblemPractice {

	public static void main(String[] args) {
		Integer[] arr = {3,5,1,8,4,5,6,11};
		testQuickSort(arr);
		Integer[] arr1 = Arrays.copyOf(arr, arr.length);
		testMergeSort(arr1);
	}

	private static void testMergeSort(Integer[] arr) {
		System.out.println("------ Merge Sort -----");
		
		Integer[] sorted = Arrays.copyOf(arr, arr.length);
		Arrays.sort(sorted);
		
		System.out.print("Original: ");
		print(arr);
		System.out.print("Correct: ");
		print(sorted);
		
		MergeSort.mergeSort(arr);
		System.out.print("Result: ");
		print(arr);
	}
	
	private static void testQuickSort(Integer[] arr) {
		System.out.println("------ Quick Sort -----");
		Integer[] sorted = Arrays.copyOf(arr, arr.length);
		Arrays.sort(sorted);
		
		System.out.print("Original: ");
		print(arr);
		System.out.print("Correct: ");
		print(sorted);
		
		QuickSort.quickSort(arr);
		System.out.print("Result: ");
		print(arr);
	}
	
	public static <T> void print(T[] arr) {
		StringBuilder sb = new StringBuilder("[");
		
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if(i != arr.length - 1)
				sb.append(", ");
		}
		sb.append("]");
		
		System.out.println(sb);
	}

}
