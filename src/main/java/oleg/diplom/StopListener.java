package oleg.diplom;

import oleg.diplom.tools.H2DatabaseServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class StopListener implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        try {
            H2DatabaseServer.stop();
            System.out.println("H2 server stopped");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
