package dbEntries;

import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class DescriptionTable {
    public static Logger logger = Logger.getLogger(DescriptionTable.class);

    DataBaseService dataBaseService;

    public DescriptionTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTable(DataBaseService dataBaseService) {
        logger.info("Создаем таблицу description");
        String createTableSQL = "CREATE TABLE cases (" + " id SERIAL PRIMARY KEY," +" +
                "                \"name CHARACTER VARYING(30), \" +\n" +
                "                \");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable(DataBaseService dataBaseService) {
        logger.info("Удаляем таблицу description");

        String dropTableCasesSQL = "DROP TABLE description;";

        dataBaseService.executeSQL(dropTableCasesSQL);
    }

    public ResultSet getAllCases() {
        logger.info("Получаем все записи из таблицы cases");

        String sql = "SELECT * FROM cases ORDER BY id ASC;";

        return dataBaseService.executeQuery(sql);
    }

    public ResultSet getCaseById(int id) {
        String sql = "SELECT * FROM cases WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addCase(String name) {
        logger.info("Добавляем запист в таблицу cases");

        String insertTableSQL = "INSERT INTO public.cases(" +
                "name)" +
                "VALUES ('" + name + "');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
