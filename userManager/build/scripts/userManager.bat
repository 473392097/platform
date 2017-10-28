@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  userManager startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and USER_MANAGER_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\t-digest-3.0.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-1.5.3.RELEASE.jar;%APP_HOME%\lib\netty-codec-http-4.1.5.Final.jar;%APP_HOME%\lib\joda-convert-1.2.jar;%APP_HOME%\lib\userManager-1.0-SNAPSHOT.jar;%APP_HOME%\lib\poi-scratchpad-3.16.jar;%APP_HOME%\lib\stax-api-1.0.1.jar;%APP_HOME%\lib\HdrHistogram-2.1.6.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.25.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\logback-classic-1.1.11.jar;%APP_HOME%\lib\mybatis-3.4.5.jar;%APP_HOME%\lib\lang-mustache-client-5.0.0.jar;%APP_HOME%\lib\spring-tx-4.3.10.RELEASE.jar;%APP_HOME%\lib\jackson-core-asl-1.9.13.jar;%APP_HOME%\lib\netty-3.10.6.Final.jar;%APP_HOME%\lib\percolator-client-5.0.0.jar;%APP_HOME%\lib\spring-boot-starter-web-1.5.3.RELEASE.jar;%APP_HOME%\lib\commons-codec-1.10.jar;%APP_HOME%\lib\poi-3.16.jar;%APP_HOME%\lib\reindex-client-5.0.0.jar;%APP_HOME%\lib\lucene-core-6.2.0.jar;%APP_HOME%\lib\jackson-core-2.8.8.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\pinyin4j-2.5.1.jar;%APP_HOME%\lib\securesm-1.1.jar;%APP_HOME%\lib\lucene-backward-codecs-6.2.0.jar;%APP_HOME%\lib\jackson-databind-2.8.8.jar;%APP_HOME%\lib\httpcore-nio-4.4.5.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.25.jar;%APP_HOME%\lib\jackson-dataformat-cbor-2.8.1.jar;%APP_HOME%\lib\joda-time-2.9.4.jar;%APP_HOME%\lib\smart-spring-boot-web-1.1.8-SNAPSHOT.jar;%APP_HOME%\lib\jopt-simple-5.0.2.jar;%APP_HOME%\lib\lucene-grouping-6.2.0.jar;%APP_HOME%\lib\elasticsearch-5.0.0.jar;%APP_HOME%\lib\jodd-core-3.6.7.jar;%APP_HOME%\lib\lucene-suggest-6.2.0.jar;%APP_HOME%\lib\netty-common-4.1.5.Final.jar;%APP_HOME%\lib\spring-boot-starter-1.5.6.RELEASE.jar;%APP_HOME%\lib\spring-context-4.3.10.RELEASE.jar;%APP_HOME%\lib\tomcat-embed-websocket-8.5.14.jar;%APP_HOME%\lib\rest-5.0.0.jar;%APP_HOME%\lib\lucene-spatial3d-6.2.0.jar;%APP_HOME%\lib\mail-1.4.5.jar;%APP_HOME%\lib\spring-webmvc-4.3.8.RELEASE.jar;%APP_HOME%\lib\spring-core-4.3.10.RELEASE.jar;%APP_HOME%\lib\lucene-sandbox-6.2.0.jar;%APP_HOME%\lib\netty-resolver-4.1.5.Final.jar;%APP_HOME%\lib\transport-5.0.0.jar;%APP_HOME%\lib\xmlbeans-2.6.0.jar;%APP_HOME%\lib\mybatis-spring-boot-autoconfigure-1.3.1.jar;%APP_HOME%\lib\spring-jdbc-4.3.10.RELEASE.jar;%APP_HOME%\lib\httpclient-4.5.2.jar;%APP_HOME%\lib\lucene-analyzers-common-6.2.0.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-1.5.6.RELEASE.jar;%APP_HOME%\lib\commons-lang3-3.6.jar;%APP_HOME%\lib\logback-core-1.1.11.jar;%APP_HOME%\lib\activation-1.1.1.jar;%APP_HOME%\lib\poi-ooxml-schemas-3.16.jar;%APP_HOME%\lib\lucene-spatial-extras-6.2.0.jar;%APP_HOME%\lib\netty-buffer-4.1.5.Final.jar;%APP_HOME%\lib\spring-boot-starter-logging-1.5.6.RELEASE.jar;%APP_HOME%\lib\httpasyncclient-4.1.2.jar;%APP_HOME%\lib\classmate-1.3.1.jar;%APP_HOME%\lib\snakeyaml-1.17.jar;%APP_HOME%\lib\spring-aop-4.3.10.RELEASE.jar;%APP_HOME%\lib\spring-web-4.3.8.RELEASE.jar;%APP_HOME%\lib\hibernate-validator-5.3.5.Final.jar;%APP_HOME%\lib\netty-handler-4.1.5.Final.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.25.jar;%APP_HOME%\lib\spring-expression-4.3.10.RELEASE.jar;%APP_HOME%\lib\tomcat-juli-8.5.16.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\jedis-2.9.0.jar;%APP_HOME%\lib\mybatis-spring-boot-starter-1.3.1.jar;%APP_HOME%\lib\lucene-spatial-6.2.0.jar;%APP_HOME%\lib\jna-4.2.2.jar;%APP_HOME%\lib\tomcat-jdbc-8.5.16.jar;%APP_HOME%\lib\spring-boot-1.5.6.RELEASE.jar;%APP_HOME%\lib\mybatis-spring-1.3.1.jar;%APP_HOME%\lib\jodd-upload-3.6.7.jar;%APP_HOME%\lib\curvesapi-1.04.jar;%APP_HOME%\lib\spring-beans-4.3.10.RELEASE.jar;%APP_HOME%\lib\httpcore-4.4.5.jar;%APP_HOME%\lib\lucene-memory-6.2.0.jar;%APP_HOME%\lib\poi-ooxml-3.16.jar;%APP_HOME%\lib\commons-pool2-2.4.2.jar;%APP_HOME%\lib\gson-2.8.0.jar;%APP_HOME%\lib\im4java-1.4.0.jar;%APP_HOME%\lib\transport-netty3-client-5.0.0.jar;%APP_HOME%\lib\jodd-mail-3.6.7.jar;%APP_HOME%\lib\lucene-queryparser-6.2.0.jar;%APP_HOME%\lib\tomcat-embed-core-8.5.14.jar;%APP_HOME%\lib\tomcat-embed-el-8.5.14.jar;%APP_HOME%\lib\netty-codec-4.1.5.Final.jar;%APP_HOME%\lib\log4j-api-2.8.2.jar;%APP_HOME%\lib\mysql-connector-java-5.1.44.jar;%APP_HOME%\lib\lucene-misc-6.2.0.jar;%APP_HOME%\lib\log4j-core-2.8.2.jar;%APP_HOME%\lib\transport-netty4-client-5.0.0.jar;%APP_HOME%\lib\jodd-http-3.6.7.jar;%APP_HOME%\lib\jackson-dataformat-smile-2.8.1.jar;%APP_HOME%\lib\compiler-0.9.3.jar;%APP_HOME%\lib\commons-collections4-4.1.jar;%APP_HOME%\lib\lucene-join-6.2.0.jar;%APP_HOME%\lib\spring-boot-autoconfigure-1.5.6.RELEASE.jar;%APP_HOME%\lib\netty-transport-4.1.5.Final.jar;%APP_HOME%\lib\jackson-annotations-2.8.0.jar;%APP_HOME%\lib\jboss-logging-3.3.0.Final.jar;%APP_HOME%\lib\fastjson-1.2.39.jar;%APP_HOME%\lib\lucene-queries-6.2.0.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.8.1.jar;%APP_HOME%\lib\commons-io-2.4.jar;%APP_HOME%\lib\lucene-highlighter-6.2.0.jar;%APP_HOME%\lib\jackson-mapper-asl-1.9.13.jar;%APP_HOME%\lib\hppc-0.7.1.jar

@rem Execute userManager
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %USER_MANAGER_OPTS%  -classpath "%CLASSPATH%" com.sudao.cloud.component.user.manager.Boot %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable USER_MANAGER_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%USER_MANAGER_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
