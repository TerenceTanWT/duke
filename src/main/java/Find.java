public class Find {

    public static void checkInputError(String myString) throws DukeException {
        String[] userInputArray = Parser.userInputStringToArray(myString);
        if(userInputArray.length <= 1) {
            throw new DukeException("Find must be followed by a string from the list.");
        }
    }

    public static String getKeyword(String userInput) throws DukeException {
        String keyword = Parser.removeFirstWordFromString(userInput);
        return keyword;
    }

}