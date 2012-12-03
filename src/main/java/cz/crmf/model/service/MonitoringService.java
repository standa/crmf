/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.service;

/**
 * This interface is not to be called directly from website (a big part of it).
 * But is more likely to be used a web service for uploading the monitoring data
 * from all attached services / servers.
 * @author standa
 */
public interface MonitoringService {
    public Integer addMonitoring();
    public Boolean getStatus(Integer serverId);
}
