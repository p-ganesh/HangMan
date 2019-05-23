package com.company;

import java.util.ArrayList;

public class HangMan {
    private ArrayList<String> charsTarget = new ArrayList<String>();
    int vowel, letter;
    private String [] vowels = {"a", "e", "i", "o", "u", "y", "r", "s", "t", "n"};
    private String [] letters = {"q", "w", "p", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
    private String [] compWords = {"awkward", "bagpipes", "banjo", "bungler", "croquet", "crypt", "dwarves", "fervid",
            "fishhook", "fjord", "gazebo", "Gypsy", "haiku", "haphazard", "hyphen", "ivory", "jazzy", "jiffy", "jinx",
            "jukebox", "kayak", "kiosk", "klutz", "memento", "mystify", "numbskull", "ostracize", "oxygen", "pajama",
            "phlegm", "pixel", "polka", "quoad", "quip", "rhythmic", "rogue", "sphinx", "squawk", "swivel", "toady",
            "twelfth", "unzip", "waxy", "wildebeest", "yacht", "zealous", "zigzag", "zippy", "zombie"};
    private String target;
    public int movesLeft;
    private int guess;
    private String compGuess;
    private String currents;
    private String difficulty;
    private int highScore;
    private ArrayList<String> current = new ArrayList<String>();

    public HangMan(int x){
       movesLeft = x+2;
    }

    public HangMan() {
        target = compWords[(int)(Math.random()*compWords.length)];
        for (int i = 1; i <= target.length(); i++) {
            charsTarget.add(target.substring(i - 1, i));
            current.add("_ ");
        }
    }

    public void viewBoard () {
        for (int i = 0; i < current.size(); i++)
            System.out.print(current.get(i));
        System.out.println();
        System.out.println(movesLeft + " guesses left!");
    }

    public void setMovesLeft (String s) {
        difficulty = s;

        if (s.equalsIgnoreCase("easy"))
            movesLeft = target.length()+10;
        else if (s.equalsIgnoreCase("medium"))
            movesLeft = target.length()+5;
        else if (s.equalsIgnoreCase("hard"))
            movesLeft = target.length()+1;
        else if (s.equalsIgnoreCase("expert"))
            movesLeft = target.length();
        System.out.println("My word has " + target.length() + " letters in it.\nYou have " + movesLeft + " guesses.");
    }

    public boolean userMove (String s) {
        for (int i = 0; i < target.length(); i++) {
            if ((charsTarget.get(i)).equals(s) && current.get(i).equalsIgnoreCase("_ "))
                current.set(i, s);
        }
        String y = "";
        for (String d : current)
            y += d;
        if (y.equalsIgnoreCase(currents))
            movesLeft--;
        viewBoard();
        currents = "";
        for (String d : current)
            currents += d;
        if (currents.equals(target)){
            System.out.println("Congrats, you guessed the word!");
            return true; }
        else if (movesLeft == 0) {
            System.out.println("You used all of your moves. Man has been hanged. :( ");
            System.out.println("My word was: " + target);
            return true; }
        else
            return false;
    }

   public boolean computerMove() {
        String s;
        movesLeft--;
        if (movesLeft == -1)
            return false;
        int count = 0;
        while (true) {
            guess = (int) (Math.random() * vowels.length);
            if (vowels[guess] != null) {
                vowel = guess;
                s = vowels[guess];
                vowels[guess] = null;
                System.out.println(s);
                return true;
            }
            else if (count == (vowels.length-1)){
                vowel = -1;
                while (true) {
                    guess = (int) (Math.random()*letters.length);
                    if (letters[guess] != null) {
                        letter = guess;
                        s = letters[guess];
                        letters[guess] = null;
                        System.out.println(s);
                        return true;
                    }
                }
            }
        }

   }
}