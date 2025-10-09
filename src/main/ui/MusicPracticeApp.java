package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicPracticeApp {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Avin's app what is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Welcome to your first class " + name + " !");

        System.out.println("What instrument would you like to play?");
    }
}
