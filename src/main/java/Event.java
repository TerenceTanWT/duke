import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {

    private Date fromDate;
    private Date toDate;

    public Event(String description, Date fromDate, Date toDate) {
        super(description);
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public static void checkInputError(String myString) throws DukeException {
        String[] userInputArray = Duke.userInputStringToArray(myString);

        if(userInputArray.length <= 1) {
            throw new DukeException("The description of event cannot be empty.");

        } else if(!myString.contains("-") || !myString.contains("/at")) {
            throw new DukeException("Event invalid date");

        }
    }

    public static String getTaskName(String myString) {
        String taskName = myString;
        taskName = Duke.removeFirstWordFromString(taskName);
        taskName = taskName.split("/at")[0];     // gets user entered task (before /by)
        return taskName;
    }

    public static Date getEventDateFrom(String myString) throws DukeException {
        try {
            String taskName = myString.split("/at")[1];
            String eventDateString = taskName.split("-")[0];   // gets user input date in string form
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
            Date eventDate = dateFormat.parse(eventDateString);
            return eventDate;

        } catch(ParseException errorMessage) {
            throw new DukeException("Event invalid date");
        }
    }

    public static Date getEventDateTo(String myString) throws DukeException {
        try {
            String taskName = myString.split("/at")[1];
            String eventDateString = taskName.split("-")[1];   // gets user input date in string form
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
            Date eventDate = dateFormat.parse(eventDateString);
            return eventDate;

        } catch(ParseException errorMessage) {
            throw new DukeException("Event invalid date");
        }
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
        return "[E]" + super.toString() + " (at: " + dateFormat.format(fromDate) + " - " + dateFormat.format(toDate) + ")";
    }
}