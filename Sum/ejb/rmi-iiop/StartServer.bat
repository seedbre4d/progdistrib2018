set JAVA_HOME=c:\Program Files\Java\jdk1.8.0_172
set JRE_HOME=c:\Program Files\Java\jre1.8.0_172
set CATALINA_HOME=E:\PD\Repo\progdistrib2018\JavaApp\apache-tomee-plume-7.0.4
set TARGET_FILE=E:\PD\Repo\progdistrib2018\Sum\ejb\rmi-iiop\dist\sum-ear.ear
set DESTINATION=E:\PD\Repo\progdistrib2018\JavaApp\apache-tomee-plume-7.0.4\apps
xcopy /y %TARGET_FILE% %DESTINATION%
%CATALINA_HOME%\bin\startup.bat %1
