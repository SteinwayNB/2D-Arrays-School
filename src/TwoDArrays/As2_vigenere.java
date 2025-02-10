package TwoDArrays;


import java.util.Scanner;

public class As2_vigenere {

    public static void run() {
        Scanner in = new Scanner(System.in);
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K',
                'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int[] alphabetnum = new int[26];
        for (int i = 0; i < alphabetnum.length; i++) {
            alphabetnum[i] = i;
        }


        char[][] vigenere =createVSquare(alphabet);
        printSquare(vigenere);
//        System.out.println(getChar(vigenere,3,3));
//        System.out.println("Keycode: SCONA");
        System.out.println("Enter the encrypted message: ");
        String inmessage = in.nextLine();
        System.out.println("Enter the keycode");
        String inkey = in.nextLine();
        char[] inst = new char[inmessage.length()];
        char[] key = new char[inmessage.length()];
        int[] incode = new int[inmessage.length()];
        int[] keycode = new int[inmessage.length()];
        for (int i = 0; i < inmessage.length(); i++) {
            inst[i] = inmessage.charAt(i);
            System.out.print(inst[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < inst.length; i++) {
            incode[i] = linearSearch(alphabet, inst[i]);
            System.out.print(incode[i]+" ");
        }
        System.out.println();

        for (int i = 0; i < inmessage.length(); i++) {
            for (int j = 0; j < inkey.length(); j++) {
                if(i % inkey.length() == j){
                    key[i] = inkey.charAt(j);
                    keycode[i] = linearSearch(alphabet,inkey.charAt(j));
                }
            }

            System.out.print(key[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < keycode.length; i++) {
            System.out.print(keycode[i]+" ");
        }
        System.out.println();
        int[] sub = new int[inmessage.length()];
        char[] dec = new char[inmessage.length()];

        for (int i = 0; i < sub.length; i++) {
            sub[i] = (incode[i] - keycode[i]) % 26;
            if(sub[i] < 0){
                sub[i] = sub[i] + 26;
            }
            dec[i] = alphabet[sub[i]];
            System.out.print(dec[i]+" ");
        }


    }

    private static char[][] createVSquare(char[] alphabet) {
        char[][] square = new char[alphabet.length][alphabet.length];
//code to be written
        for (int i = 0; i < alphabet.length; i++) {
            char[] newalphabet = new char[alphabet.length];
            for (int s = 0; s < alphabet.length; s++) {
                newalphabet[s]=alphabet[(i+s) % alphabet.length];
            }
            square[i] = newalphabet;

        }

        return square;
    }//createVSquare

    public static void printSquare(char[][] square) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                System.out.print(square[i][j]+" ");
            }
            System.out.println();
        }
    }//end printSquare

    public static int linearSearch (char[] arr, char searchTerm){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == searchTerm){
                return i;
            }
        }
        return -1;
    }

    public static char getChar(char[][] arr, int row, int col){
        return arr[row][col];
    }

}//end class
