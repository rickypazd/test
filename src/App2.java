import java.net.*;
import java.util.Enumeration;
import java.io.*;

import Servisofts.Servisofts;

public class App2 {
    public static void main(String[] args) throws Exception {
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
        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        for (; n.hasMoreElements();) {
            NetworkInterface e = n.nextElement();
            Enumeration<InetAddress> a = e.getInetAddresses();
            for (; a.hasMoreElements();) {
                InetAddress addr = a.nextElement();
                if (addr instanceof Inet4Address) {
                    System.out.println("Interface: " + e.getDisplayName());
                    System.out.println("IPv4: " + addr.getHostAddress());
                    System.out.println("");
                }
            }
        }
    }

}
