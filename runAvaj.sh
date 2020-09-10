#!/bin/sh 
javac -d . src/*/*.java 
java -cp . src.The_Tower.Simulator.java scenario.txt
