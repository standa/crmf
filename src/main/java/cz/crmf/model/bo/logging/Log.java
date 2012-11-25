/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.bo.logging;

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
@Table(name = "logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findById", query = "SELECT l FROM Log l WHERE l.id = :id"),
    @NamedQuery(name = "Log.findByCode", query = "SELECT l FROM Log l WHERE l.code = :code"),
    @NamedQuery(name = "Log.findByMessage", query = "SELECT l FROM Log l WHERE l.message = :message"),
    @NamedQuery(name = "Log.findByAction", query = "SELECT l FROM Log l WHERE l.action = :action"),
    @NamedQuery(name = "Log.findByObjectType", query = "SELECT l FROM Log l WHERE l.objectType = :objectType"),
    @NamedQuery(name = "Log.findByObjectId", query = "SELECT l FROM Log l WHERE l.objectId = :objectId"),
    @NamedQuery(name = "Log.findByLogTime", query = "SELECT l FROM Log l WHERE l.logTime = :logTime")})
public class Log extends AbstractBusinessObject {

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

    public Log(Integer id) {
        this.id = id;
    }

    public Log(Integer id, Date logTime) {
        this.id = id;
        this.logTime = logTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Log[ id=" + id + " ]";
    }
    
}
