public class Delete {

    /**
     * Checks if string contains empty task number. Returns nothing if no error.
     *
     * @param myString String to be checked.
     * @throws DukeException If string contains empty task number.
     */
    public static void checkInputError(String myString) throws DukeException {
        String[] userInputArray = Parser.userInputStringToArray(myString);
        if(userInputArray.length <= 1) {
            throw new DukeException("Duke.Delete must be followed by a number from the list.");
        }
    }

    /**
     * Returns task number to be deleted from string.
     *
     * @param myString String to be checked.
     * @return The task number to be deleted.
     * @throws DukeException If task number is not an integer.
     */
    public static int getDeleteNumber(String myString) throws DukeException {
        String userInput = myString;
        userInput = Parser.removeFirstWordFromString(userInput);
        int userInputNumber = Integer.parseInt(userInput.split(" ")[0]);
        return userInputNumber;
    }

}
