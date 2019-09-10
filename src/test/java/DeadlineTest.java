import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeadlineTest {
    private String userInput = "deadline return book /by 12/11/2019 1200";
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

    @Test
    public void getTaskNameTest() {
        String taskName = Deadline.getTaskName(userInput);
        assertEquals("return book", taskName);
    }

    @Test
    public void getTaskDateTest() throws DukeException, ParseException {
        Date taskDate = Deadline.getTaskDate(userInput);
        Date expectedTaskDate = dateFormat.parse("12/11/2019 1200");
        assertEquals(expectedTaskDate, taskDate);
    }

    @Test
    public void addDeadlineTest() throws ParseException {
        String taskName = "return book";
        Date taskDate = dateFormat.parse("12/11/2019 1200");
        Deadline userDeadline = new Deadline(taskName, taskDate);
        assertEquals("[D][\u2718] return book (by: 12/11/2019 1200)", userDeadline.toString());
    }

    @Test
    public void emptyDescTest() {
        DukeException e = assertThrows(DukeException.class, () -> Deadline.checkInputError("deadline"));
        assertEquals("The description of deadline cannot be empty.", e.getMessage());
    }

    @Test
    public void emptyDateTest() {
        DukeException e = assertThrows(DukeException.class, () -> Deadline.checkInputError("deadline return book"));
        assertEquals("Duke.Deadline invalid date", e.getMessage());
    }

    @Test
    public void invalidDateFormatTest() {
        DukeException e = assertThrows(DukeException.class, () -> Deadline.getTaskDate("deadline return book /by 12/11/2019"));
        assertEquals("Duke.Deadline invalid date", e.getMessage());
    }
}
