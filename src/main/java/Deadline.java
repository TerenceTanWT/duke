import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    private Date by;

    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    public static void checkInputError(String myString) throws DukeException {
        String[] userInputArray = Parser.userInputStringToArray(myString);

        if(userInputArray.length <= 1) {
            throw new DukeException("The description of deadline cannot be empty.");

        } else if(!myString.contains("/by")) {
            throw new DukeException("Deadline invalid date");
        }
    }

    public static String getTaskName(String myString) {
        String taskName = myString;
        taskName = Parser.removeFirstWordFromString(taskName);
        taskName = taskName.split("/by")[0];     // gets user entered task (before /by)
        return taskName;
    }

    public static Date getTaskDate(String myString) throws DukeException {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
            String deadlineDateString = myString.split("/by")[1];     // gets user entered date (after /by)
            Date deadlineDate = dateFormat.parse(deadlineDateString);
            return deadlineDate;

        } catch(ParseException errorMessage) {
            throw new DukeException("Deadline invalid date");
        }
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
        return "[D]" + super.toString() + " (by: " + dateFormat.format(by) + ")";
    }
}
