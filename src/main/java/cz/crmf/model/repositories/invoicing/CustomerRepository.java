package cz.crmf.model.repositories.invoicing;

import cz.crmf.model.bo.invoicing.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * The customer repository - a working alternative to the existing DAO concepts
 * which are limiting in several regards.
 * 
 * @author standa
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer>  {
    
}
