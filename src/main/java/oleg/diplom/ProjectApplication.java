package oleg.diplom;

import oleg.diplom.tools.H2DatabaseServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProjectApplication {

	public static void main(final String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					org.h2.tools.Console.main(args);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try { H2DatabaseServer.stop(); } catch (SQLException e) {}

				try {
					H2DatabaseServer.start();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}).start();

		ApplicationContext ctx = SpringApplication.run(ProjectApplication.class, args);

	}
}
