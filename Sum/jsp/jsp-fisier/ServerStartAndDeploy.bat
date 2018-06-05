set CATALINA_HOME=E:\PD\Repo\progdistrib2018\JavaApp\apache-tomcat-9.0.8
set TARGET_FILE=E:\PD\Repo\progdistrib2018\Sum\jsp\jsp-fisier\sumFile.jsp
set DESTINATION=E:\PD\Repo\progdistrib2018\JavaApp\apache-tomcat-9.0.8\webapps\sumfile\
xcopy /y %TARGET_FILE% %DESTINATION%
%CATALINA_HOME%\bin\startup.bat

