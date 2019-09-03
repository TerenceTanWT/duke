import java.io.*;
import java.util.ArrayList; // import the ArrayList class


public class Storage {

    private String path;
    private String directory;
    private String filename;
    private String projectDirectory;

    public Storage(String path) {
        this.path = System.getProperty("user.dir") + path;
        filename = path.substring(path.lastIndexOf("/") + 1);
        directory = path.substring(0, path.lastIndexOf("/"));
    }

    public String getFileName(){
        return filename;
    }

    public String getDirectoryName(){
        return directory;
    }

    public void saveTaskList(TaskList taskList) throws IOException {
        int tryAgain = 0;
        while(tryAgain < 2) {
            try {
                FileOutputStream file = new FileOutputStream(new File(path));
                ObjectOutputStream object = new ObjectOutputStream(file);
                object.writeObject(taskList.toArrayList());
                //object.writeObject(taskList);
                object.close();
                file.close();
                tryAgain = 2;

            } catch(FileNotFoundException errorMessage) {
                tryAgain++ ;
                File file = new File(path);
                file.getParentFile().mkdirs();          // create directory. This function will not create if already exist.
                if(!file.createNewFile()) {
                    System.out.println("Unable to create file " + path + "...");
                    System.out.println(errorMessage);
                }

            } catch (IOException errorMessage) {
                tryAgain = 2;
                System.out.println("Error saving to " + path);
                System.out.println(errorMessage);
            }
        }
    }

    public TaskList restoreTaskList(TaskList taskList) throws IOException, DukeException {
        ArrayList<Task> arrayList = new ArrayList<Task>();
        try {
            FileInputStream file = new FileInputStream(new File(path));
            ObjectInputStream object = new ObjectInputStream(file);
            arrayList = (ArrayList<Task>)object.readObject();
            TaskList newTaskList = new TaskList(arrayList);
            //TaskList newTaskList = (TaskList) object.readObject();
            object.close();
            file.close();
            return newTaskList;

        } catch(FileNotFoundException errorMessage) {
            File file = new File(path);
            file.getParentFile().mkdirs();          // create directory. This function will not create if already exist.
            if(!file.createNewFile()) {
                System.out.println("Unable to create file " + path + "...");
                System.out.println(errorMessage);
                throw new DukeException("Error creating save file.");
            }

        } catch (EOFException errorMessage) {
            File file = new File(path);
            file.delete();
            if(!file.createNewFile()) {
                System.out.println("Save file is corrupted and unable to create new file " + path + "...");
                System.out.println(errorMessage);
                throw new DukeException("Error creating save file.");
            }

        } catch (IOException errorMessage) {
            System.out.println("Error reading file from " + path);
            System.out.println(errorMessage);
            throw new DukeException("Error reading save file.");

        } catch (ClassNotFoundException errorMessage) {
            System.out.println(errorMessage);
        }

        return taskList;
    }
}
