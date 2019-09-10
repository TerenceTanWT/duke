import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {

    private Date fromDate;
    private Date toDate;

    /**
     *
     * @param description Description of the event task
     * @param fromDate Event start date and time (dd/MM/yyyy HHmm)
     * @param toDate Event end date and time (dd/MM/yyyy HHmm)
     */
    public Event(String description, Date fromDate, Date toDate) {
        super(description);
        this.fromDate = fromDate;
        this.toDate = toDate;
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
            throw new DukeException("The description of event cannot be empty.");

        } else if(!myString.contains("-") || !myString.contains("/at")) {
            throw new DukeException("Duke.Event invalid date");

        }
    }

    /**
     * Returns event name from string.
     *
     * @param myString String to be checked.
     * @return The event name.
     */
    public static String getTaskName(String myString) {
        String taskName = myString;
        taskName = Parser.removeFirstWordFromString(taskName);
        taskName = taskName.split("/at")[0];     // gets user entered task (before /by)
        taskName = taskName.strip();
        return taskName;
    }

    /**
     * Returns event start date from string.
     *
     * @param myString String to be checked.
     * @return The event start date.
     * @throws DukeException If date format is incorrect.
     */
    public static Date getEventDateFrom(String myString) throws DukeException {
        try {
            String taskName = myString.split("/at")[1];
            String eventDateString = taskName.split("-")[0];   // gets user input date in string form
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
            Date eventDate = dateFormat.parse(eventDateString);
            return eventDate;

        } catch(ParseException errorMessage) {
            throw new DukeException("Duke.Event invalid date");
        }
    }

    /**
     * Returns event end date from string.
     *
     * @param myString String to be checked.
     * @throws DukeException If date format is incorrect.
     * @return The event end date.
     */
    public static Date getEventDateTo(String myString) throws DukeException {
        try {
            String taskName = myString.split("/at")[1];
            String eventDateString = taskName.split("-")[1];   // gets user input date in string form
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
            Date eventDate = dateFormat.parse(eventDateString);
            return eventDate;

        } catch(ParseException errorMessage) {
            throw new DukeException("Duke.Event invalid date");
        }
    }

    /**
     * Returns the variable values of the event object.
     *
     * @return The variable values of the event object.
     */
    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
        return "[E]" + super.toString() + " (at: " + dateFormat.format(fromDate) + " - " + dateFormat.format(toDate) + ")";
    }
}