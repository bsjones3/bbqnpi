package org.pi.bbq.models;

import java.util.List;

public class Temperature_record {
	
	private List<Temperature> temperature_record;

	/**
	 * @return the temperature
	 */
	public List<Temperature> getTemperature() {
		return temperature_record;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(List<Temperature> temperature) {
		this.temperature_record = temperature;
	}
	

}
