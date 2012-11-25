/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
public class TicketDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ticketId;
    private Date submitDatetime;
    private String subject;
    private String message;
    private byte[] attachment;
    private String url;
    private String status;
    private boolean resolved;
    private CustomerDto customerId;
    private AgentDto agentId;
    private List<TicketDto> ticketList;
    private TicketDto parentTicket;

    public TicketDto() {
    }

    public TicketDto(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public TicketDto(Integer ticketId, String status, boolean resolved) {
        this.ticketId = ticketId;
        this.status = status;
        this.resolved = resolved;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
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

    public AgentDto getAgentId() {
        return agentId;
    }

    public void setAgentId(AgentDto agentId) {
        this.agentId = agentId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketDto)) {
            return false;
        }
        TicketDto other = (TicketDto) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Ticket[ ticketId=" + ticketId + " ]";
    }
    
}
