/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.repositories.invoicing;

import cz.crmf.model.bo.invoicing.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author standa
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {
    
}
