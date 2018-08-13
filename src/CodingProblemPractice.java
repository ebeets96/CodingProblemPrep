import java.util.Arrays;

public class CodingProblemPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {3,5,1,8,4,5};
		Integer[] sorted = {3,5,1,8,4,5};
		Arrays.sort(sorted);
		
		System.out.print("Original: ");
		print(arr);
		System.out.print("\nCorrect: ");
		print(sorted);
		
		Sort.quickSort(arr);
		System.out.print("\nResult: ");
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
