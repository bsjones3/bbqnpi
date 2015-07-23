package org.pi.bbq;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
    
	@Autowired
    JdbcTemplate jdbcTemplate;
    
    @Scheduled(fixedDelay = 25000)
    public void runDataLoader() {    
    	int lowerBound = 225;
    	int upperBound = 250;
    	Random random = new Random();
    	int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
    	
    	jdbcTemplate.execute("INSERT INTO temps (sensnum,temp) values(0, " + randomNumber + ")");
    	
    	randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
    	jdbcTemplate.execute("INSERT INTO temps (sensnum,temp) values(1, " + randomNumber + ")");

    	System.out.println("Added data.");
    }

}
