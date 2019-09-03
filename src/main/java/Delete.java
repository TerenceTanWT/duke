public class Delete {

    public static void checkInputError(String myString) throws DukeException {
        String[] userInputArray = Parser.userInputStringToArray(myString);
        if(userInputArray.length <= 1) {
            throw new DukeException("Delete must be followed by a number from the list.");
        }
    }

    public static int getDeleteNumber(String myString) throws DukeException {
        String userInput = myString;
        userInput = Parser.removeFirstWordFromString(userInput);
        int userInputNumber = Integer.parseInt(userInput.split(" ")[0]);
        return userInputNumber;
    }

}
