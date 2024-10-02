package test;

import game.RaffleCup;

/**
 * Class for testing according to the specifications:
 * - The distribution of the 6-sided die: simple counting of the observed face values.
 * - The max time of rolling the dice with the raffle cup.
 */
public class Test {
    public static void main(String[] args) {
        int[] countArrFaceValue = new int[6]; // Array to keep track of the face value count.
        long maxTime = Long.MIN_VALUE; // To keep track of the max time experienced for each roll.

        RaffleCup cup = new RaffleCup();

        for (int i = 0; i < 1000; i++) {
            /*
              Start measuring execution time.
              @source https://www.geeksforgeeks.org/measure-time-taken-function-java/; accessed: 2024/10/01.
             */
            long startTime = System.nanoTime();

            cup.roll();

            // Stop measuring execution time.
            long endTime = System.nanoTime();

            // Calculate the execution time in nanoseconds.
            long executionTime
                    = (endTime - startTime);

            // Update max if higher time observed.
            if (executionTime > maxTime) {
                maxTime = executionTime;
            }

            // Increment face value counter in our counter array.
            countArrFaceValue[cup.getValue(0)-1]++;

        }

        // Output of our test, writing to the terminal.
        // Count of the different face values
        System.out.println("The count of the different face values of die 1 of the raffle cup:");
        for (int i = 0; i < countArrFaceValue.length; i++) {
            System.out.println("Face value: " + (i+1) + ", count: " + countArrFaceValue[i]);
        }

        // The max time we've measured
        System.out.println("The max time we've measured: " + maxTime + " nanoseconds.");

    }

}
