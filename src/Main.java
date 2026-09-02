import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class GameDictionary {
    private final Set<String> validWords = new HashSet<>();

    //loadDictionary is used here to get all the words from the txt document(local library) used to validate inputs collected throughout the game
    //which can as well be edited to add more words
    //dictionary gotten from DWYL English Words GitHub
    public void loadDictionary(String filepath) {
        try (Scanner fileScanner = new Scanner(new File(filepath))) {
            while (fileScanner.hasNext()) {
                //adds all the words to the hashset 'validWords' and capitalizes all to make it easier during validation
                validWords.add(fileScanner.next().toUpperCase());
            }
        } catch (FileNotFoundException e) {
            IO.println("Dictionary file not found.");
        }
    }

    public boolean isValid(String word) {
        return validWords.contains(word.toUpperCase());
    }
}

public class Main {

    static void main() {
        Scanner scinput = new Scanner(System.in);
        GameDictionary GD = new GameDictionary();
        GD.loadDictionary("words.txt");//dictionary location

        IO.println("Which Game mode do you wanna play? : ");
        IO.println("1.Cars \n2.Phones \n3.Characters");
        int Choice = scinput.nextInt();
        switch (Choice) {
            case 1:
                Cars cargame = new Cars(GD);//Cars(GD) 'GD' here is used to pass the dictionary into the Cars class via a constructor
                cargame.submenu();
                break;
            case 2:
                Phones pon = new Phones(GD);
                pon.submenu();
                break;
            case 3:
                Characters cha = new Characters(GD);
                cha.submenu();
                break;
            default:
                IO.println("Choice unavailable");
        }
    }
}


class Cars {
    GameDictionary dictionary;
    Scanner crScanner = new Scanner(System.in);

    public Cars(GameDictionary dictionary) {
        //receives the dictionary via a constructor
        this.dictionary = dictionary;
    }

    public void submenu() {
        Random random = new Random();
        //randomly choose between the 3 words used for this category
        int play = random.nextInt(3);
        switch (play) {
            case 0:
                FirstCar();
                break;
            case 1:
                SecondCar();
                break;
            case 2:
                ThirdCar();
                break;
        }
    }

