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

    private static String removeFirstWordFromString(String userInput) {
        String finalString = userInput;
        String[] stringArray = userInput.split(" ");
        if (stringArray.length > 1) {       // ensure that string has more than 1 word, if not will get out of bound error
            finalString = userInput.split(" ", 2)[1];
        }
        return finalString;
    }

    private static String[] userInputStringToArray(String userInput) {
        String[] userInputArray = userInput.split(" ");
        return userInputArray;
    }

    private static ArrayList<Task> addTaskToList(ArrayList<Task> arrayList, Task task) {
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList = arrayList;
        Task userTask = task;
        taskList.add(userTask);
        System.out.println("Got it. I've added this task: ");
        System.out.println(userTask.toString());
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
        return taskList;
    }

    private static ArrayList<Task> setTaskDone(ArrayList<Task> arrayList, int number) throws DukeException {
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList = arrayList;
        try {
            if(number > taskList.size() || number < 1) {
                throw new DukeException("The selected task does not exist.");
            }
            taskList.get(number-1).setIsDone(true);          // set the task as done
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskList.get(number-1).toString());
            return taskList;
        }
        catch(DukeException errorMessage) {
            System.err.println(errorMessage.toString());
        }
        return taskList;
    }

    private static void printTaskList(ArrayList<Task> arrayList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < arrayList.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + arrayList.get(i).toString());
        }
    }

    public static void main(String[] args) throws DukeException {
        printWelcomeMessage();

        ArrayList<Task> taskList = new ArrayList<Task>();
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String[] userInputArray = userInputStringToArray(userInput);
        String userInputFirstWord = userInputArray[0];   // get first word from userInput

        while (true) {
            String taskName = removeFirstWordFromString(userInput);   // remove first word from userInput

            try {
                if (userInputFirstWord.equals("todo")) {
                    if(userInputArray.length == 1) {
                        throw new DukeException("The description of a todo cannot be empty.");
                    }
                    Todo userTodo = new Todo(taskName);
                    taskList = addTaskToList(taskList, userTodo);

                } else if (userInputFirstWord.equals("deadline")) {
                    if(userInputArray.length == 1) {
                        throw new DukeException("The description of a todo cannot be empty.");
                    }
                    String userDeadlineTask = taskName.split("/by")[0];     // userInputTask stores user entered task (before /by)
                    String userDeadlineDate = taskName.split("/by")[1];     // userInputDate stores user entered date (after /by)
                    Deadline userDeadline = new Deadline(userDeadlineTask, userDeadlineDate);
                    taskList = addTaskToList(taskList, userDeadline);

                } else if (userInputFirstWord.equals("event")) {
                    if(userInputArray.length == 1) {
                        throw new DukeException("The description of a event cannot be empty.");
                    }
                    String userEventTask = taskName.split("/at")[0];     // userEventTask stores user entered task (before /at)
                    String userEventDate = taskName.split("/at")[1];     // userEventDate stores user entered date (after /at)
                    Event userEvent = new Event(userEventTask, userEventDate);
                    taskList = addTaskToList(taskList, userEvent);

                } else if (userInputFirstWord.equals("done")) {
                    if(userInputArray.length == 1) {
                        throw new DukeException("done must be followed by a number.");
                    }
                    int userInputNumber = Integer.parseInt(taskName.split(" ")[0]);    // get the number that user entered
                    taskList = setTaskDone(taskList, userInputNumber);

                } else if (userInputFirstWord.equals("list")) {
                    printTaskList(taskList);

                } else if (userInputFirstWord.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);
                } else {
                    throw new DukeException("I'm sorry, but I don't know what that means :-(");
                }
            } catch(DukeException errorMessage) {
                System.err.println(errorMessage.toString());
            }

            System.out.println("\n");
            userInput = input.nextLine();
            userInputArray = userInputStringToArray(userInput);
            userInputFirstWord = userInputArray[0];    // get the first word of user input
        }
    }
}
