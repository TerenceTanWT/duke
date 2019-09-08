package duke;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {

    private ArrayList<Task> taskList = new ArrayList<Task>();

    public TaskList() {

    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public int size() {
        return taskList.size();
    }

    public void addTaskToList(Task task) {
        taskList.add(task);
        System.out.println("Got it. I've added this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

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

    public void findTask(String keyword) throws DukeException {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getDescription().contains(keyword)) {
                System.out.println(i+1 + "." + taskList.get(i).toString());
            }
        }
    }

    public void printTaskList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + taskList.get(i).toString());
        }
    }

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
