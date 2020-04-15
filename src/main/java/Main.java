import controller.Manager;
import model.databaseUtil.InitializeDatabase;
import view.CommandProcessor;

public class Main {

    public static void main(String[] args) {
        try {
            InitializeDatabase.initializeDatabase();
            Manager manager = new Manager();
            CommandProcessor commandProcessor = new CommandProcessor(manager);
            commandProcessor.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}