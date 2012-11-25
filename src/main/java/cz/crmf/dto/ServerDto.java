/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.dto;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
public class ServerDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer serverId;
    private String serverName;
    private String description;
    private String ipAddress;
    private String status;
    private List<MonitoringDto> monitoringList;
    private AgentDto agentId;

    public ServerDto() {
    }

    public ServerDto(Integer serverId) {
        this.serverId = serverId;
    }

    public ServerDto(Integer serverId, String serverName, String ipAddress) {
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
    public List<MonitoringDto> getMonitoringList() {
        return monitoringList;
    }

    public void setMonitoringList(List<MonitoringDto> monitoringList) {
        this.monitoringList = monitoringList;
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
        hash += (serverId != null ? serverId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServerDto)) {
            return false;
        }
        ServerDto other = (ServerDto) object;
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
