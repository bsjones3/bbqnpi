package org.pi.bbq.gpio.devices;

/**
 * Created by michaelwagner on 7/23/15.
 */

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Component;

@Component
public class ProvisionPins
{

	public void getTemperature()
	{
		System.out.println("Starting...");
		final GpioController gpio = GpioFactory.getInstance();

		// Sensor 1
		GpioPinDigitalOutput sck = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "SCK");
		GpioPinDigitalOutput cs = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "CS", PinState.HIGH);
		GpioPinDigitalInput so = gpio.provisionDigitalInputPin(RaspiPin.GPIO_26, "SO");

		int bytesin = 0;
		cs.setState(PinState.LOW);
		for(int i = 0; i < 32; i++)
		{
			sck.setState(PinState.LOW);
			bytesin = bytesin << 1;
			if(so.getState() == PinState.HIGH)
			{
				bytesin = bytesin | 1;
			}
			sck.setState(PinState.HIGH);
		}
		cs.setState(PinState.HIGH);
		System.out.println("Number: " + bytesin);
		gpio.shutdown();
		gpio.unprovisionPin(sck);
		gpio.unprovisionPin(cs);
		gpio.unprovisionPin(so);



		// Sensor 2
		//GpioPinDigitalOutput sck2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "SCK2");
		//GpioPinDigitalOutput cs2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "CS2", PinState.HIGH);
		//GpioPinDigitalInput so2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, "SO2");
	}


}
