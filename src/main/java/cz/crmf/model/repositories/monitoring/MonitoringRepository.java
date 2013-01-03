/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.repositories.monitoring;

import cz.crmf.model.bo.monitoring.Monitoring;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author standa
 */
public interface MonitoringRepository extends PagingAndSortingRepository<Monitoring, Integer>  {
    
}
