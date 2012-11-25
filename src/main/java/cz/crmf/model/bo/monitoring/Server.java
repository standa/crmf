/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.bo.monitoring;

import cz.crmf.model.bo.AbstractBusinessObject;
import cz.crmf.model.bo.ticketing.Agent;
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
@Table(name = "servers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Server.findAll", query = "SELECT s FROM Server s"),
    @NamedQuery(name = "Server.findById", query = "SELECT s FROM Server s WHERE s.id = :id"),
    @NamedQuery(name = "Server.findByServerName", query = "SELECT s FROM Server s WHERE s.serverName = :serverName"),
    @NamedQuery(name = "Server.findByDescription", query = "SELECT s FROM Server s WHERE s.description = :description"),
    @NamedQuery(name = "Server.findByIpAddress", query = "SELECT s FROM Server s WHERE s.ipAddress = :ipAddress"),
    @NamedQuery(name = "Server.findByStatus", query = "SELECT s FROM Server s WHERE s.status = :status")})
public class Server extends AbstractBusinessObject {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "server_name", nullable = false, length = 45)
    private String serverName;
    @Size(max = 200)
    @Column(name = "description", length = 200)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ip_address", nullable = false, length = 45)
    private String ipAddress;
    @Size(max = 11)
    @Column(name = "status", length = 11)
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serverId")
    private List<Monitoring> monitoringList;
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    @ManyToOne
    private Agent agentId;

    public Server() {
    }

    public Server(Integer id) {
        this.id = id;
    }

    public Server(Integer id, String serverName, String ipAddress) {
        this.id = id;
        this.serverName = serverName;
        this.ipAddress = ipAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Monitoring> getMonitoringList() {
        return monitoringList;
    }

    public void setMonitoringList(List<Monitoring> monitoringList) {
        this.monitoringList = monitoringList;
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
        if (!(object instanceof Server)) {
            return false;
        }
        Server other = (Server) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Server[ id=" + id + " ]";
    }
    
}
