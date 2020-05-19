import main.java.controller.Core;
import main.java.model.databaseUtil.DatabaseInitiation;
import main.java.view.CommandProcessor;

public class Main {

    public static void main(String[] args)  {
        DatabaseInitiation.initializeDatabase();
        Core core = new Core();
        CommandProcessor commandProcessor = new CommandProcessor(core);
        commandProcessor.run();
    }
}