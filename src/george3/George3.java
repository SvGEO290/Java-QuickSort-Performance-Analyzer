package george3;
/**
 *
 * @author Samuel George
 */

import java.util.ArrayList;
import java.util.Random;


public class George3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Integer[] newArray1 = generateRandomArray(15);
        Integer[] newArray2 = generateRandomArray(15);
        Integer[] newArray3 = generateRandomArray(15);
        
        QuickSort quickSort = new QuickSort(true);
        
        System.out.println("Quick Sort");
        
        
        System.out.println("Middle");
        quickSort.quickSort(newArray1, 0, 14, "specific");
        
        System.out.println("Median");
        quickSort.quickSort(newArray2, 0, 14, "medianOf3");
        
        System.out.println("Random");
        quickSort.quickSort(newArray3, 0, 14, "random");
        
        System.out.println("\n");
        
        Performance.analytics();
    }
    
    //method for creating the random array
    public static Integer[] generateRandomArray(int size) {
        Integer[] randomArray = new Integer[size];
        Random random = new Random();
        
        for(int i = 0; i < size; i++){
            randomArray[i] = random.nextInt(100);
        
        }
        
        return randomArray;
    }
               
        
    
    
    
    
}
