package org.pi.bbq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SensorReader {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${python.exec.temperature}")
	private String pythonExec;

	//Run once every 15 seconds.
	@Scheduled(fixedDelay = 15000)
	public void readSensors() {
		
		System.out.println("Start reading...");
		try {
			Runtime.getRuntime().exec(
					String.format("sudo python " + pythonExec));
		} catch (Exception e) {
			System.err.println(String.format("Could not read the sensors"));
			e.printStackTrace();
		}
		System.out.println("End reading...");
	}
}
