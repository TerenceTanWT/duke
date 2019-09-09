package duke;

public class Parser {

    public static String getFirstWordFromString(String userInput) {
        String[] userInputArray = userInputStringToArray(userInput);
        return userInputArray[0];
    }

    public static String removeFirstWordFromString(String userInput) {
        String finalString = userInput;
        String[] stringArray = userInput.split(" ");
        if (stringArray.length > 1) {       // ensure that string has more than 1 word, if not will get out of bound error
            finalString = userInput.split(" ", 2)[1];
        }
        return finalString;
    }

    public static String[] userInputStringToArray(String userInput) {
        String[] userInputArray = userInput.split(" ");
        return userInputArray;
    }

}
