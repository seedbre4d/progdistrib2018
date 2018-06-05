#!/bin/bash
JMS=/home/mk/JavaApp/mq/lib
classpath=./:$JMS/jms.jar:$JMS/imq.jar:build;
# export classpath
java -cp $classpath cmmdc.MsgCmmdcServer
