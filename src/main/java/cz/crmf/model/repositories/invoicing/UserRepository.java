package cz.crmf.model.repositories.invoicing;

import cz.crmf.model.bo.invoicing.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * The user repository - a working alternative to the existing DAO concepts
 * which are limiting in several regards.
 * 
 * @author standa
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer>  {
    
}
