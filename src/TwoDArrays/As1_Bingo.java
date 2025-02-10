package TwoDArrays;

import java.util.Random;
import java.util.Scanner;

public class As1_Bingo {


    public static void run(){
        Scanner input = new Scanner(System.in);
        char[] titles = {'B','I','N','G','O'};
        int[][] bingo = new int[5][];
        for (int c = 0; c < bingo.length; c++) {
            if(c == 0){
                bingo[c]= generateArray(5,1,15);
            }
            if(c == 1){
                bingo[c] = generateArray(5,16,30);
            }
            if(c == 2){
                bingo[c] = generateArray(5,31,45);
            }
            if(c == 3){
                bingo[c] = generateArray(5,46,60);
            }
            if(c == 4){
                bingo[c] = generateArray(5,61,75);
            }

        }

        for (int i = 0; i < bingo.length; i++) {
            System.out.print(titles[i]+" ");
            for (int j = 0; j < bingo[i].length; j++) {
                System.out.print(bingo[i][j]+" ");
            }
            System.out.println();
        }

        while(true) {
            String choice = input.nextLine();

            if (choice.isEmpty()) {
                int ran = myRandom(1,75);
                boolean hasnum = false;
                System.out.println("The number chosen is: "+ran);
                for (int i = 0; i < bingo.length; i++) {
                    for (int j = 0; j < bingo[i].length; j++) {
                        if(bingo[i][j] == ran){
                            bingo[i][j] = -bingo[i][j];
                            printArray(bingo,titles);
                            System.out.println();
                            hasnum = true;
                        }
                    }
                }
                if(hasnum == false){
                    System.out.println("Not Found");
                }
                for (int i = 0; i < bingo.length; i++) {
                    if(checkRow(bingo[i]) || checkColumn(bingo, i)){
                        System.out.println("Bingo!");
                        return;
                    }
                }

            }
            System.out.println();

        }//while


    }


    public static int[] generateArray(int l, int min, int max){
        int[] newArray = new int[l];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i]= myRandom(min, max);
        }
        return newArray;

    }

    public static int myRandom(int min, int max) {
        int num = (int) (Math.random() * (max - min + 1) + min);
        return num;
    }

    public static void printArray(int[][] bingo, char[] titles){
        for (int i = 0; i < bingo.length; i++) {
            System.out.print(titles[i]+" ");
            for (int j = 0; j < bingo[i].length; j++) {
                System.out.print(bingo[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean checkRow(int[] row){
        for (int i = 0; i < row.length; i++) {
            if(row[i] > 0){
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(int[][] Array, int columnNum ){
        for (int j = 0; j < Array.length; j++) {
            if(Array[j][columnNum] > 0){
                return false;
            }
        }
        return true;
    }

}
