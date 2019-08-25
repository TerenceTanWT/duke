import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        //System.out.println("Hello from\n" + logo);

        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");

        ArrayList<Task> userInputArray = new ArrayList<Task>();
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String userInputFirstWord = userInput.split(" ")[0];    // get the first word of user input

        while (true) {
            if(userInputFirstWord.equals("todo")) {
                String [] splitUserInput = userInput.split(" ", 2);     // create an array which splits the first word from the remaining of the sentence
                Todo userTodo = new Todo(splitUserInput[1]);
                userInputArray.add(userTodo);
                System.out.println("Got it. I've added this task: ");
                System.out.println(userTodo.toString());
                System.out.println("Now you have " + userInputArray.size() + " tasks in the list.");

            } else if (userInputFirstWord.equals("deadline")) {
                String [] splitUserInput = userInput.split(" ", 2);     // create an array which splits the first word from the remaining of the sentence
                String userDeadlineTask = splitUserInput[1].split("/by")[0];   // userInputTask stores user entered task (before /by)
                String userDeadlineDate = splitUserInput[1].split("/by")[1];   // userInputDate stores user entered date (after /by)
                Deadline userDeadline = new Deadline(userDeadlineTask, userDeadlineDate);
                userInputArray.add(userDeadline);
                System.out.println("Got it. I've added this task: ");
                System.out.println(userDeadline.toString());
                System.out.println("Now you have " + userInputArray.size() + " tasks in the list.");

            } else if (userInputFirstWord.equals("event")) {
                String [] splitUserInput = userInput.split(" ", 2);     // create an array which splits the first word from the remaining of the sentence
                String userEventTask = splitUserInput[1].split("/at")[0];   // userInputTask stores user entered task (before /by)
                String userEventDate = splitUserInput[1].split("/at")[1];   // userInputDate stores user entered date (after /by)
                Event userEvent = new Event(userEventTask, userEventDate);
                userInputArray.add(userEvent);
                System.out.println("Got it. I've added this task: ");
                System.out.println(userEvent.toString());
                System.out.println("Now you have " + userInputArray.size() + " tasks in the list.");

            } else if (userInputFirstWord.equals("done")) {
                int userInputNumber = Integer.parseInt(userInput.split(" ")[1]);    // get the number that user entered
                userInputArray.get(userInputNumber-1).setIsDone(true);          // set the task as done
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(userInputArray.get(userInputNumber-1).toString());

            } else if (userInput.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < userInputArray.size(); i++) {
                    int index = i + 1;
                    System.out.println(index + "." + userInputArray.get(i).toString());
                }

            } else if (userInput.equals("bye")) {
                  System.out.println("Bye. Hope to see you again soon!");
                  System.exit(0);
            }

            System.out.println("\n");
            userInput = input.nextLine();
            userInputFirstWord = userInput.split(" ")[0];    // get the first word of user input
        }

    }
}
