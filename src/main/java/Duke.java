import java.io.IOException;
import java.util.Date;
import java.util.Scanner;  // Import the Scanner class

public class Duke {

    public static void main(String[] args) throws DukeException, IOException {
        Ui ui = new Ui();
        ui.printWelcomeMessage();

        TaskList taskList = new TaskList();
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String userInputFirstWord = Parser.getFirstWordFromString(userInput);   // get first word from userInput

        // restore taskList from previous session
        Storage storage = new Storage("/data/duke.txt");
        taskList = storage.restoreTaskList(taskList);

        while (true) {
            try {
                if (userInputFirstWord.equals("todo")) {
                    Todo.checkInputError(userInput);
                    String taskName = Todo.getTaskName(userInput);
                    Todo userTodo = new Todo(taskName);
                    taskList.addTaskToList(userTodo);
                    storage.saveTaskList(taskList);

                } else if (userInputFirstWord.equals("deadline")) {
                    Deadline.checkInputError(userInput);
                    String deadlineTask = Deadline.getTaskName(userInput);
                    Date deadlineDate = Deadline.getTaskDate(userInput);
                    Deadline userDeadline = new Deadline(deadlineTask, deadlineDate);
                    taskList.addTaskToList(userDeadline);
                    storage.saveTaskList(taskList);

                } else if (userInputFirstWord.equals("event")) {
                    Event.checkInputError(userInput);
                    String eventTask = Event.getTaskName(userInput);
                    Date eventDateFrom = Event.getEventDateFrom(userInput);
                    Date eventDateTo = Event.getEventDateTo(userInput);
                    Event userEvent = new Event(eventTask, eventDateFrom, eventDateTo);
                    taskList.addTaskToList(userEvent);
                    storage.saveTaskList(taskList);

                } else if (userInputFirstWord.equals("delete")) {
                    Delete.checkInputError(userInput);
                    int userInputNumber = Delete.getDeleteNumber(userInput);    // get the number that user entered
                    taskList.deleteTask(userInputNumber);
                    storage.saveTaskList(taskList);

                } else if (userInputFirstWord.equals("done")) {
                    Done.checkInputError(userInput);
                    int userInputNumber = Done.getDoneNumber(userInput);    // get the number that user entered
                    taskList.setTaskDone(userInputNumber);
                    storage.saveTaskList(taskList);

                } else if (userInputFirstWord.equals("find")) {
                    Find.checkInputError(userInput);
                    String keyword = Find.getKeyword(userInput);
                    taskList.findTask(keyword);

                } else if (userInputFirstWord.equals("list")) {
                    taskList.printTaskList();

                } else if (userInputFirstWord.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);

                } else {
                    throw new DukeException("I'm sorry, but I don't know what that means :-(");

                }
            } catch(DukeException errorMessage) {
                if(errorMessage.getMessage().equals("Duke.Deadline invalid date")) {
                    ui.printDeadlineFormat();

                } else if (errorMessage.getMessage().equals("Duke.Event invalid date")) {
                    ui.printEventFormat();

                }
                else {
                    System.err.println(errorMessage.toString());

                }
            }

            System.out.println("\n");
            userInput = input.nextLine();
            userInputFirstWord = Parser.getFirstWordFromString(userInput);
        }
    }
}
