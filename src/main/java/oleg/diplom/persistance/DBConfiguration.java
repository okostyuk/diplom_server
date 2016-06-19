package oleg.diplom.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by user1 on 14.06.2016.
 */

@Configuration
public class DBConfiguration {
    @Autowired
    UserRepositiry repositiry;

    public DBConfiguration() {
    }
}
