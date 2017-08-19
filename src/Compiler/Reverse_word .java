package Compiler;

import java.util.Scanner;

class Reverse_word {
    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public Reverse_word() {
    }

    public static void main(String[] args) {
        String[] inString = scanner.nextLine().split(" ");
        String[] var5 = inString;
        int var4 = inString.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            String temp = var5[var3];
            char[] temp2 = temp.toCharArray();

            for(int i = temp2.length - 1; i >= 0; --i) {
                System.out.print(temp2[i]);
            }

            System.out.print(" ");
        }

    }
}
