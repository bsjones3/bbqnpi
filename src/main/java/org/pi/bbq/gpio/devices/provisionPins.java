package org.pi.bbq.gpio.devices;

/**
 * Created by michaelwagner on 7/23/15.
 */

import com.pi4j.io.gpio.*;

public class provisionPins
{

	public static void main(String[] args) throws InterruptedException
	{
		final GpioController gpio = GpioFactory.getInstance();

		// Sensor 1
		GpioPinDigitalOutput sck = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "SCK");
		GpioPinDigitalOutput cs = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "CS", PinState.HIGH);
		GpioPinDigitalInput so = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, "SO");
		// Sensor 2
		GpioPinDigitalOutput sck2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "SCK2");
		GpioPinDigitalOutput cs2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "CS2", PinState.HIGH);
		GpioPinDigitalInput so2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, "SO2");
	}


}
