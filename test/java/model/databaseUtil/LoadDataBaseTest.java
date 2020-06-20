package model.databaseUtil;

import org.junit.Assert;
import org.junit.Test;

public class LoadDataBaseTest {

    @Test
    public void load(){
        DatabaseInitiation.initializeDatabase();
        Assert.assertEquals("milk", Database.getAllProducts().get(0).getName()) ;
    }
}
