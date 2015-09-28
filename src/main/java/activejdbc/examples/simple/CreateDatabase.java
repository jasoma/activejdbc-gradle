package activejdbc.examples.simple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * Creates the database used in the example.
 */
public class CreateDatabase {

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:h2:file:./src/test/resources/db", "root", "p@ssw0rd");
        String sql = Files.readAllLines(Paths.get("create.sql")).stream().collect(Collectors.joining("\n"));
        connection.createStatement().execute(sql);
    }

}
