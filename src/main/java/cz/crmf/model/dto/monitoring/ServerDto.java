/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.dto.monitoring;

import cz.crmf.model.dto.AbstractDto;
import cz.crmf.model.dto.ticketing.AgentDto;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
public class ServerDto extends AbstractDto {

    private String serverName;
    private String description;
    private String ipAddress;
    private String status;
    private List<MonitoringDto> monitoringList;
    private AgentDto agentId;

    public ServerDto() {
    }

    public ServerDto(Integer id) {
        this.id = id;
    }

    public ServerDto(Integer id, String serverName, String ipAddress) {
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServerDto)) {
            return false;
        }
        ServerDto other = (ServerDto) object;
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
