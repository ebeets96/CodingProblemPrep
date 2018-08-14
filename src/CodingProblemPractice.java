import java.util.Arrays;
import java.util.Iterator;

public class CodingProblemPractice {

	public static void main(String[] args) {
		Integer[] arr = {3,5,1,8,4,6,11};
		Integer[] arr1 = Arrays.copyOf(arr, arr.length);
		Integer[] arr2 = Arrays.copyOf(arr, arr.length);
		
		testQuickSort(arr);
		System.out.println();
		testMergeSort(arr1);
		System.out.println();
		testBST(arr2);
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
	
	private static void testBST(Integer[] arr) {
		System.out.println("------ BST Insert/Delete Test -----");
		BST<Integer> bst = new BST<>();
		for(Integer i: arr) {
			bst.insert(i);
		}
		bst.print();
		bst.remove(5);
		bst.print();
		
		System.out.println("------ BST Contains Test -----");
		System.out.println("Contains 5: " + bst.contains(5));
		System.out.println("Contains 11: " + bst.contains(11));
		System.out.println("Contains 25: " + bst.contains(25));
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
