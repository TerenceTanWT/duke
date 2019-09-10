import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskListTest {
    private TaskList taskList = new TaskList();
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
    private Date deadlineDate = dateFormat.parse("12/11/2019 1200");
    private Date eventDateFrom = dateFormat.parse("12/11/2019 1300");
    private Date eventDateTo = dateFormat.parse("12/11/2019 1700");
    private Todo userTodo1 = new Todo("go to a book store");
    private Todo userTodo2 = new Todo("leave the book store and go to school");
    private Deadline userDeadline = new Deadline("return book", deadlineDate);
    private Event userEvent = new Event("project meeting", eventDateFrom, eventDateTo);

    public TaskListTest() throws ParseException {
        taskList.addTaskToList(userTodo1);
        taskList.addTaskToList(userTodo2);
        taskList.addTaskToList(userDeadline);
        taskList.addTaskToList(userEvent);
    }

    @Test
    public void TaskListAdd() throws ParseException {
        assertEquals(4, taskList.size());
    }

    @Test
    public void setTaskDone() throws DukeException {
        taskList.setTaskDone(1);
        assertTrue(taskList.isDone(1));
    }

    @Test
    public void printTaskListTest() {
        String expected = "Here are the tasks in your list:\n" +
                "1.[T][\u2718] go to a book store\n" +
                "2.[T][\u2718] leave the book store and go to school\n" +
                "3.[D][\u2718] return book (by: 12/11/2019 1200)\n" +
                "4.[E][\u2718] project meeting (at: 12/11/2019 1300 - 12/11/2019 1700)\n";
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        taskList.printTaskList();
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void findTaskTest() throws DukeException {
        String expected = "Here are the matching tasks in your list:\n" +
                "1.[T][\u2718] go to a book store\n" +
                "2.[T][\u2718] leave the book store and go to school\n";
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        taskList.findTask("book store");
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void deleteTaskTest() throws DukeException {
        taskList.deleteTask(1);
        taskList.deleteTask(2);
        assertEquals(2, taskList.size());
    }
}
