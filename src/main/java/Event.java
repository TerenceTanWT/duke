import java.text.DateFormat;
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

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
        return "[E]" + super.toString() + " (at: " + dateFormat.format(fromDate) + " - " + dateFormat.format(toDate) + ")";
    }
}