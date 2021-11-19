
import java.io.*;
import java.net.*;
import java.util.*;

import Servisofts.Servisofts;

public class App {

    public static String getSystemIP() {
        try {
            String sysIP = "";
            String OSName = System.getProperty("os.name");
            if (OSName.contains("Windows")) {
                sysIP = "ip windows : " + InetAddress.getLocalHost().getHostAddress();
            } else {
                sysIP = getIpLinux();

            }
            return sysIP;
        } catch (Exception E) {
            System.err.println("System IP Exp : " + E.getMessage());
            return null;
        }
    }

    private static String getIpLinux() throws UnknownHostException {

        InetAddress ip = InetAddress.getLocalHost();
        String ipAddress = ip.getHostAddress();
        return "ip linux : " + ipAddress;

    }

    private static String getSystemIP4Linux(String name) {
        try {
            String ip = "";
            NetworkInterface networkInterface = NetworkInterface.getByName(name);
            Enumeration<InetAddress> inetAddress = networkInterface.getInetAddresses();
            InetAddress currentAddress = inetAddress.nextElement();
            while (inetAddress.hasMoreElements()) {
                currentAddress = inetAddress.nextElement();
                if (currentAddress instanceof Inet4Address && !currentAddress.isLoopbackAddress()) {
                    ip = currentAddress.toString();
                    break;
                }
            }
            if (ip.startsWith("/")) {
                ip = ip.substring(1);
            }
            return ip + " dddd";
        } catch (Exception E) {
            System.err.println("System Linux IP Exp : " + E.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {

        String ip;
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp())
                    continue;
        
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
        
                    // *EDIT*
                    if (addr instanceof Inet6Address) continue;
        
                    ip = addr.getHostAddress();
                    System.out.println(iface.getDisplayName() + " " + ip);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

    }

}