    void FirstCar() {
        //KOENIGSEGG to be guessed
        String firstCarWord = "KOENIGSEGG";
        char[] Word = {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_',};
        int trialcount = 10;
        for (int trial = 0; trial < trialcount; trial++) {
            IO.println(Arrays.toString(Word));
            IO.println("Trials left :" + (trialcount - trial));
            String guess = crScanner.next().toUpperCase();

            if (guess.length() > 1) {
                //if the length of the word is greater than one it runs a validation check to see if sure word exists or is in the dictionary
                //this determines the flow of the remaining if statements
                //Words can be added in the local dictionary if needed
                if (!dictionary.isValid(guess)) {
                    IO.println("'" + guess + " is not a valid word");
                } else {
                    //converts the input to an array so it can be checked one at a time and compared to the word needed
                    char[] guessArray = guess.toCharArray();
                    //assigns each character one by one to c so it can be compared
                    for (char c : guessArray) {
                        for (int i = 0; i < firstCarWord.length(); i++) {
                            //if a character (in the input) is found to match another (in the firstCarWord) it would replace '_' in the Word variable depending on the position it was found to be the same
                            if (firstCarWord.charAt(i) == c) {
                                Word[i] = c;
                            }
                        }
                    }
                    //if the Word variable is filled it would no longer need to run any longer since the game has been conquered to the loop breaks
                    if (String.valueOf(Word).equals(firstCarWord.toUpperCase())) {
                        IO.println("😒😒Congratulations you guessed " + firstCarWord);
                        break;
                    }
                }
            } else {
                IO.println("You have to guess a word");
            }
        }
        //runs a check after the loop has ended which is determined by the trialcount to see if all characters has been altered from its original state
        if (String.valueOf(Word).contains("_")) {
            IO.println("🤣🤣🤣🤣 You lose Game over");
        }
    }

    void SecondCar() {
        //Lamborghini to be guessed
        String secondCarWord = "Lamborghini";
        char[] word = {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_',};
        int trailCount = 10;
        for (int trial = 0; trial < trailCount; trial++) {
            IO.println(Arrays.toString(word));
            IO.println("trials left " + (trailCount - trial));
            String guess = crScanner.next().toUpperCase();

            if (guess.length() > 1) {
                if (!dictionary.isValid(guess)) {
                    IO.println("' " + guess + " is not a valid word");
                } else {
                    char[] guessArray = guess.toCharArray();
                    for (char c : guessArray) {
                        for (int i = 0; i < secondCarWord.length(); i++) {
                            if (secondCarWord.toUpperCase().charAt(i) == c) {
                                word[i] = c;
                            }
                        }
                    }
                }
            } else {
                IO.println("you have to guess a word");
            }
            if (String.valueOf(word).equals(secondCarWord.toUpperCase())) {
                IO.println("😒😒😒 Congratulations you win " + Arrays.toString(word) + " is the word");
                break;
            }
        }
        if (String.valueOf(word).contains("_")) {
            IO.println("🤣🤣 you lose Game Over");
        }
    }

    void ThirdCar() {
        //RENAULT to be guessed
        String thirdCarWord = "Renault";
        char[] word = {'_', '_', '_', '_', '_', '_', '_',};
        int trailCount = 8;
        for (int trial = 0; trial < trailCount; trial++) {
            IO.println(Arrays.toString(word));
            IO.println("trials left " + (trailCount - trial));
            String guess = crScanner.next().toUpperCase();

            if (guess.length() > 1) {
                if (!dictionary.isValid(guess)) {
                    IO.println("' " + guess + " is not a valid word");
                } else {
                    char[] guessArray = guess.toCharArray();
                    for (char c : guessArray) {
                        for (int i = 0; i < thirdCarWord.length(); i++) {
                            if (thirdCarWord.toUpperCase().charAt(i) == c) {
                                word[i] = c;
                            }
                        }
                    }
                }
            } else {
                IO.println("you have to guess a word");
            }
            if (String.valueOf(word).equals(thirdCarWord.toUpperCase())) {
                IO.println("😒😒😒 Congratulations you win " + Arrays.toString(word) + " is the word");
                break;
            }
        }
        if (String.valueOf(word).contains("_")) {
            IO.println("🤣🤣 you lose Game Over");
        }
    }
}

class Phones {
    Scanner phScanner = new Scanner(System.in);
    GameDictionary dictionary;

    public Phones(GameDictionary dictionary) {
        //receives the dictionary via a constructor
        this.dictionary = dictionary;
    }
    public void submenu() {
        Random random = new Random();
        int play = random.nextInt(3);
        switch (play) {
            case 0:
                firstPhone();
                break;
            case 1:
                secondPhone();
                break;
            case 2:
                thirdPhone();
                break;
        }
    }

    void firstPhone() {
        //XIAOMI to be guessed
        String firstPhoneWord = "Xiaomi";
        char[] Word = {'_', '_', '_', '_', '_', '_',};
        int trialcount = 7;
        for (int trial = 0; trial < trialcount; trial++) {
            IO.println(Arrays.toString(Word));
            IO.println("Trials left :" + (trialcount - trial));
            String guess = phScanner.next().toUpperCase();

            if (guess.length() > 1) {
                //if the length of the word is greater than one it runs a validation check to see if sure word exists or is in the dictionary
                //this determines the flow of the remaining if statements
                //Words can be added in the local dictionary if needed
                if (!dictionary.isValid(guess)) {
                    IO.println("'" + guess + " is not a valid word");
                } else {
                    //converts the input to an array so it can be checked one at a time and compared to the word needed
                    char[] guessArray = guess.toCharArray();
                    //assigns each character one by one to c so it can be compared
                    for (char c : guessArray) {
                        for (int i = 0; i < firstPhoneWord.length(); i++) {
                            //if a character (in the input) is found to match another (in the firstCarWord) it would replace '_' in the Word variable depending on the position it was found to be the same
                            if (firstPhoneWord.toUpperCase().charAt(i) == c) {
                                Word[i] = c;
                            }
                        }
                    }
                    //if the Word variable is filled it would no longer need to run any longer since the game has been conquered to the loop breaks
                    if (String.valueOf(Word).equals(firstPhoneWord.toUpperCase())) {
                        IO.println("😒😒Congratulations you guessed " + firstPhoneWord);
                        break;
                    }
                }
            } else {
                IO.println("You have to guess a word");
            }
        }
        //runs a check after the loop has ended which is determined by the trialcount to see if all characters has been altered from its original state
        if (String.valueOf(Word).contains("_")) {
            IO.println("🤣🤣🤣🤣 You lose Game over");
        }
    }

    void secondPhone() {
        //QUKITEL to be guessed
        String secondPhoneWord = "QUKITEL";
        char[] Word = {'_', '_', '_', '_', '_', '_','_',};
        int trialcount = 9;
        for (int trial = 0; trial < trialcount; trial++) {
            IO.println(Arrays.toString(Word));
            IO.println("Trials left :" + (trialcount - trial));
            String guess = phScanner.next().toUpperCase();

            if (guess.length() > 1) {
                if (!dictionary.isValid(guess)) {
                    IO.println("'" + guess + " is not a valid word");
                } else {
                    char[] guessArray = guess.toCharArray();
                    for (char c : guessArray) {
                        for (int i = 0; i < secondPhoneWord.length(); i++) {
                            if (secondPhoneWord.toUpperCase().charAt(i) == c) {
                                Word[i] = c;
                            }
                        }
                    }
                    if (String.valueOf(Word).equals(secondPhoneWord.toUpperCase())) {
                        IO.println("😒😒Congratulations you guessed " + secondPhoneWord);
                        break;
                    }
                }
            } else {
                IO.println("You have to guess a word");
            }
        }
        if (String.valueOf(Word).contains("_")) {
            IO.println("🤣🤣🤣🤣 You lose Game over");
        }
    }

    void thirdPhone() {
        //HUAWEI to be guessed
        String thirdPhoneWord = "HUAWEI";
        char[] Word = {'_', '_', '_', '_', '_', '_',};
        int trialcount = 8;
        for (int trial = 0; trial < trialcount; trial++) {
            IO.println(Arrays.toString(Word));
            IO.println("Trials left :" + (trialcount - trial));
            String guess = phScanner.next().toUpperCase();

            if (guess.length() > 1) {
                if (!dictionary.isValid(guess)) {
                    IO.println("'" + guess + " is not a valid word");
                } else {
                    char[] guessArray = guess.toCharArray();
                    for (char c : guessArray) {
                        for (int i = 0; i < thirdPhoneWord.length(); i++) {
                            if (thirdPhoneWord.toUpperCase().charAt(i) == c) {
                                Word[i] = c;
                            }
                        }
                    }
                    if (String.valueOf(Word).equals(thirdPhoneWord.toUpperCase())) {
                        IO.println("😒😒Congratulations you guessed " + thirdPhoneWord);
                        break;
                    }
                }
            } else {
                IO.println("You have to guess a word");
            }
        }
        if (String.valueOf(Word).contains("_")) {
            IO.println("🤣🤣🤣🤣 You lose Game over");
        }
    }
}

class Characters {
    Scanner chScanner = new Scanner(System.in);
    GameDictionary dictionary;

    public Characters(GameDictionary dictionary) {
        //receives the dictionary via a constructor
        this.dictionary = dictionary;
    }

    public void submenu() {
        Random random = new Random();
        int play = random.nextInt(3);

        switch (play) {
            case 0:
                firstCharacter();
                break;
            case 1:
                secondCharacter();
                break;
            case 2:
                thirdCharacter();
                break;
        }
    }

    void firstCharacter() {
        //ALUCARD to be guessed
        String firstCharacterWord = "ALUCARD";
        char[] Word = {'_', '_', '_', '_', '_', '_','_',};
        int trialcount = 9;
        for (int trial = 0; trial < trialcount; trial++) {
            IO.println(Arrays.toString(Word));
            IO.println("Trials left :" + (trialcount - trial));
            String guess = chScanner.next().toUpperCase();

            if (guess.length() > 1) {
                if (!dictionary.isValid(guess)) {
                    IO.println("'" + guess + " is not a valid word");
                } else {
                    char[] guessArray = guess.toCharArray();
                    for (char c : guessArray) {
                        for (int i = 0; i < firstCharacterWord.length(); i++) {
                            if (firstCharacterWord.toUpperCase().charAt(i) == c) {
                                Word[i] = c;
                            }
                        }
                    }
                    if (String.valueOf(Word).equals(firstCharacterWord.toUpperCase())) {
                        IO.println("😒😒Congratulations you guessed " + firstCharacterWord);
                        break;
                    }
                }
            } else {
                IO.println("You have to guess a word");
            }
        }
        if (String.valueOf(Word).contains("_")) {
            IO.println("🤣🤣🤣🤣 You lose Game over");
        }
    }

    void secondCharacter() {
        //BAYONETTA to be guessed
        String secondCharacterWord = "BAYONETTA";
        char[] Word = {'_', '_', '_', '_', '_', '_','_','_','_',};
        int trialcount = 11;
        for (int trial = 0; trial < trialcount; trial++) {
            IO.println(Arrays.toString(Word));
            IO.println("Trials left :" + (trialcount - trial));
            String guess = chScanner.next().toUpperCase();

            if (guess.length() > 1) {
                if (!dictionary.isValid(guess)) {
                    IO.println("'" + guess + " is not a valid word");
                } else {
                    char[] guessArray = guess.toCharArray();
                    for (char c : guessArray) {
                        for (int i = 0; i < secondCharacterWord.length(); i++) {
                            if (secondCharacterWord.toUpperCase().charAt(i) == c) {
                                Word[i] = c;
                            }
                        }
                    }
                    if (String.valueOf(Word).equals(secondCharacterWord.toUpperCase())) {
                        IO.println("😒😒Congratulations you guessed " + secondCharacterWord);
                        break;
                    }
                }
            } else {
                IO.println("You have to guess a word");
            }
        }
        if (String.valueOf(Word).contains("_")) {
            IO.println("🤣🤣🤣🤣 You lose Game over");
        }
    }

    void thirdCharacter() {
        //ALEXSTRASZA to be guessed
        String thirdCharacterWord = "ALEXSTRASZA";
        char[] Word = {'_', '_', '_', '_', '_', '_', '_', '_', '_','_','_',};
        int trialcount = 11;
        for (int trial = 0; trial < trialcount; trial++) {
            IO.println(Arrays.toString(Word));
            IO.println("Trials left :" + (trialcount - trial));
            String guess = chScanner.next().toUpperCase();

            if (guess.length() > 1) {
                if (!dictionary.isValid(guess)) {
                    IO.println("'" + guess + " is not a valid word");
                } else {
                    char[] guessArray = guess.toCharArray();
                    for (char c : guessArray) {
                        for (int i = 0; i < thirdCharacterWord.length(); i++) {
                            if (thirdCharacterWord.toUpperCase().charAt(i) == c) {
                                Word[i] = c;
                            }
                        }
                    }
                    if (String.valueOf(Word).equals(thirdCharacterWord.toUpperCase())) {
                        IO.println("😒😒Congratulations you guessed " + thirdCharacterWord);
                        break;
                    }
                }
            } else {
                IO.println("You have to guess a word");
            }
        }
        if (String.valueOf(Word).contains("_")) {
            IO.println("🤣🤣🤣🤣 You lose Game over");
        }
    }
}