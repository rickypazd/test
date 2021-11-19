import java.net.*;
import java.util.Enumeration;
import java.io.*;

import Servisofts.Servisofts;

public class App2 {
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
