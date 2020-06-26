
import model.Core;
import model.databaseUtil.DatabaseInitiation;
import view.CommandProcessor;

public class Main {

    public static void main(String[] args)  {
        DatabaseInitiation.initializeDatabase();
        Core core = new Core();
        CommandProcessor commandProcessor = new CommandProcessor(core);
        commandProcessor.run();
    }
}