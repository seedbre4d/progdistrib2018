rem set JAVA_HOME=c:\Program Files\Java\jdk1.8.0_161
rem set JRE_HOME=c:\Program Files\Java\jre1.8.0_161
set CATALINA_HOME=C:\Users\Alex\Desktop\Scoala\JavaApp\apache-tomee-plume-7.0.4
set TARGET_FILE=C:\Users\Alex\Desktop\Scoala\RestantaDistr\Vara\Sum\ejb\stateless\dist\sum-ejb.war
set DESTINATION=C:\Users\Alex\Desktop\Scoala\JavaApp\apache-tomee-plume-7.0.4\webapps
xcopy /y %TARGET_FILE% %DESTINATION%
%CATALINA_HOME%\bin\startup.bat %1
