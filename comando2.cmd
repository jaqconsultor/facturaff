setlocal
set "JAVA_HOME=c:\openxava-7-r2-Facturacion\jdk-17.0.6.10-hotspot\"
SET PATH=%PATH%;c:\openxava-7-r2-Facturacion\jdk-17.0.6.10-hotspot\bin;c:\openxava-7-r2-Facturacion\apache-maven-3.9.0\bin;

del C:\WebJAQConsultor\apache-tomcat-9.0.71\webapps\*.war

cd C:\openxava-7-r2-Facturacion\workspace\facturaff
call mvn clean
call mvn compile
call mvn install

copy C:\openxava-7-r2-Facturacion\workspace\facturaff\target\*.war C:\WebJAQConsultor\apache-tomcat-9.0.71\webapps

CD C:\WebJAQConsultor\apache-tomcat-9.0.71\bin
CALL startup.bat
explorer "http://localhost:8581/facturaff"

