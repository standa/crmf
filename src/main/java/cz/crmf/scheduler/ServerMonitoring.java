package cz.crmf.scheduler;

/**
 * This class contains a set of tasks to be executed in order to monitor
 * services on distant servers.
 * 
 * @author standa
 */
public class ServerMonitoring {
    
    /**
     * ping the list of the servers that this system administers
     */
    public void ping() {
        System.out.println("Pinging server.");
    }
}
