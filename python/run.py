#!/usr/bin/python
from max31855 import MAX31855
import RPi.GPIO as GPIO
import sqlite3

GPIO.setwarnings(False)

#Log Temperatures
def log_temperature(sensnum,temp):
    conn=sqlite3.connect('templog.db')
    curs=conn.cursor()
    curs.execute("INSERT INTO temperatures (sensnum,temp) values((?), (?))", (sensnum,temp))
    conn.commit()
    conn.close()

#Log Errors
def log_errors(sensnum,temp):
    conn=sqlite3.connect('templog.db')
    curs=conn.cursor()
    curs.execute("INSERT INTO errors (sensnum,error) values((?), (?))", (sensnum,temp))
    conn.commit()
    conn.close()

#Sensor 1:[0], Sensor 2:[1]
#GPIO.BOARD means use the pin numbers on the pi board!!!
cs_pins=[16,38]
clock_pins=[22,36]
data_pins=[18,40]
units = "f"

t1 = MAX31855(cs_pins[0], clock_pins[0], data_pins[0], units, GPIO.BOARD)
t2 = MAX31855(cs_pins[1], clock_pins[1], data_pins[1], units, GPIO.BOARD)

if (t1.get() or t2.get()) == -1

log_temperature(1,t1.get())
log_temperature(2,t2.get())

t1.cleanup()
t2.cleanup()

#if fan.currentState() == False
#    if thermocouple1.get() < 200
#        fan.on
#if thermocouple1.get() == 300
#    fan.off
