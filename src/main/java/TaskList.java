import java.util.ArrayList;

public class TaskList {

    public static ArrayList<Task> addTaskToList(ArrayList<Task> arrayList, Task task) {
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList = arrayList;
        Task userTask = task;
        taskList.add(userTask);
        System.out.println("Got it. I've added this task: ");
        System.out.println(userTask.toString());
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
        return taskList;
    }

    public static ArrayList<Task> setTaskDone(ArrayList<Task> arrayList, int number) throws DukeException {
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

    public static ArrayList<Task> deleteTask(ArrayList<Task> arrayList, int number) throws DukeException {
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList = arrayList;
        try {
            if (number > taskList.size() || number < 1) {
                throw new DukeException("The selected task does not exist.");
            }
            System.out.println("Noted. I've removed this task:");
            System.out.println(taskList.get(number - 1).toString());
            taskList.remove(number - 1);          // delete task from task list
            return taskList;
        } catch (DukeException errorMessage) {
            System.err.println(errorMessage.toString());
        }
        return taskList;
    }

    public static void findTask(ArrayList<Task> arrayList, String myString) throws DukeException {
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList = arrayList;
        String keyword = myString;
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getDescription().contains(keyword)) {
                System.out.println(i+1 + "." + taskList.get(i).toString());
            }
        }
    }

    public static void printTaskList(ArrayList<Task> arrayList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < arrayList.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + arrayList.get(i).toString());
        }
    }
}
