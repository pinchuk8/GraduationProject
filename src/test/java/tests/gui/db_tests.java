package tests.gui;

import baseEntities.BaseDbTest;
import dbEntries.TaskTable;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import utils.Randomization;

import java.sql.ResultSet;
import java.sql.SQLException;

public class db_tests  extends BaseDbTest {
    public static Logger logger = Logger.getLogger(db_tests.class);
    TaskTable descriptionTable = new TaskTable(dataBaseService);

    @Test
    public void y() {
        descriptionTable.dropTable(dataBaseService);
        descriptionTable.createTable(dataBaseService);
        descriptionTable.addDescription(dataBaseService, Randomization.getRandomString(5),"task for student");
        ResultSet rs = descriptionTable.getAllDescriptions(dataBaseService);
        try {
            while (rs.next()) {
                String summary = rs.getString("summary");
                String description = rs.getString("description");
                logger.info("summary: " + summary);
                logger.info("description: " + description);
            }
        } catch (
                SQLException e) {
            logger.error(e.toString());
        }
    }
}
