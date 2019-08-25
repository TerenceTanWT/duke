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

        while (true) {
            if (userInput.equals("list")) {
                for (int i = 0; i < userInputArray.size(); i++) {
                    int index = i + 1;
                    System.out.println(index + ". [" + userInputArray.get(i).getStatusIcon() + "] " + userInputArray.get(i).getDescription());
                }
            } else if (userInput.equals("bye")) {
                  System.out.println("Bye. Hope to see you again soon!");
                  System.exit(0);
            } else if (userInput.split(" ")[0].equals("done")) {    // check if first word in userInput is "done"
                  int userInputNumber = Integer.parseInt(userInput.split(" ")[1]);    // get the number that user entered
                  userInputArray.get(userInputNumber-1).setIsDone(true);          // set the task as done
                  System.out.println("Nice! I've marked this task as done:");
                  System.out.println("[" + userInputArray.get(userInputNumber-1).getStatusIcon() + "] " + userInputArray.get(userInputNumber-1).getDescription());
            } else {
                  Task userTask = new Task(userInput);
                  userInputArray.add(userTask);
                  System.out.println("added: " + userInput);
            }

            System.out.println("\n");
            userInput = input.nextLine();
        }

    }
}
