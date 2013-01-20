package cz.crmf.scheduler;

import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xbill.DNS.*;

/**
 * This class contains a set of tasks to be executed in order to monitor
 * services on distant servers.
 * 
 * @author standa
 */
public class ServerMonitoring {
    
    // do the pings for all the servers
    public void ping() {
        System.out.println("Pinging the servers...");
    }
    
    /**
     * ping the list of the servers that this system administers
     * 
     * inspired by http://www.kodejava.org/examples/109.html
     * 
     * @param address the address of the pinged device, ie. "172.16.2.0"
     */
    public boolean ping(String address) {
        
        System.out.println("Pinging server.");
    
        try
        {
            InetAddress ia = Address.getByName(address);
 
            // Try to reach the specified address within the timeout
            // periode. If during this periode the address cannot be
            // reach then the method returns false.
            boolean reachable = ia.isReachable(3000);
 
            System.out.println("Is host reachable? " + reachable);
            return reachable;
            
        } catch (Exception e) {
            System.out.println("Error occured.");
            return false;
        }
    }
    // from http://www.dnsjava.org/dnsjava-current/examples.html
    public void getMXRecords(String domain) {
        try {
            Record [] records = new Lookup(domain, Type.MX).run();
            for (int i = 0; i < records.length; i++) {
                MXRecord mx = (MXRecord) records[i];
                System.out.println("Host " + mx.getTarget() + " has preference " + mx.getPriority());
            }
        } catch (TextParseException ex) {
            Logger.getLogger(ServerMonitoring.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
