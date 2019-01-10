--------CUT-----------------------------CUT---------------------

REM backup.bat
REM this is a DOS batch script
REM to take a full cold backup
REM copyright 2002-2004 N Roshak

REM requires two sql scripts in addition to the above sql script:
REM shutdown.sql (connect / as sysdba, shutdown transactional, exit)
REM startup.sql (connect / as sysdba, startup open, exit)

set oracle_home=d:\oracle\ora92
set script_dir=c:\scripts\orabackup\DB
set shutdown=%script_dir%\shutdown.sql
set startup=%script_dir%\startup.sql
set scriptgen=%script_dir%\make_cold_backup_scr.sql
set log=%script_dir%\backup.log

echo >> %log%
echo ----------BEGIN FULL COLD BACKUP OF DB---------- >> %log%
date /T >> %log%
time /T >> %log%
echo Generating cold backup script... >> %log%
%oracle_home%\bin\sqlplus /nolog @%scriptgen%

date /T >> %log%
time /T >> %log%
echo Shutting down... >> %log%

%oracle_home%\bin\sqlplus /nolog @%shutdown%

echo Backing up... >> %log%
call %SCRIPT_DIR%\cold_Backup.bat >> %log% 2>&1

echo Starting up... >> %log%
%oracle_home%\bin\sqlplus /nolog @%startup%

date /T >> %log%
time /T >> %log%
echo Succesfully completed. >> %log%
echo -----------END FULL COLD BACKUP OF DB----------- >> %log%

--------CUT-----------------------------CUT---------------------