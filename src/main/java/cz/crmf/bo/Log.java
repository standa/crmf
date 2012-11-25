/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.bo;

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
@Table(name = "logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByLogId", query = "SELECT l FROM Log l WHERE l.logId = :logId"),
    @NamedQuery(name = "Log.findByCode", query = "SELECT l FROM Log l WHERE l.code = :code"),
    @NamedQuery(name = "Log.findByMessage", query = "SELECT l FROM Log l WHERE l.message = :message"),
    @NamedQuery(name = "Log.findByAction", query = "SELECT l FROM Log l WHERE l.action = :action"),
    @NamedQuery(name = "Log.findByObjectType", query = "SELECT l FROM Log l WHERE l.objectType = :objectType"),
    @NamedQuery(name = "Log.findByObjectId", query = "SELECT l FROM Log l WHERE l.objectId = :objectId"),
    @NamedQuery(name = "Log.findByLogTime", query = "SELECT l FROM Log l WHERE l.logTime = :logTime")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "log_id", nullable = false)
    private Integer logId;
    @Column(name = "code")
    private Integer code;
    @Size(max = 500)
    @Column(name = "message", length = 500)
    private String message;
    @Size(max = 50)
    @Column(name = "action", length = 50)
    private String action;
    @Size(max = 45)
    @Column(name = "object_type", length = 45)
    private String objectType;
    @Column(name = "object_id")
    private Integer objectId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "log_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date logTime;

    public Log() {
    }

    public Log(Integer logId) {
        this.logId = logId;
    }

    public Log(Integer logId, Date logTime) {
        this.logId = logId;
        this.logTime = logTime;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Log[ logId=" + logId + " ]";
    }
    
}
