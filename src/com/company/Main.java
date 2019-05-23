package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to HangMan!");
        System.out.println("Enter U if you want to choose the word or C if you want the computer to choose.");
        String p = kb.next();
        boolean b = false;

        if (p.equalsIgnoreCase("U")){
            System.out.println("Enter the number of letters in your word.");
            int length = kb.nextInt();
            HangMan t = new HangMan(length);
            System.out.println("For each letter the computer guesses, reply either TRUE if there are more letters to be found, or FALSE if I guessed your word. ");
            t.computerMove();

            while (!b) {
                String k = kb.next();
                b = !t.computerMove();
                if (b) {
                    System.out.println("I ran out of guesses. You win!");
                }
                else if (k.equalsIgnoreCase("false")) {
                    System.out.println("I win, thanks for playing!");
                    b = true;
                }

            }
        }

        else if (p.equalsIgnoreCase("C")) {
            HangMan t = new HangMan();
            System.out.println("Enter your difficulty: Easy    Medium    Hard    Expert");
            t.setMovesLeft(kb.next());
            while (!b) {
                System.out.println("Enter your guess.");
                b = t.userMove(kb.next());
            }
        }


    }
}
