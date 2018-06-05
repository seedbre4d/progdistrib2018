#!/bin/bash
JMS=/home/mk/JavaApp/mq/lib
classpath=./:$JMS/jms.jar:$JMS/imq.jar;
# export classpath
javac -cp $classpath -Xlint -d build src/*.java



