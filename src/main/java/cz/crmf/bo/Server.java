/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.bo;

import java.io.Serializable;
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
    @NamedQuery(name = "Server.findByServerId", query = "SELECT s FROM Server s WHERE s.serverId = :serverId"),
    @NamedQuery(name = "Server.findByServerName", query = "SELECT s FROM Server s WHERE s.serverName = :serverName"),
    @NamedQuery(name = "Server.findByDescription", query = "SELECT s FROM Server s WHERE s.description = :description"),
    @NamedQuery(name = "Server.findByIpAddress", query = "SELECT s FROM Server s WHERE s.ipAddress = :ipAddress"),
    @NamedQuery(name = "Server.findByStatus", query = "SELECT s FROM Server s WHERE s.status = :status")})
public class Server implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "server_id", nullable = false)
    private Integer serverId;
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
    @JoinColumn(name = "agent_id", referencedColumnName = "agent_id")
    @ManyToOne
    private Agent agentId;

    public Server() {
    }

    public Server(Integer serverId) {
        this.serverId = serverId;
    }

    public Server(Integer serverId, String serverName, String ipAddress) {
        this.serverId = serverId;
        this.serverName = serverName;
        this.ipAddress = ipAddress;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
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
        hash += (serverId != null ? serverId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Server)) {
            return false;
        }
        Server other = (Server) object;
        if ((this.serverId == null && other.serverId != null) || (this.serverId != null && !this.serverId.equals(other.serverId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Server[ serverId=" + serverId + " ]";
    }
    
}
