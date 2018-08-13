
public class Sort {
	
	public static <T extends Comparable<T>> void quickSort (T[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static <T extends Comparable<T>> void quickSort (T[] arr, int low, int high) {
	      int index = partition(arr, low, high);

	      if (low < index - 1)
	            quickSort(arr, low, index - 1);

	      if (index < high)
	            quickSort(arr, index, high);
	}
	
	public static <T> void swap (T[] arr, int index1, int index2) {
		T temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static <T extends Comparable<T>> int partition (T[] arr, int low, int high) {
		T pivot = arr[high];
		int i = low;
		int j = high;
		
		while(i <= j) {
			//Find element greater than pivot at index i
			while(arr[i].compareTo(pivot) < 0) {
				i++;
			}
			
			//Find element smaller than pivot at index j
			while(arr[j].compareTo(pivot) > 0) {
				j--;
			}
			
			//Swap them if i < j
			if (i <= j) {
				swap(arr, i, j);
                i++;
                j--;
			}
		}
		
		return i;
	}
	
}
