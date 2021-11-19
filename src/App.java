
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
                sysIP = "ip windows : "+ InetAddress.getLocalHost().getHostAddress();
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
        return "ip linux : "+ipAddress;

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

    private static InetAddress getLocalHostLANAddress() throws UnknownHostException {
        try {
            InetAddress candidateAddress = null;
            // Iterate all NICs (network interface cards)...
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements();) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // Iterate all IP addresses assigned to each card...
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements();) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {

                        if (inetAddr.isSiteLocalAddress()) {
                            // Found non-loopback site-local address. Return it immediately...
                            return inetAddr;
                        } else if (candidateAddress == null) {
                            // Found non-loopback address, but not necessarily site-local.
                            // Store it as a candidate to be returned if site-local address is not
                            // subsequently found...
                            candidateAddress = inetAddr;
                            // Note that we don't repeatedly assign non-loopback non-site-local addresses as
                            // candidates,
                            // only the first. For subsequent iterations, candidate will be non-null.
                        }
                    }
                }
 
    public static void main(String[] args) throws Exception {
        System.out.println("TEST -- 1");
        test1();
        System.out.println("TEST -- 2");
        test2();
    }

    public static void test1() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaceEnumeration.hasMoreElements()) {
            for (InterfaceAddress interfaceAddress : networkInterfaceEnumeration.nextElement().getInterfaceAddresses())
                if (interfaceAddress.getAddress().isSiteLocalAddress())
                    System.out.println(interfaceAddress.getAddress().getHostAddress());
        }
    }

    public static void test2() throws SocketException, UnknownHostException {
        System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress()); // often returns
        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        for (; n.hasMoreElements();) {
            NetworkInterface e = n.nextElement();

            Enumeration<InetAddress> a = e.getInetAddresses();
            for (; a.hasMoreElements();) {
                InetAddress addr = a.nextElement();
                System.out.println("  " + addr.getHostAddress());
                System.out.println("  " + e.getDisplayName());

             }
        }
    }

}
