public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public static void checkInputError(String myString) throws DukeException {
        String[] userInputArray = Duke.userInputStringToArray(myString);

        if(userInputArray.length <= 1) {
            throw new DukeException("The description of todo cannot be empty.");
        }
    }

    public static String getTaskName(String myString) {
        String taskName = myString;
        taskName = Duke.removeFirstWordFromString(taskName);
        return taskName;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}