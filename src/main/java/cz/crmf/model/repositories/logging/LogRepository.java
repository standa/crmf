/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.repositories.logging;

import cz.crmf.model.bo.logging.Log;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author standa
 */
public interface LogRepository extends PagingAndSortingRepository<Log, Integer>  {
    
}
