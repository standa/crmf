/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.service;

import cz.crmf.model.dto.ticketing.TicketDto;
import java.util.List;

/**
 * Service interface for manipulating ticket requests.
 * @author standa
 */
public interface TicketingService {
    public Integer createTicket(String subject, String message, byte[] attachment, String url, String status);
    public Integer createTicket(String subject, String message, String status);
    public Integer createAnswerTicket(TicketDto parentTicket, String message, String status);
    public Integer createAnswerTicket(TicketDto parentTicket, String message, byte[] attachment, String url, String status);
    public Integer createAgent(String username, String password, String name, String email, String phone, Boolean smsNotification);
    
    public void assignTicket(Integer ticketId, Integer agentId);
    public void resolveTicket(Integer ticketId);
    
    public List<TicketDto> getTicketsByCustomer(Integer customerId);
    public List<TicketDto> getTicketsByAgent(Integer agentId);    
    public List<TicketDto> getAllTickets();
    public TicketDto getTicketById(Integer ticketId);
    
    public void removeTicket(Integer ticketId);
}
