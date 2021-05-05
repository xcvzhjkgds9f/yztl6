package com.rui.pingtest;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException {
		File file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("PingTest.jar", "tishiyin.wav"));
		URL url = file.toURL();
		AudioClip ac = Applet.newAudioClip(url);
		while (true) {
			try {
				if(!doping()) {
//					System.out.println("播了吗");
					ac.play();
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("MAIN方法捕获异常");
			}
			
		}
	}
	
	public static boolean doping() throws UnknownHostException, IOException {
		try {
			int  timeOut =  150 ;
			boolean status = InetAddress.getByName("47.104.220.107").isReachable(timeOut);
			System.out.println(status);
			return status;
		} catch (Exception e) {
			System.out.println("PING方法捕获异常");
			return false;
		}
	}
}
