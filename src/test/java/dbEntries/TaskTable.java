package dbEntries;

import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class TaskTable {
    public static Logger logger = Logger.getLogger(TaskTable.class);

    DataBaseService dataBaseService;

    public TaskTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTable(DataBaseService dataBaseService) {
        logger.info("Создаем таблицу task");
        String createTableSQL = "CREATE TABLE task (" +
                "id SERIAL PRIMARY KEY, " +
                "summary CHARACTER VARYING(30), " +
                "description CHARACTER VARYING(30) " +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable(DataBaseService dataBaseService) {
        logger.info("Удаляем таблицу task");

        String dropTableCasesSQL = "DROP TABLE task;";

        dataBaseService.executeSQL(dropTableCasesSQL);
    }

    public ResultSet getAllDescriptions(DataBaseService dataBaseService) {
        logger.info("Получаем все записи из таблицы task");

        String sql = "SELECT * FROM task ORDER BY id ASC;";

        return dataBaseService.executeQuery(sql);
    }

    public ResultSet getDescriptionById(DataBaseService dataBaseService, int id) {
        String sql = "SELECT * FROM task WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addDescription(DataBaseService dataBaseService, String summary, String description) {
        logger.info("Добавляем запист в таблицу task");

        String insertTableSQL = "INSERT INTO public.task(" +
                "summary, description)" +
                "VALUES ('" + summary + "', '"+ description +"');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
