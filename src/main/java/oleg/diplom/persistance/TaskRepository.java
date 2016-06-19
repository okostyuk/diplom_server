package oleg.diplom.persistance;

import oleg.diplom.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by user1 on 14.06.2016.
 */

@RepositoryRestResource()
public interface TaskRepository extends PagingAndSortingRepository<Task, String> {
}
