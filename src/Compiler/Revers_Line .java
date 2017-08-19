package Compiler;

import java.util.Scanner;

class Revers_Line {
    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public Revers_Line() {
    }

    public static void main(String[] args) {
        String[] inString = scanner.nextLine().split(" ");

        for(int i = inString.length - 1; i >= 0; --i) {
            System.out.print(inString[i] + " ");
        }

    }
}
