set JMS=C:\Users\Alex\Desktop\Scoala\JavaApp\MessageQueue5.1\mq\lib
set classpath=.;%JMS%\jms.jar;%JMS%\imq.jar;
javac -Xlint -d . src\*.java
start server.bat
start sender.bat
start receiver.bat