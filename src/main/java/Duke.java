import java.util.Scanner;  // Import the Scanner class

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

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while(!userInput.equals("bye")) {
            System.out.println(userInput + "\n");
            userInput = input.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");

    }
}
