package cz.crmf.service.iface;

import cz.crmf.model.dto.monitoring.MonitoringDto;

/**
 * This interface is not to be called directly from website (a big part of it).
 * But is more likely to be used as a web service for uploading the monitoring data
 * from all attached services / servers.
 * 
 * Data are collected from the two viewpoints: outer and inner monitoring. This
 * means that the servers are passively monitored as well as the servers 
 * themselves actively send their monitoring results.
 * 
 * 
 * @author standa
 */
public interface MonitoringService {

    /**
     * Get server status in a simple OK / KO logic.
     * @param serverId lookup by the server id
     * @return true - server is OK, false - server is down
     */
    public boolean ping(Integer serverId);
    
    /**
     * get the server status in a simple OK / KO logic
     * @param address lookup by the server ip address
     * @return true - server is OK, false - server is down
     */
    public boolean ping(String ipAddress);
    
    /**
     * Generate a new monitoring report into a database.
     * This is the main entry point for the outer monitoring.
     * @param serverId the ID of the server entity in the databse
     */
    public void doOuter(Integer serverId);
    
    /**
     * Add the data measured locally on the server itself.
     * 
     * @param data the data measured
     */
    public void doInner(MonitoringDto data);
}
