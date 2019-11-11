@echo off
@if not "%ECHO%" == ""  echo %ECHO%
@if "%OS%" == "Windows_NT"  setlocal

set APP_BOOT=target-calculate-service
set APP_VERSION=1.0.0
Title %APP_BOOT% v%APP_VERSION%

set ENV_PATH=.\
if "%OS%" == "Windows_NT" set ENV_PATH=%~dp0%

set conf_dir=%ENV_PATH%\..\config

set ENV_ACTIVE=%1
if "%ENV_ACTIVE%"=="" set ENV_ACTIVE=pro

set CONF="%conf_dir%\application.properties"
set LOGF="%conf_dir%\log4j2.properties"
set APP_NAME=${APP_BOOT}-${ENV_ACTIVE}

set CLASSPATH=%conf_dir%
set CLASSPATH=%conf_dir%\..\lib\*;%CLASSPATH%;%ENV_PATH%\..\%APP_BOOT%-%APP_VERSION%.jar

set JAVA_MEM_OPTS= -Xms128m -Xmx512m -XX:PermSize=128m
set JAVA_OPTS_EXT= -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -Dapplication.codeset=UTF-8 -Dfile.encoding=UTF-8
set JAVA_DEBUG_OPT= -server -Xdebug -Xnoagent -Djava.compiler=NONE
set APP_OPTS= -Dspring.config.location="%CONF%" -DappName=%APP_NAME% -Dlog4j.configurationFile=%LOGF%

set JAVA_OPTS= %JAVA_MEM_OPTS% %JAVA_OPTS_EXT% %JAVA_DEBUG_OPT% %APP_OPTS%

set CMD_STR= java %JAVA_OPTS% -classpath "%CLASSPATH%" -jar %ENV_PATH%\..\%APP_BOOT%-%APP_VERSION%.jar
echo start cmd : %CMD_STR%

java %JAVA_OPTS% -classpath "%CLASSPATH%" -jar %ENV_PATH%\..\%APP_BOOT%-%APP_VERSION%.jar