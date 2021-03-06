import java.io.*;
import java.util.ArrayList;
import java.util.List; // testcomment

public class TaskManager {
    private static int tasksTotal;
    private List<Task> tasksList;

    public TaskManager() {
        tasksList = new ArrayList<>();
    }

    public static int getTasksTotal() {
        return tasksTotal;
    }

    // This method reads the objects from a file into a list and gets the number of objects
    public void readFile() {
        try
        {
            tasksList.clear();

            FileInputStream file = new FileInputStream("./tasksList.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            boolean cont = true;
            while(cont){
                Task readTask = null;
                try {
                    readTask = (Task)in.readObject();
                } catch (Exception e) {
                }
                if(readTask != null)
                    tasksList.add(readTask);
                else
                    cont = false;
            }

            if(tasksList.isEmpty()) System.out.println("There are no todos.");
            in.close();
            file.close();
        }

        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void addNewTask(String[] args) {
        if(args.length < 2) System.out.println("Unable to add: not task provided");
        else{
            // Get all the arguments from the command line into one concatenated string
            String taskDescription = "";
            for (int i = 1; i < args.length; i++)
            {
                taskDescription += args[i] + " ";
            }
            taskDescription = taskDescription.substring(0, taskDescription.length() - 1);

            Task newTask = new Task(false, taskDescription);
            saveFile(newTask);
            tasksList.add(newTask);
        }
    }

    public void listAllTasks() {
        readFile();

        // Print out the saved tasks
        System.out.println();
        System.out.printf("The saved tasks:%n================%n");
        int i = 1;
        for (Task task : tasksList) {
            System.out.println(i + ". " + task.getText() + "; completed: " + task.getStatus());
            i++;
        }
    }

    public void removeTask(String[] args) {

        int intValue = checkInput(args);
        if(intValue == -1) return;

        try{
            tasksList.remove(intValue - 1);
            saveFile(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkTask(String[] args) {

        int intValue = checkInput(args);
        if(intValue == -1) return;
        intValue--;

        if(tasksList.get(intValue).getStatus() == true) tasksList.set(intValue, new Task(false, tasksList.get(intValue).getText()));
        else tasksList.set(intValue, new Task(true, tasksList.get(intValue).getText()));

        try{
            saveFile(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveFile(Task newTask){
        try{
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("./tasksList.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Save all the current tasks
            for (Task task : tasksList) {
                out.writeObject(task);
            }

            // Save a new task
            if(newTask != null) out.writeObject(newTask);

            out.close();
            file.close();

            //Files.write(Paths.get("tasksList.txt"), lines);
        } catch (IOException e){
            e.printStackTrace();
        }

        tasksTotal = tasksList.size();

    }
    private int checkInput(String[] args){
        if (args.length < 2) {
            System.out.println("No index provided.");
            return -1;
        }

        int intValue = -1;
        try {
            intValue = Integer.parseInt(args[1]);
        }catch (NumberFormatException e) {
            System.out.println("Input is not a valid number.");
        }

        if (intValue <= 0 || intValue > tasksList.size()) {
            System.out.println("Index is out of bound");
            return -1;
        }
        return intValue;
    }
}
