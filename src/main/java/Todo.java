public class Todo extends Task {

    /**
     *
     * @param description Description of the todo task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Checks if string contains empty description. Returns nothing if no error.
     *
     * @param myString String to be checked.
     * @throws DukeException If string contains empty description.
     */
    public static void checkInputError(String myString) throws DukeException {
        String[] userInputArray = Parser.userInputStringToArray(myString);

        if(userInputArray.length <= 1) {
            throw new DukeException("The description of todo cannot be empty.");
        }
    }

    /**
     * Returns task name from string.
     *
     * @param myString String to be checked.
     * @return The task name.
     */
    public static String getTaskName(String myString) {
        String taskName = myString;
        taskName = Parser.removeFirstWordFromString(taskName);
        return taskName;
    }

    /**
     * Returns the variable values of the todo object.
     *
     * @return The variable values of the todo object.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}