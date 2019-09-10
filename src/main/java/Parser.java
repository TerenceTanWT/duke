public class Parser {

    /**
     * Returns first word of string.
     *
     * @param userInput String to be checked.
     * @return First word of string.
     */
    public static String getFirstWordFromString(String userInput) {
        String[] userInputArray = userInputStringToArray(userInput);
        return userInputArray[0];
    }

    /**
     * Returns string without the first word.
     *
     * @param userInput String to be checked.
     * @return String without the first word.
     */
    public static String removeFirstWordFromString(String userInput) {
        String finalString = userInput;
        String[] stringArray = userInput.split(" ");
        if (stringArray.length > 1) {       // ensure that string has more than 1 word, if not will get out of bound error
            finalString = userInput.split(" ", 2)[1];
        }
        return finalString;
    }

    /**
     * Returns array of words from a string.
     *
     * @param userInput String to be checked.
     * @return Array with values of word from string.
     */
    public static String[] userInputStringToArray(String userInput) {
        String[] userInputArray = userInput.split(" ");
        return userInputArray;
    }

}
