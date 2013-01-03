/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.repositories.invoicing;

import cz.crmf.model.bo.invoicing.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author standa
 */
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Integer>  {
    
}
