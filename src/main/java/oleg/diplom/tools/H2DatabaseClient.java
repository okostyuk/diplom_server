package oleg.diplom.tools;

import java.sql.SQLException;

/**
 * Created by alena on 20.06.16.
 */
public class H2DatabaseClient {
    public static void main(String[] args) throws SQLException {
        org.h2.tools.Console.main(args);
    }
}
