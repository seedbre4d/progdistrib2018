set CATALINA_HOME=C:\PROGRA~1\APACHE~1\TOMCAT~1.0
set TARGET_FILE=C:\Users\Alex\Desktop\Scoala\RestantaDistr\Vara\Sum\jsp\jsp-1\dist\sumJSP.war
set DESTINATION=C:\PROGRA~1\APACHE~1\TOMCAT~1.0\webapps\
xcopy /y %TARGET_FILE% %DESTINATION%
%CATALINA_HOME%\bin\startup.bat