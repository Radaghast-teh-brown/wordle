import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class wordle {

    /*
     * The main purpose of this game is to guess the word according to its letters
     */

    public static void main(String[] args) throws FileNotFoundException {
        List<String> file = new ArrayList<>();
        Scanner sc = new Scanner(
                new FileReader("C:\\Users\\Radagast\\Desktop\\CODIGOS\\Java\\DIO-BOOTCAMP\\words.txt"));
        String words;
        while (sc.hasNext()) {
            words = sc.next();
            file.add(words);

        }
        String[] array = file.toArray(new String[0]);
        Random rand = new Random();
        int random_number = rand.nextInt(array.length - 1);
        System.out.println(array[random_number]);

    }

}
