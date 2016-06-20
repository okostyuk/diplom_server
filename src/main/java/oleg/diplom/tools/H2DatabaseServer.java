package oleg.diplom.tools;

import org.h2.tools.Server;

import java.sql.SQLException;

/**
 * Created by alena on 20.06.16.
 */
public class H2DatabaseServer {

    public static void main(String[] args) throws SQLException {
        start();
    }

    public static void start() throws SQLException {
        String[] args = {};
        Server.createTcpServer(args).start();
    }
    public static void stop() throws SQLException {
        //org.h2.tools.Server.shutdownTcpServer("tcp://localhost:9094" , "", true, true);
        Server.shutdownTcpServer("tcp://localhost:9092", "sa", true, true);
    }
}
