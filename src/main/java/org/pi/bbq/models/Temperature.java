package org.pi.bbq.models;

import java.sql.Timestamp;


public class Temperature {

	private Timestamp time;
	private int sensnum;
	private int temp;
	
	public Temperature(Timestamp timestamp, int int1, int int2) 
	{
		this.time = timestamp;
		this.sensnum = int1;
		this.temp = int2;
	}
	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}
	/**
	 * @return the sensnum
	 */
	public int getSensnum() {
		return sensnum;
	}
	/**
	 * @param sensnum the sensnum to set
	 */
	public void setSensnum(int sensnum) {
		this.sensnum = sensnum;
	}
	/**
	 * @return the temp
	 */
	public int getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(int temp) {
		this.temp = temp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Temperature [time=" + time + ", sensnum=" + sensnum + ", temp="
				+ temp + "]";
	}
}
