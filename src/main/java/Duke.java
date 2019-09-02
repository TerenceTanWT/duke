import java.io.IOException;
import java.util.Date;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class

public class Duke {
    private static void printWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        //System.out.println("Hello from\n" + logo);

        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
    }

    public static String removeFirstWordFromString(String userInput) {
        String finalString = userInput;
        String[] stringArray = userInput.split(" ");
        if (stringArray.length > 1) {       // ensure that string has more than 1 word, if not will get out of bound error
            finalString = userInput.split(" ", 2)[1];
        }
        return finalString;
    }

    public static String[] userInputStringToArray(String userInput) {
        String[] userInputArray = userInput.split(" ");
        return userInputArray;
    }

    public static void main(String[] args) throws DukeException, IOException {
        printWelcomeMessage();

        ArrayList<Task> taskList = new ArrayList<Task>();
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String[] userInputArray = userInputStringToArray(userInput);
        String userInputFirstWord = userInputArray[0];   // get first word from userInput

        // restore taskList from previous session
        Save save = new Save("/data/duke.txt");
        taskList = Save.restoreTaskList(taskList);

        while (true) {
            try {
                if (userInputFirstWord.equals("todo")) {
                    String taskName = Todo.getTaskName(userInput);
                    Todo userTodo = new Todo(taskName);
                    taskList = TaskList.addTaskToList(taskList, userTodo);
                    save.saveTaskList(taskList);

                } else if (userInputFirstWord.equals("deadline")) {
                    Deadline.checkInputError(userInput);
                    String deadlineTask = Deadline.getTaskName(userInput);
                    Date deadlineDate = Deadline.getTaskDate(userInput);
                    Deadline userDeadline = new Deadline(deadlineTask, deadlineDate);
                    taskList = TaskList.addTaskToList(taskList, userDeadline);
                    save.saveTaskList(taskList);

                } else if (userInputFirstWord.equals("event")) {
                    Event.checkInputError(userInput);
                    String eventTask = Event.getTaskName(userInput);
                    Date eventDateFrom = Event.getEventDateFrom(userInput);
                    Date eventDateTo = Event.getEventDateTo(userInput);
                    Event userEvent = new Event(eventTask, eventDateFrom, eventDateTo);
                    taskList = TaskList.addTaskToList(taskList, userEvent);
                    save.saveTaskList(taskList);

                } else if (userInputFirstWord.equals("done")) {
                    Done.checkInputError(userInput);
                    int userInputNumber = Done.getDoneNumber(userInput);    // get the number that user entered
                    taskList = TaskList.setTaskDone(taskList, userInputNumber);
                    save.saveTaskList(taskList);

                } else if (userInputFirstWord.equals("find")) {
                    Find.checkInputError(userInput);
                    String keyword = Find.getKeyword(userInput);
                    TaskList.findTask(taskList, keyword);

                } else if (userInputFirstWord.equals("list")) {
                    TaskList.printTaskList(taskList);

                } else if (userInputFirstWord.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);

                } else {
                    throw new DukeException("I'm sorry, but I don't know what that means :-(");

                }
            } catch(DukeException errorMessage) {
                if(errorMessage.getMessage().equals("Deadline invalid date")) {
                    System.out.println("Incorrect format. Please try:");
                    System.out.println("deadline <task> /by <dd/MM/yyyy HHmm>");
                    System.out.println("E.g. deadline Celebrate birthday /by 12/11/2019 1800");

                } else if (errorMessage.getMessage().equals("Event invalid date")) {
                    System.out.println("Incorrect format. Please try:");
                    System.out.println("event <task> /at <dd/MM/yyyy HHmm> - <dd/MM/yyyy HHmm");
                    System.out.println("E.g. event Celebrate birthday /at 12/11/2019 1800 - 12/11/2019 2200");

                }
                else {
                    System.err.println(errorMessage.toString());

                }
            }

            System.out.println("\n");
            userInput = input.nextLine();
            userInputArray = userInputStringToArray(userInput);
            userInputFirstWord = userInputArray[0];    // get the first word of user input
        }
    }
}
