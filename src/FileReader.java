import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.HashSet;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileReader {

    public static HashSet<String> readFile(String path) {
        HashSet<String> output = new HashSet<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine().toUpperCase();
                output.add(line);
            }
            scanner.close();
            return output;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

}

