package net.pingpong.lib;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GameVars {
	public InetAddress localAddress;
	public NetworkInterface networkInterface;
	public InetAddress serverAddress;
	public GameVars () {
		
	}
	public void setNetworkInterface () {
		networkInterface = Interfaces.getInterface();
//		serverAddress = selectedInterface.
	}
	public void setNetworkInterface (String interfaceName) {
		System.out.println(interfaceName);
		try {
			networkInterface = NetworkInterface.getByName(interfaceName);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setServerAddress (String serverAddressName) {
		System.out.println(serverAddressName);
		try {
			serverAddress = InetAddress.getByName(serverAddressName);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
