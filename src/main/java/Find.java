public class Find {

    /**
     * Checks if string contains empty task description. Returns nothing if no error.
     *
     * @param myString String to be checked.
     * @throws DukeException If string contains empty task description.
     */
    public static void checkInputError(String myString) throws DukeException {
        String[] userInputArray = Parser.userInputStringToArray(myString);
        if(userInputArray.length <= 1) {
            throw new DukeException("Duke.Find must be followed by a string from the list.");
        }
    }

    /**
     * Returns searching keyword from string.
     *
     * @param userInput String to be checked.
     * @return The keyword to be searched.
     * @throws DukeException If keyword is empty.
     */
    public static String getKeyword(String userInput) throws DukeException {
        String keyword = Parser.removeFirstWordFromString(userInput);
        return keyword;
    }

}