set CATALINA_HOME=E:\PD\Repo\progdistrib2018\JavaApp\apache-tomcat-9.0.8
set TARGET_FILE=E:\PD\Repo\progdistrib2018\Sum\servlet\dist\sum.war
set DESTINATION=E:\PD\Repo\progdistrib2018\JavaApp\apache-tomcat-9.0.8\webapps\
xcopy /y %TARGET_FILE% %DESTINATION%
%CATALINA_HOME%\bin\startup.bat