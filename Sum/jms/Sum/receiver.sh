#!/bin/bash
JMS=/home/mk/JavaApp/mq/lib
classpath=./:$JMS/jms.jar:$JMS/imq.jar:build;
java -cp $classpath cmmdc.MsgClientReceiver $1 $2
