package org.pi.bbq.readers;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class SensorReader {
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	@Value("${python.exec.temperature}")
//	private String pythonExec;
//
//	Run once every 15 seconds.
//	@Scheduled(fixedDelay = 15000)
//	public void readSensors() {
//		
//		System.out.println("Start reading...");
//		try {
//			Runtime.getRuntime().exec(
//					String.format("sudo python " + pythonExec));
//		} catch (Exception e) {
//			System.err.println(String.format("Could not read the sensors"));
//			e.printStackTrace();
//		}
//		System.out.println("End reading...");
//	}
}
