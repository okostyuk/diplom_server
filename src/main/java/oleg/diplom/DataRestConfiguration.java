package oleg.diplom;

import oleg.diplom.model.Accept;
import oleg.diplom.model.Task;
import oleg.diplom.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by alena on 20.06.16.
 */
@Configuration
public class DataRestConfiguration extends RepositoryRestConfigurerAdapter {


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        config.exposeIdsFor(Task.class);
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Accept.class);
    }
}
