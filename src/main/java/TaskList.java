import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {

    private ArrayList<Task> taskList = new ArrayList<Task>();

    public TaskList() {

    }

    /**
     * Creates an empty task list, or populate the task list with objects from an array list.
     *
     * @param taskList Array list with task objects (optional)
     */
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Returns size of the task list.
     *
     * @return The size of task list.
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Adds a task object into the task list.
     *
     * @param task Task object (todo, deadline, or event).
     */
    public void addTaskToList(Task task) {
        taskList.add(task);
        System.out.println("Got it. I've added this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    /**
     * Mark a task in the task list as done.
     *
     * @param number The task number of the task to be marked as done.
     * @throws DukeException If task number does not exist in the task list.
     */
    public void setTaskDone(int number) throws DukeException {
        try {
            if(number > taskList.size() || number < 1) {
                throw new DukeException("The selected task does not exist.");
            }
            taskList.get(number-1).setIsDone(true);          // set the task as done
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskList.get(number-1).toString());
        }
        catch(DukeException errorMessage) {
            System.err.println(errorMessage.toString());
        }
    }

    /**
     * Delete a task from the task list.
     *
     * @param number The task number of the task to be deleted from the task list.
     * @throws DukeException If task number does not exist in the task list.
     */
    public void deleteTask(int number) throws DukeException {
        try {
            if (number > taskList.size() || number < 1) {
                throw new DukeException("The selected task does not exist.");
            }
            System.out.println("Noted. I've removed this task:");
            System.out.println(taskList.get(number - 1).toString());
            taskList.remove(number - 1);          // delete task from task list

        } catch (DukeException errorMessage) {
            System.err.println(errorMessage.toString());
        }
    }

    /**
     * Prints task from the task list that matches the keyword.
     *
     * @param keyword A string to look for in the task list.
     */
    public void findTask(String keyword) {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getDescription().contains(keyword)) {
                System.out.println(i+1 + "." + taskList.get(i).toString());
            }
        }
    }

    /**
     * Prints all the task from the task list.
     */
    public void printTaskList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + taskList.get(i).toString());
        }
    }

    /**
     * Returns true if the task has already been marked as done.
     *
     * @param number The task number of the task to be checked.
     * @return True if the task has already been marked as done.
     * @throws DukeException If task number does not exist in the task list.
     */
    public boolean isDone(int number) throws DukeException {
        try {
            if (number > taskList.size() || number < 1) {
                throw new DukeException("The selected task does not exist.");
            }
            return taskList.get(number-1).getIsDone();

        } catch (DukeException errorMessage) {
            System.err.println(errorMessage.toString());
        }
        return false;
    }

    public ArrayList<Task> toArrayList() {
        return taskList;
    }
}
