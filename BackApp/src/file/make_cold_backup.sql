--------CUT-----------------------------CUT---------------------

REM make_cold_backup.sql
REM copyright 2001-2004 N Roshak
REM this is a sql script to generate a DOS backup script

connect %dbuser%/%dbpassword%
set heading off
set pagesize 0
set echo off
set feedback off
set verify off
set linesize 500
col mything for a500
spool cold_backup.bat
prompt REM Script to take full cold database backup
prompt REM generated by make_cold_backup_scr.sql
prompt REM does not back up tempfiles
prompt REM
prompt set oracle_home=%s_repertory%
prompt set backup_dir=%d_repertory%
select distinct 'copy ' || leaf
|| ' %backup_dir%' || substr(leaf,instr(leaf,'\',-1,1), length(leaf))
as  cmdstr
from
(select name as LEAF from v$datafile
union
select name from v$controlfile
union
select member from v$logfile)
/
prompt REM Copy init.ora and pwd files
prompt copy %oracle_home%\database\initDB.ora %backup_dir%\initDB.ora
prompt copy %oracle_home%\database\pwdDB.ora %backup_dir%\pwdDB.ora
spool off
exit

--------CUT-----------------------------CUT---------------------