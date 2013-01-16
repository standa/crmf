package cz.crmf.service.iface;

/**
 * This interface is not to be called directly from website (a big part of it).
 * But is more likely to be used as a web service for uploading the monitoring data
 * from all attached services / servers.
 * @author standa
 */
public interface MonitoringService {
    public Integer addMonitoring();
    public boolean getStatus(Integer serverId);
    public boolean getStatusByAddress(String address);
}
