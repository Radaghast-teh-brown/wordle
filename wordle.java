import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class wordle {

    /*
     * The main purpose of this game is to guess the word according to its letters
     * The user has six chances to guess the hiding word.
     */

    public static void main(String[] args) throws FileNotFoundException {
        List<String> file = new ArrayList<>();
        Scanner sc = new Scanner(
                new FileReader("C:\\Users\\Radagast\\Desktop\\CODIGOS\\Java\\DIO-BOOTCAMP\\words.txt"));// Add the path
                                                                                                        // of the file
        String words;
        while (sc.hasNext()) {
            words = sc.next();
            file.add(words);
        }
        String[] array = file.toArray(new String[0]);
        Random rand = new Random();
        int random_number = rand.nextInt(array.length - 1);
        String missing_word = array[random_number];

        Character[] guess = new Character[5];
        for (int i = 0; i < 5; i++) {
            guess[i] = missing_word.charAt(i);
            guess[i] = Character.toLowerCase(guess[i]);
            System.out.print(guess[i]);
        }

        // The game
        System.out.println("----------------------Welcome to the game Wordle-----------------------");
        System.out.println("----You have six chances to guess the missing word with five letters---");
        System.out.println("-----------------------------------------------------------------------");

        Character[] answer = new Character[5];

        for (int i = 1; i <= 6; i++) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Type your " + i + "° word: ");
            String enter = sc1.next();
            enter = enter.toLowerCase();
            missing_word = missing_word.toLowerCase();

            if (enter.length() != 5 || enter.matches(".*\\d.")) {
                System.out.println("Invalid word!");
                System.out.println("You lost the game!");
                break;
            } else if (enter.equals(missing_word)) {
                System.out.println("You won the Game. Congratulations!");
                break;

            } else {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (enter.charAt(k) == guess[j]) {
                            answer[j] = guess[j];
                        }
                    }
                }
                for (int n = 0; n < 5; n++) {
                    if (answer[n] == null) {
                        answer[n] = '-';
                    }
                }
                for (int n = 0; n < 5; n++) {
                    System.out.print(answer[n] + " ");
                }

                boolean result = true;
                for (int n = 0; n < 5; n++) {
                    if (answer[n] == '-') {
                        result = false;
                    }
                }
                if (result == false) {
                    System.out.println("You lost the Game! The word is: " + missing_word);
                } else {
                    System.out.println("You won the Game. Congratulations!");
                }
            }
        }

    }

}
