import java.util.*;

public class Game {


    HashSet<String> words = FileReader.readFile(".\\words.txt");

    HashSet<Character> disallowedChars = new HashSet<>();


    public Game(int difficulty) {
        if(difficulty == 1) {
            disallowedChars.addAll(Arrays.asList('J', 'V', 'Q', 'X', 'Y', 'Z'));
        }
    }


    public void play() {
        int totalScore = 0;
        totalScore += playRound(3);
        totalScore += playRound(3);
        totalScore += playRound(3);
        System.out.println("You got " + totalScore + " points that game. Congratulations!");
    }


    public int playRound(int charCount) {
        ArrayList<Character> chars = generateChars(charCount);

        System.out.println("Your characters are:");
        for(char c : chars) {
            System.out.println(c);
        }
        System.out.println("Please make a word:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();

        System.out.println(isValidWord(input, chars));

        if(isValidWord(input, chars)) {
            return input.length();
        } else {
            return 0;
        }
    }


    public ArrayList<Character> generateChars(int charCount) {
        ArrayList<Character> chars = new ArrayList<>(charCount);
        Random random = new Random();
        for(int i = 0 ; i < charCount ; i++) {
            char c = (char) (random.nextInt(26) + 65);
            if(!disallowedChars.contains(c)) {
                chars.add(c);
            } else {
                i--;
            }
        }
        return chars;
    }


    public boolean isValidWord(String word, ArrayList<Character> chars) {
        return usesChars(word, chars) && isWord(word);
    }


    public boolean usesChars(String word, ArrayList<Character> chars) {
        word = word.toUpperCase();
        int charPointer = 0;
        int nrOfChars = chars.size();
        for (int i = 0 ; i < word.length() ; i++) {

            if(chars.get(charPointer) == word.charAt(i)) {
                charPointer++;
                if(charPointer == nrOfChars) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isWord(String word) {
        return words.contains(word);
    }

}
