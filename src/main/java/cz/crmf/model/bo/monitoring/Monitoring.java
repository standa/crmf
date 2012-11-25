/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.bo.monitoring;

import cz.crmf.model.bo.AbstractBusinessObject;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author standa
 */
@Entity
@Table(name = "monitoring")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitoring.findAll", query = "SELECT m FROM Monitoring m"),
    @NamedQuery(name = "Monitoring.findById", query = "SELECT m FROM Monitoring m WHERE m.id = :id"),
    @NamedQuery(name = "Monitoring.findByUpdateTime", query = "SELECT m FROM Monitoring m WHERE m.updateTime = :updateTime")})
public class Monitoring extends AbstractBusinessObject {

    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Lob
    @Size(max = 65535)
    @Column(name = "loadavg", length = 65535)
    private String loadavg;
    @Lob
    @Size(max = 65535)
    @Column(name = "top", length = 65535)
    private String top;
    @Lob
    @Size(max = 65535)
    @Column(name = "netstat", length = 65535)
    private String netstat;
    @Lob
    @Size(max = 65535)
    @Column(name = "df", length = 65535)
    private String df;
    @Lob
    @Size(max = 65535)
    @Column(name = "free", length = 65535)
    private String free;
    @JoinColumn(name = "server_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Server serverId;

    public Monitoring() {
    }

    public Monitoring(Integer id) {
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

    public Server getServerId() {
        return serverId;
    }

    public void setServerId(Server serverId) {
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
        if (!(object instanceof Monitoring)) {
            return false;
        }
        Monitoring other = (Monitoring) object;
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
