package org.pi.bbq.gpio.devices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.stereotype.Component;

@Component
public class Max31855 {
	
	public String logTemperatures() {
		
		String result = "";
		try {
/// TODO Change to use the Python script to read temperature values.			
			Process p = Runtime.getRuntime().exec(
					String.format("sudo python xxxx.py"));
			BufferedReader in = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.err.println(String.format("Could not read the sensors"));
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
