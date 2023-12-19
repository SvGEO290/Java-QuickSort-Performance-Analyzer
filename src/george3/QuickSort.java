
package george3;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Samuel George
 */
public class QuickSort {
    // Quicksort implementation options
    
    
    private boolean shouldPrintResults;
    
    public QuickSort(boolean shouldPrintResults){
        this.shouldPrintResults = shouldPrintResults;  //the private var now equals the paramater.   
    }
    
    
    //this lets the user choose what method of the quicksort they would like to use.
    public <T extends Comparable<T>> void quickSort(T[] array, int left, int right, String pivotStrategy) {
        if ("specific".equals(pivotStrategy)) {
            quickSortMiddle(array, left, right);
        } else if ("medianOf3".equals(pivotStrategy)) {
            quickSortMedianOf3(array, left, right);
        } else if ("random".equals(pivotStrategy)) {
            quickSortRandom(array, left, right);
        } else {
            System.out.println("Invalid pivot strategy.");
        }
    }

    
    public int randomPivot(int left, int right) {
        Random rand = new Random();
        return rand.nextInt(right - left + 1) + left;
    }
    
    public <T extends Comparable<T>> void quickSortMiddle(T[] arr, int left, int right) {
        if (left >= right) {
        return;
        }
        int pivotIndex = (left + right) / 2;
        T pivot = arr[pivotIndex];
        int i = left;
        int j = right;
        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0) {
                i++;
            }
            while (arr[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (shouldPrintResults == true){
            System.out.println(Arrays.toString(arr));     
        }
        quickSortMiddle(arr, left, j);
        quickSortMiddle(arr, i, right);
    }
    
    public <T extends Comparable<T>> void swap(T arr[], int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //Median of 3 start
    
    public <T extends Comparable<T>> void quickSortMedianOf3(T[] arr, int left, int right) {
    if (left >= right) {
        return;
    }
    int pivotIndex = medianOf3(arr, left, right);
    T pivot = arr[pivotIndex];
    int i = left;
    int j = right;
    while (i <= j) {
        while (arr[i].compareTo(pivot) < 0) {
            i++;
        }
        while (arr[j].compareTo(pivot) > 0) {
            j--;
        }
        if (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    if (shouldPrintResults == true){
            System.out.println(Arrays.toString(arr));     
        }
    swap(arr, i, right - 1);
    
    //recursviley sorting 
    quickSortMedianOf3(arr, left, i - 1);
    quickSortMedianOf3(arr, i + 1, right);
    
 
}
    
    public <T extends Comparable<T>> int medianOf3(T[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left].compareTo(arr[mid]) > 0) {
            swap(arr, left, mid);
        }
        if (arr[left].compareTo(arr[right]) > 0) {
            swap(arr, left, right);
        }
        if (arr[mid].compareTo(arr[right]) > 0) {
            swap(arr, mid, right);
        }
        swap(arr, mid, right - 1);
        return right - 1;
    }
    
    public <T extends Comparable<T>> void quickSortRandom(T[] arr, int left, int right) {
    if (left >= right) {
        return;
    }
    if (left < right) {
        int pivotIndex = randomPivot(left, right);
        T pivot = arr[pivotIndex];
        int i = left;
        int j = right;
        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0) {
                i++;
            }
            while (arr[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (shouldPrintResults == true){
            System.out.println(Arrays.toString(arr));     
        }
        quickSortRandom(arr, left, j);
        quickSortRandom(arr, i, right);
    }
}

    // Additional methods for pivot selection strategies
}

