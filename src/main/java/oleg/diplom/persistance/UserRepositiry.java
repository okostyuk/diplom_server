package oleg.diplom.persistance;

import oleg.diplom.model.Task;
import oleg.diplom.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepositiry extends PagingAndSortingRepository<User, String> {
}
