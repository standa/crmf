/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.repositories.ticketing;

import cz.crmf.model.bo.ticketing.Agent;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author standa
 */
public interface AgentRepository extends PagingAndSortingRepository<Agent, Integer>  {
    
}
