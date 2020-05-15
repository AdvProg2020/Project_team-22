import controller.Core;
import model.databaseUtil.DatabaseInitiation;
import model.databaseUtil.Database;
import view.CommandProcessor;

public class Main {

    public static void main(String[] args) throws Exception {
        DatabaseInitiation.initializeDatabase();
        Core core = new Core();
        CommandProcessor commandProcessor = new CommandProcessor(core);
        commandProcessor.run();
    }
}