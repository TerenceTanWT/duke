import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    private Date by;

    /**
     *
     * @param description Description of the deadline task
     * @param by Date to complete the task (dd/MM/yyyy HHmm)
     */
    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    /**
     * Checks if string contains empty description or date. Returns nothing if no error.
     *
     * @param myString String to be checked.
     * @throws DukeException If string contains empty description or invalid date format.
     */
    public static void checkInputError(String myString) throws DukeException {
        String[] userInputArray = Parser.userInputStringToArray(myString);

        if(userInputArray.length <= 1) {
            throw new DukeException("The description of deadline cannot be empty.");

        } else if(!myString.contains("/by")) {
            throw new DukeException("Duke.Deadline invalid date");
        }
    }

    /**
     * Returns deadline name from string.
     *
     * @param myString String to be checked.
     * @return The deadline name.
     */
    public static String getTaskName(String myString) {
        String taskName = myString;
        taskName = Parser.removeFirstWordFromString(taskName);
        taskName = taskName.split("/by")[0];     // gets user entered task (before /by)
        taskName = taskName.strip();
        return taskName;
    }

    /**
     * Returns deadline date from string.
     *
     * @param myString String to be checked.
     * @return The deadline date.
     * @throws DukeException If date format is incorrect.
     */
    public static Date getTaskDate(String myString) throws DukeException {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
            String deadlineDateString = myString.split("/by")[1];     // gets user entered date (after /by)
            Date deadlineDate = dateFormat.parse(deadlineDateString);
            return deadlineDate;

        } catch(ParseException errorMessage) {
            throw new DukeException("Duke.Deadline invalid date");
        }
    }

    /**
     * Returns the variable values of the deadline object.
     *
     * @return The variable values of the deadline object.
     */
    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
        return "[D]" + super.toString() + " (by: " + dateFormat.format(by) + ")";
    }
}
