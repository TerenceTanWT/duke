import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TodoTest {
    @Test
    public void getTaskNameTest() {
        String taskName = Todo.getTaskName("todo go to the book store");
        assertEquals("go to the book store", taskName);
    }

    @Test
    public void addTodoTest() {
        Todo userTodo = new Todo("go to the book store");
        assertEquals("[T][\u2718] go to the book store", userTodo.toString());
    }

    @Test
    public void emptyDescTest() {
        DukeException e = assertThrows(DukeException.class, () -> Todo.checkInputError("todo"));
        assertEquals("The description of todo cannot be empty.", e.getMessage());
    }
}
