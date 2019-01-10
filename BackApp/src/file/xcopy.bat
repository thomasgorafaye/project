::
:: OracleColdBackup.bat
::
:: This script is used to stop Oracle Instance and Services, copy the
:: files off to disk, and restart the database prior to tape backup
::
echo on
::
:: delete last night's copy
::
rmdir /s /Q d:\oracle\saves\c
rmdir /s /Q d:\oracle\saves\d
rmdir /s /Q d:\oracle\saves\e
::
:: stop listener service
::
net stop OracleOraDb10g_home1TNSListener
::
::  shutdown database
::
::
net stop OracleServiceORCL
::
::  wait 60 seconds
::
ping -n 60 127.0.0.1>nul
::
::  copy files
::
see code depot for full script
xcopy /c /f /e /y /k /o c:\oracle\oradata\* d:\oracle\saves\c\oracle\oradata\*
xcopy /c /f /e /y /k /o d:\oracle\oradata\* d:\oracle\saves\d\oracle\oradata\*
xcopy /c /f /e /y /k /o e:\oracle\oradata\* d:\oracle\saves\e\oracle\oradata\*
xcopy /c /f /e /y /k /o c:\oracle\admin\ORCL\* d:\oracle\saves\c\oracle\admin\ORCL\*
xcopy /c /f /e /y /k /o d:\oracle\10g\database\* d:\oracle\saves\d\oracle\10g\database\*
::
::  start database
::
::
net start OracleServiceORCL
::
:: wait 10 seconds
::
ping -n 10 127.0.0.1>nul
::
:: start Listener
::
net start OracleOraDb10g_home1TNSListener
::
:: done
::
exit