/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.dto.monitoring;

import cz.crmf.model.dto.AbstractDto;
import java.util.Date;

/**
 *
 * @author standa
 */
public class MonitoringDto extends AbstractDto {

    private Date updateTime;
    private String loadavg;
    private String top;
    private String netstat;
    private String df;
    private String free;
    private ServerDto serverId;

    public MonitoringDto() {
    }

    public MonitoringDto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLoadavg() {
        return loadavg;
    }

    public void setLoadavg(String loadavg) {
        this.loadavg = loadavg;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getNetstat() {
        return netstat;
    }

    public void setNetstat(String netstat) {
        this.netstat = netstat;
    }

    public String getDf() {
        return df;
    }

    public void setDf(String df) {
        this.df = df;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public ServerDto getServerId() {
        return serverId;
    }

    public void setServerId(ServerDto serverId) {
        this.serverId = serverId;
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
        if (!(object instanceof MonitoringDto)) {
            return false;
        }
        MonitoringDto other = (MonitoringDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Monitoring[ id=" + id + " ]";
    }
    
}
