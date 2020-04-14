package model.databaseUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class InitializeDatabase {
    public static void initializeDatabase() throws Exception {
        loadAllAccounts();
        loadAllProducts();
        loadAllLogs();
        loadAllOff();
        loadAllCategories();
    }

    private static void loadAllAccounts() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/accounts.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);

            Database.allAccounts = (ArrayList) fileOutput.readObject();

            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private static void loadAllProducts() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/products.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);

            Database.allProducts = (ArrayList) fileOutput.readObject();

            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private static void loadAllLogs() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/logs.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);

            Database.allLogs = (ArrayList) fileOutput.readObject();

            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private static void loadAllCategories() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/categories.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);

            Database.allCategories = (ArrayList) fileOutput.readObject();

            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private static void loadAllOff() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/off.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);

            Database.allOff = (ArrayList) fileOutput.readObject();

            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

}