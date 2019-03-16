SET feedback off pagesize 0 heading off verify off linesize 100 trimspool on
DEFINE repertoire = &1
DEFINE fichier = &1\controlfile.sql
DEFINE spool = &2\log_&3.txt
SPOOL &fichier
PROMPT spool &spool  ;;
PROMPT archive log list ;;
PROMPT alter system switch logfile ;;
SELECT 'alter tablespace ' || tablespace_name || ' begin backup  ; '
  FROM dba_tablespaces
 WHERE status NOT IN ('READ ONLY', 'INVALID', 'OFFLINE');
SELECT 'host copy ' || file_name || ' &repertoire '
  FROM dba_data_files
 WHERE tablespace_name NOT IN (
                           SELECT tablespace_name
                             FROM dba_tablespaces
                            WHERE status IN
                                          ('READ ONLY', 'INVALID', 'OFFLINE'));
SELECT 'alter tablespace ' || tablespace_name || ' end backup  ; '
  FROM dba_tablespaces
 WHERE status NOT IN ('READ ONLY', 'INVALID', 'OFFLINE');
PROMPT alter database backup controlfile to '&repertoire\control.ctl' REUSE ;;
PROMPT alter system switch logfile ;;
PROMPT archive log list ;;
PROMPT spool off ;;
SPOOL off;
@&fichier
exit