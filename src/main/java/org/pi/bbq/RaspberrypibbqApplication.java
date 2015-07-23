package org.pi.bbq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RaspberrypibbqApplication{

    public static void main(String[] args) {
        SpringApplication.run(RaspberrypibbqApplication.class, args);
    }
    
  
}
