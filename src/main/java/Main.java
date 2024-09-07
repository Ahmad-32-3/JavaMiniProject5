/*
Filename: W13U3A4_MuhammadAhmad_Sorting
Author:  Muhammad Ahmad
Date: Friday, May 25, 2024
Purpose: To create a program that sorts 10 random numbers through different sorting methods and counts the number of iterations, comparisons and shifts in each method
*/
// import libraries
import java.util.Random;
import java.util.Arrays;

public class Main {

  // global variables to use in quick sort
  static int qcomparisonCounter = 0;
  static int qloopCounter = 0;
  static int qshiftCounter = 0;

  public static void main(String[] args) {
    // initialize variable
    int randomInteger;
    int[] list = new int[10];

    System.out.println("Random 10 numbers unsorted(-1000 -> 1000): ");
    // Instance of a random class
    Random rand = new Random();

    // Generate 10 random values between -1000 and 1000
    for (int i = 0; i < 9; i++) {
      // Generate a random number
      randomInteger = rand.nextInt(2001) - 1000;
      // Print out number
      System.out.print(randomInteger + ", ");
      // Set random number to index in list
      list[i] = randomInteger;
    }
    // Print outside of loop to avoid comma at the end
    System.out.print(list[9] = rand.nextInt(2001) - 1000);

    // Copies of array
    int[] listBubble = Arrays.copyOf(list, list.length);
    int[] listInsert = Arrays.copyOf(list, list.length);
    int[] listQuick = Arrays.copyOf(list, list.length);

    // call selection short method
    selectionSort(list);

    // call bubble sort method
    bubbleSort(listBubble);

    // call insertion sort method 
    insertionSort(listInsert);

    // call quick sort method
    quickSort(listQuick);

  }

  // Method to print array
  public static void printArray(int[] list) {
    // Makes array into a string to print out easily without looping
    System.out.println(Arrays.toString(list));
  }

  public static void selectionSort(int[] list) {
    int i, j, minValue, minIndex, temp = 0, loopCounter = 0, comparisonCounter = 0, shiftCounter = 0;
    for (i = 0; i < list.length; i++) {
      minValue = list[i];
      minIndex = i;
      // Counts number of iterations
      loopCounter++;

      // use for loops to find smallest value in array
      for (j = i; j < list.length; j++) {
        if (list[j] < minValue) {
          minValue = list[j];
          minIndex = j;
        }
        // Counts number of comparisons
        comparisonCounter++;
        // Loop Counter
        loopCounter++;
      }
      // Swaps values
      if (minValue < list[i]) {
        temp = list[i];
        list[i] = list[minIndex];
        list[minIndex] = temp;
        // Counts number of shifts
        shiftCounter++;
      }
      // Comparison counter
      comparisonCounter++;
    }

    // Prints out the array
    System.out.println("\n\nSelection Sort: ");
    printArray(list);
    System.out.println("Number of times the loop was executed: " + loopCounter);
    System.out.println("Number of times a comparison was made: " + comparisonCounter);
    System.out.println("Number of times a value was shifted: " + shiftCounter);
  }

  public static void bubbleSort(int[] list) {
    int i, j, temp = 0, loopCounter = 0, comparisonCounter = 0, shiftCounter = 0;

    for (i = 0; i < list.length - 1; i++) {
      // Loop counter
      loopCounter++;

      // use for loops to check if value is greater than the next value
      for (j = 0; j < list.length - 1 - i; j++) {
        // Comparison and loop counter
        comparisonCounter++;
        loopCounter++;

        if (list[j] > list[j + 1]) {
          temp = list[j];
          list[j] = list[j + 1];
          list[j + 1] = temp;

          // Shift counter
          shiftCounter++;
        }
      }
    }
    // Prints out array
    System.out.println("\n\nBubble Sort: ");
    printArray(list);
    System.out.println("Number of times the loop was executed: " + loopCounter);
    System.out.println("Number of times a comparison was made: " + comparisonCounter);
    System.out.println("Number of times a value was shifted: " + shiftCounter);
  }

  public static void insertionSort(int[] list) {
    int i, j, key, temp;
    int loopCounter = 0;
    int comparisonCounter = 0;
    int shiftCounter = 0;

    // starts from second element and iterates through array
    for (i = 1; i < list.length; i++) {
      key = list[i];
      j = i - 1;
      // Loop counter
      loopCounter++;

      while (j >= 0 && key < list[j]) {
        // Loop counter
        loopCounter++;

        // swap elements
        temp = list[j];
        list[j] = list[j + 1];
        list[j + 1] = temp;

        // Shift and comparison counter
        shiftCounter++;
        comparisonCounter++;
        j--;
      }
      
      if (j < 0 || key > list[j]) {
        // Comparison counter
        comparisonCounter++;
      }
      
    }
    // print out array
    System.out.println("\n\nInsertion Sort: ");
    printArray(list);
    System.out.println("Number of times the loop was executed: " + loopCounter);
    System.out.println("Number of times a comparison was made: " + comparisonCounter);
    System.out.println("Number of times a value was shifted: " + shiftCounter);
  }

  public static void quickSort(int[] A) {

    // calls the reucursive method
    quickSort(A, 0, A.length - 1);

    // prints out array
    System.out.println("\n\nQuick Sort: ");
    printArray(A);
    System.out.println("Number of times the loop was executed: " + qloopCounter);
    System.out.println("Number of times a comparison was made: " + qcomparisonCounter);
    System.out.println("Number of times a value was shifted: " + qshiftCounter);
  }

  private static void quickSort(int[] A, int low, int high) {
    
    // Comparison counter
    qcomparisonCounter++;

    if (low < high + 1) {
      int p = partition(A, low, high);
      quickSort(A, low, p - 1);
      quickSort(A, p + 1, high);
    }
  }

  private static void swap(int[] A, int index1, int index2) {
    int temp = A[index1];
    A[index1] = A[index2];
    A[index2] = temp;
  }

  private static int getPivot(int low, int high) {
    Random rand = new Random();
    return rand.nextInt((high - low) + 1) + low;
  }

  private static int partition(int[] A, int low, int high) {
    swap(A, low, getPivot(low, high));

    // shift counter
    qshiftCounter++;

    int border = low + 1;

    // iterate from border to high
    for (int i = border; i <= high; i++) {
      qloopCounter++;

      // comparison counter
      qcomparisonCounter++;
      if (A[i] < A[low]) {
        swap(A, i, border++);

        // shift counter
        qshiftCounter++;
      }

    }

    // swap elements
    swap(A, low, border - 1);
    // shift counter
    qshiftCounter++;

    return border - 1;
  }

}