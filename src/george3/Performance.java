/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package george3;

import static george3.George3.generateRandomArray;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Samuel George
 */
public class Performance {
    public static void analytics(){
    int trials = 3;
        
        QuickSort quickSort = new QuickSort(false);

        ArrayList<Long> middleTimeArr = new ArrayList<>();
        ArrayList<Long> MedianOf3TimeArr = new ArrayList<>();
        ArrayList<Long> RandomTimeArr = new ArrayList<>();

        for (int i = 4; i <= 23; i++) {
            int size =(int) Math.pow(2, i);
            Integer[] arr = generateRandomArray(size);

            for (int j = 0; j < trials; j++) {
                Integer[] arrCopy = arr.clone();

                long middleStartTime = System.nanoTime();
                quickSort.quickSortMiddle(arrCopy, 0, arrCopy.length - 1);
                long middleEndTime = System.nanoTime();
                middleTimeArr.add(middleEndTime - middleStartTime);

                Integer[] arrCopy2 = arr.clone();
                long medianStartTime = System.nanoTime();
                quickSort.quickSortMedianOf3(arrCopy2, 0, arrCopy2.length - 1);
                long medianEndTime = System.nanoTime();
                MedianOf3TimeArr.add(medianEndTime - medianStartTime);

                Integer[] arrCopy3 = arr.clone();
                long randomStartTime = System.nanoTime();
                quickSort.quickSortRandom(arrCopy3, 0, arrCopy3.length - 1);
                long randomEndTime = System.nanoTime();
                RandomTimeArr.add(randomEndTime - randomStartTime);
            }
        }
        // TODO: Print values here
        
                // Print the timing results in a table
        System.out.println("N\tMedian of 3\tMiddle Element\tRandom");
        for (int i = 4; i <= 23; i++){
            System.out.println(((int)Math.pow(2, i)) + "\t" + MedianOf3TimeArr.get(i) + "\t\t" + middleTimeArr.get(i) + "\t\t" + RandomTimeArr.get(i));
        }}
       
}
