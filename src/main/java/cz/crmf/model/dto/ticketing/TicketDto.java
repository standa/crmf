/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.dto.ticketing;

import cz.crmf.model.dto.AbstractDto;
import cz.crmf.model.dto.invoicing.CustomerDto;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
public class TicketDto extends AbstractDto {

    private Date submitDatetime;
    private String subject;
    private String message;
    private byte[] attachment;
    private String url;
    private String status;
    private boolean resolved;
    private CustomerDto customerId;
    private List<TicketDto> ticketList;
    private TicketDto parentTicket;
    private AgentDto agentId;

    public TicketDto() {
    }

    public TicketDto(Integer id) {
        this.id = id;
    }

    public TicketDto(Integer id, String status, boolean resolved) {
        this.id = id;
        this.status = status;
        this.resolved = resolved;
    }
    
    public TicketDto(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSubmitDatetime() {
        return submitDatetime;
    }

    public void setSubmitDatetime(Date submitDatetime) {
        this.submitDatetime = submitDatetime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public CustomerDto getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerDto customerId) {
        this.customerId = customerId;
    }

    @XmlTransient
    public List<TicketDto> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<TicketDto> ticketList) {
        this.ticketList = ticketList;
    }

    public TicketDto getParentTicket() {
        return parentTicket;
    }

    public void setParentTicket(TicketDto parentTicket) {
        this.parentTicket = parentTicket;
    }

    public AgentDto getAgentId() {
        return agentId;
    }

    public void setAgentId(AgentDto agentId) {
        this.agentId = agentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketDto)) {
            return false;
        }
        TicketDto other = (TicketDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Ticket[ id=" + id + " ]";
    }
    
}
