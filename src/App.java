
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

        String ipAddress = getSystemIP();
        System.out.println("System IP : " + ipAddress);

        // InetAddress ip = InetAddress.getLocalHost();
        // String ipAddress = ip.getHostAddress();
        // String ipName = ip.getHostName();
        // String ipHost = ip.getHostAddress();
        // System.out.println("IP: " + ipAddress);
        // System.out.println("Nombre: " + ipName);
        // System.out.println("Host: " + ipHost);
        // String ipA = getLocalHostLANAddress().getHostAddress();
        // System.out.println("IP: " + ipA);

    }

}
