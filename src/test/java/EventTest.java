package duke;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EventTest {
    private String userInput = "event project meeting /at 12/11/2019 1200 - 12/11/2019 1700";
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");


    @Test
    public void getTaskNameTest() {
        String taskName = Event.getTaskName(userInput);
        assertEquals("project meeting", taskName);
    }

    @Test
    public void getEventDateFrom() throws DukeException, ParseException {
        Date eventDateFrom = Event.getEventDateFrom(userInput);
        Date expectedEventDate = dateFormat.parse("12/11/2019 1200");
        assertEquals(expectedEventDate, eventDateFrom);
    }

    @Test
    public void getEventDateTo() throws DukeException, ParseException {
        Date eventDateTo = Event.getEventDateTo(userInput);
        Date expectedEventDate = dateFormat.parse("12/11/2019 1700");
        assertEquals(expectedEventDate, eventDateTo);
    }

    @Test
    public void addEventTest() throws ParseException {
        String taskName = "project meeting";
        Date eventDateFrom = dateFormat.parse("12/11/2019 1200");
        Date eventDateTo = dateFormat.parse("12/11/2019 1700");
        Event userEvent = new Event(taskName, eventDateFrom, eventDateTo);
        assertEquals("[E][✘] project meeting (at: 12/11/2019 1200 - 12/11/2019 1700)", userEvent.toString());
    }

    @Test
    public void emptyDescTest() {
        DukeException e = assertThrows(DukeException.class, () -> Event.checkInputError("event"));
        assertEquals("The description of event cannot be empty.", e.getMessage());
    }

    @Test
    public void emptyDateTest() {
        DukeException e = assertThrows(DukeException.class, () -> Event.checkInputError("event project meeting"));
        assertEquals("Duke.Event invalid date", e.getMessage());
    }

    @Test
    public void invalidDateFormatTest() {
        DukeException e = assertThrows(DukeException.class, () -> Event.getEventDateFrom("event project meeting /at 12-11-2019 1200 - 12/11/2019 1700"));
        assertEquals("Duke.Event invalid date", e.getMessage());
        e = assertThrows(DukeException.class, () -> Event.getEventDateTo("event project meeting /at 12/11/2019 1200 - 12 Nov 2019 1700"));
        assertEquals("Duke.Event invalid date", e.getMessage());
    }
}
