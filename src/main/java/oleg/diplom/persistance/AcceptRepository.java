package oleg.diplom.persistance;

import oleg.diplom.model.Accept;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by user1 on 15.06.2016.
 */
@RepositoryRestResource
public interface AcceptRepository extends PagingAndSortingRepository<Accept, String> {
    Accept findByTaskId(String taskId);
    Accept findByPerformerId(String performetId);
}
