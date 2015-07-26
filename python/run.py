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
#GPIO.BOARD means use the pin numbers on the pi board (NOT the GPIO Numbers)!!!
cs_pins=[16,38]
clock_pins=[22,36]
data_pins=[18,40]
t=[]
units = "f"

for x in range(0,2):
    t.append(MAX31855(cs_pins[x], clock_pins[x], data_pins[x], units, GPIO.BOARD))

for i in range(0,2):
    if t[i].get() == -1:
        log_errors(i+1,"No Connection")
    elif t[i].get() == -2:
        log_errors(i+1,"Thermocouple short to ground")
    elif t[i].get() == -3:
        log_errors(i+1,"Thermocouple short to VCC")
    elif t[i].get() == -4:
        log_errors(i+1,"Unknown Error")
    else:
        log_temperature(i+1,t[i].get())

t[0].cleanup()
t[1].cleanup()

#if fan.currentState() == False
#    if thermocouple1.get() < 200
#        fan.on
#if thermocouple1.get() == 300
#    fan.off
