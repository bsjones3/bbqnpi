package org.pi.bbq.gpio.devices;

import org.springframework.stereotype.Component;

@Component
public class Max31855 {
		
	public void logTemperatures(String pythonExec) {
		System.out.println("Start reading...");
		try {
			Runtime.getRuntime().exec(
					String.format("sudo python " + pythonExec));
		} catch (Exception e) {
			System.err.println(String.format("Could not read the sensors"));
			e.printStackTrace();
			return;
		}
		System.out.println("End reading...");		
		return;
	}
}
