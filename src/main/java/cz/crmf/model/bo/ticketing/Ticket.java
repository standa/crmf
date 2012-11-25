/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.bo.ticketing;

import cz.crmf.model.bo.AbstractBusinessObject;
import cz.crmf.model.bo.invoicing.Customer;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
@Entity
@Table(name = "tickets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id"),
    @NamedQuery(name = "Ticket.findBySubmitDatetime", query = "SELECT t FROM Ticket t WHERE t.submitDatetime = :submitDatetime"),
    @NamedQuery(name = "Ticket.findBySubject", query = "SELECT t FROM Ticket t WHERE t.subject = :subject"),
    @NamedQuery(name = "Ticket.findByUrl", query = "SELECT t FROM Ticket t WHERE t.url = :url"),
    @NamedQuery(name = "Ticket.findByStatus", query = "SELECT t FROM Ticket t WHERE t.status = :status"),
    @NamedQuery(name = "Ticket.findByResolved", query = "SELECT t FROM Ticket t WHERE t.resolved = :resolved")})
public class Ticket extends AbstractBusinessObject {

    @Column(name = "submit_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submitDatetime;
    @Size(max = 150)
    @Column(name = "subject", length = 150)
    private String subject;
    @Lob
    @Size(max = 65535)
    @Column(name = "message", length = 65535)
    private String message;
    @Lob
    @Column(name = "attachment")
    private byte[] attachment;
    @Size(max = 500)
    @Column(name = "url", length = 500)
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status", nullable = false, length = 10)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resolved", nullable = false)
    private boolean resolved;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne
    private Customer customerId;
    @OneToMany(mappedBy = "parentTicket")
    private List<Ticket> ticketList;
    @JoinColumn(name = "parent_ticket", referencedColumnName = "id")
    @ManyToOne
    private Ticket parentTicket;
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    @ManyToOne
    private Agent agentId;

    public Ticket() {
    }

    public Ticket(Integer id) {
        this.id = id;
    }

    public Ticket(Integer id, String status, boolean resolved) {
        this.id = id;
        this.status = status;
        this.resolved = resolved;
    }

    public Integer getId() {
        return id;
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

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Ticket getParentTicket() {
        return parentTicket;
    }

    public void setParentTicket(Ticket parentTicket) {
        this.parentTicket = parentTicket;
    }

    public Agent getAgentId() {
        return agentId;
    }

    public void setAgentId(Agent agentId) {
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
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
