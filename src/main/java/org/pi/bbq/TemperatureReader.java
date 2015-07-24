package org.pi.bbq;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.pi.bbq.gpio.devices.Max31855;
import org.pi.bbq.gpio.devices.ProvisionPins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Spi;

@Component
public class TemperatureReader {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ProvisionPins provisionPins;

	private static List<String> faults = new ArrayList<String>();

	//Run once a minute.
	@Scheduled(fixedDelay = 10000)
	public void readTemperatures() {

		provisionPins.getTemperature();
			
		//jdbcTemplate.execute("INSERT INTO temps (sensnum,temp) values(0, "
		//			+ thermocouple + ")");
	}


	private static void onFaults(int f) {
		faults.clear();

		if ((f & Max31855.FAULT_OPEN_CIRCUIT_BIT) == Max31855.FAULT_OPEN_CIRCUIT_BIT)
			faults.add("Open Circuit");
		if ((f & Max31855.FAULT_SHORT_TO_GND_BIT) == Max31855.FAULT_SHORT_TO_GND_BIT)
			faults.add("Short To GND");
		if ((f & Max31855.FAULT_SHORT_TO_VCC_BIT) == Max31855.FAULT_SHORT_TO_VCC_BIT)
			faults.add("Short To VCC");

		boolean first = true;
		String text = "Faults = ";
		for (String fault : faults) {
			if (!first)
				text += ", ";
			text += fault;
		}

		System.err.println(text);
	}

	//@Scheduled(fixedDelay = 25000)
	public void runDataLoader() {
		int lowerBound = 225;
		int upperBound = 250;
		Random random = new Random();
		int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;

		jdbcTemplate.execute("INSERT INTO temps (sensnum,temp) values(0, "
				+ randomNumber + ")");

		randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
		jdbcTemplate.execute("INSERT INTO temps (sensnum,temp) values(1, "
				+ randomNumber + ")");

		System.out.println("Added data.");

	}

	public void testGPIO() {
		System.out.println("<--Pi4J--> GPIO Control Example ... started.");

		// create gpio controller
		final GpioController gpio = GpioFactory.getInstance();

		// provision gpio pin #01 as an output pin and turn on
		final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(
				RaspiPin.GPIO_01, "MyLED", PinState.HIGH);

		// set shutdown state for this pin
		pin.setShutdownOptions(true, PinState.LOW);

		System.out.println("--> GPIO state should be: ON");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// turn off gpio pin #01
		pin.low();
		System.out.println("--> GPIO state should be: OFF");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// toggle the current state of gpio pin #01 (should turn on)
		pin.toggle();
		System.out.println("--> GPIO state should be: ON");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// toggle the current state of gpio pin #01 (should turn off)
		pin.toggle();
		System.out.println("--> GPIO state should be: OFF");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// turn on gpio pin #01 for 1 second and then off
		System.out.println("--> GPIO state should be: ON for only 1 second");
		pin.pulse(1000, true); // set second argument to 'true' use a blocking
								// call

		// stop all GPIO activity/threads by shutting down the GPIO controller
		// (this method will forcefully shutdown all GPIO monitoring threads and
		// scheduled tasks)
		gpio.shutdown();

	}

}
