package baseEntities;

import core.DataBaseService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseDbTest {
    protected DataBaseService dataBaseService;
    @BeforeTest
    public void setUpConnection(){
        org.apache.log4j.BasicConfigurator.configure();
        dataBaseService=new DataBaseService();
    }
    @AfterTest
    public void closeConnection(){
        dataBaseService.closeConnection();
    }
}
