package cz.crmf.view.bb;

import cz.crmf.model.bo.ticketing.Ticket;
import cz.crmf.model.dto.ticketing.TicketDto;
import cz.crmf.model.repositories.ticketing.TicketRepository;
import cz.crmf.service.iface.AbstractDataAccessService;
import cz.crmf.service.iface.TicketingService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the ticketing service used as a view for the JSF.
 * 
 * @author standa
 */
@Service("ticketingService")
public class TicketingServiceImpl extends AbstractDataAccessService 
    implements TicketingService {
    
    @Autowired
    TicketRepository ticketRepository;
    
    @Override
    public Integer createTicket(String subject, String message, byte[] attachment, String url, String status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer createTicket(String subject, String message, String status) {        
        ModelMapper mm = new ModelMapper();
        Ticket t = ticketRepository.save(mm.map(new TicketDto(subject, message), Ticket.class));
        return t.getId();
    }

    @Override
    public Integer createAnswerTicket(TicketDto parentTicket, String message, String status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer createAnswerTicket(TicketDto parentTicket, String message, byte[] attachment, String url, String status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer createAgent(String username, String password, String name, String email, String phone, Boolean smsNotification) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assignTicket(Integer ticketId, Integer agentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void resolveTicket(Integer ticketId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TicketDto> getTicketsByCustomer(Integer customerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TicketDto> getTicketsByAgent(Integer agentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TicketDto getTicketById(Integer ticketId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeTicket(Integer ticketId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TicketDto> getAllTickets() {
                
        List<TicketDto> tickets = new ArrayList<TicketDto>();
        for (Ticket t : getGenericDao().getAll(Ticket.class)) {
            TicketDto dto = getModelMapper().map(t, TicketDto.class);
            tickets.add(dto);
        }
        return tickets;
        
    }
    
}
