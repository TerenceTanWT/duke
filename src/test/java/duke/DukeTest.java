package duke;

import java.text.ParseException;
import org.junit.jupiter.api.Test;

public class DukeTest {
    private TaskList taskList = new TaskList();

    @Test
    public void testParser() {
        ParserTest test = new ParserTest();
        test.testGetFirstWordFromString();
        test.testRemoveFirstWordFromString();
        test.testUserInputStringToArray();
    }

    @Test
    public void testTodo() {
        TodoTest test = new TodoTest();
        test.getTaskNameTest();
        test.addTodoTest();
        test.emptyDescTest();
    }

    @Test
    public void testDeadline() throws DukeException, ParseException {
        DeadlineTest test = new DeadlineTest();
        test.getTaskNameTest();
        test.getTaskDateTest();
        test.addDeadlineTest();
        test.emptyDescTest();
        test.emptyDateTest();
        test.invalidDateFormatTest();
    }

    @Test
    public void testEvent() throws ParseException, DukeException {
        EventTest test = new EventTest();
        test.getTaskNameTest();
        test.getEventDateFrom();
        test.getEventDateTo();
        test.addEventTest();
        test.emptyDescTest();
        test.emptyDateTest();
        test.invalidDateFormatTest();
    }

    @Test
    public void testTaskList() throws ParseException, DukeException {
        TaskListTest test = new TaskListTest();
        test.TaskListAdd();
        test.printTaskListTest();
        test.findTaskTest();
        test.setTaskDone();
        test.deleteTaskTest();
    }
}

