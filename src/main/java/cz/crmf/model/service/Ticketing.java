/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.service;

import cz.crmf.model.dto.ticketing.TicketDto;
import java.util.List;

/**
 * Service interface for manipulating ticket requests.
 * @author standa
 */
public interface Ticketing {
    public Integer createTicket();
    public Integer createAgent();
    public List<TicketDto> getTicketsByCustomer(Integer customerId);
    public List<TicketDto> getTicketsByAgent(Integer agentId);
}
