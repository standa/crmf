/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.bo;

import java.io.Serializable;
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
    @NamedQuery(name = "Ticket.findByTicketId", query = "SELECT t FROM Ticket t WHERE t.ticketId = :ticketId"),
    @NamedQuery(name = "Ticket.findBySubmitDatetime", query = "SELECT t FROM Ticket t WHERE t.submitDatetime = :submitDatetime"),
    @NamedQuery(name = "Ticket.findBySubject", query = "SELECT t FROM Ticket t WHERE t.subject = :subject"),
    @NamedQuery(name = "Ticket.findByUrl", query = "SELECT t FROM Ticket t WHERE t.url = :url"),
    @NamedQuery(name = "Ticket.findByStatus", query = "SELECT t FROM Ticket t WHERE t.status = :status"),
    @NamedQuery(name = "Ticket.findByResolved", query = "SELECT t FROM Ticket t WHERE t.resolved = :resolved")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticket_id", nullable = false)
    private Integer ticketId;
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
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "agent_id", referencedColumnName = "agent_id")
    @ManyToOne
    private Agent agentId;
    @OneToMany(mappedBy = "parentTicket")
    private List<Ticket> ticketList;
    @JoinColumn(name = "parent_ticket", referencedColumnName = "ticket_id")
    @ManyToOne
    private Ticket parentTicket;

    public Ticket() {
    }

    public Ticket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(Integer ticketId, String status, boolean resolved) {
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

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Agent getAgentId() {
        return agentId;
    }

    public void setAgentId(Agent agentId) {
        this.agentId = agentId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
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
