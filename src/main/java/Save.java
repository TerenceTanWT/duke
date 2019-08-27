import java.util.ArrayList; // import the ArrayList class
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Save {

    private String path;
    private String directory;
    private String filename;
    private String projectDirectory;

    public Save(String path) {
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

    public void saveTaskList(ArrayList<Task> arrayList) throws IOException {
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList = arrayList;
        int tryAgain = 0;
        while(tryAgain < 2) {
            try {
                FileOutputStream file = new FileOutputStream(new File(path));
                ObjectOutputStream object = new ObjectOutputStream(file);
                object.writeObject(taskList);
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

    public ArrayList<Task> readTaskList() throws IOException, DukeException {
        ArrayList<Task> taskList = new ArrayList<Task>();
        try {
            FileInputStream file = new FileInputStream(new File(path));
            ObjectInputStream object = new ObjectInputStream(file);
            taskList = (ArrayList<Task>)object.readObject();
            object.close();
            file.close();
            return taskList;

        } catch(FileNotFoundException errorMessage) {
            File file = new File(path);
            file.getParentFile().mkdirs();          // create directory. This function will not create if already exist.
            if(!file.createNewFile()) {
                System.out.println("Unable to create file " + path + "...");
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

    public ArrayList<Task> restoreTaskList(ArrayList<Task> arrayList) throws IOException, DukeException {
        try {
            ArrayList<Task> taskList = readTaskList();
            return taskList;

        } catch (IOException errorMessage){
            System.out.println(errorMessage);
            throw new DukeException("Error restoring from save file. Please delete /data/duke.txt and relaunch.");
        }
    }
}
