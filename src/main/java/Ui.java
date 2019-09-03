public class Ui {

    public void printWelcomeMessage() {
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

    public void printDeadlineFormat() {
        System.out.println("Incorrect format. Please try:");
        System.out.println("deadline <task> /by <dd/MM/yyyy HHmm>");
        System.out.println("E.g. deadline Celebrate birthday /by 12/11/2019 1800");
    }

    public void printEventFormat() {
        System.out.println("Incorrect format. Please try:");
        System.out.println("event <task> /at <dd/MM/yyyy HHmm> - <dd/MM/yyyy HHmm");
        System.out.println("E.g. event Celebrate birthday /at 12/11/2019 1800 - 12/11/2019 2200");
    }
}
