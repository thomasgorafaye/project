IF %type% ==froid (
IF %dbuser% ==system (
sqlplus %dbuser%/%dbpassword% as sysdba @cold.bat %d_repertory%
)ELSE (
IF %dbuser% ==sys (
sqlplus %dbuser%/%dbpassword% as sysdba @cold.bat %d_repertory%
)ELSE (
sqlplus %dbuser%/%dbpassword% @cold.bat %d_repertory%
)
)
)ELSE (
IF %dbuser% ==system (
sqlplus %dbuser%/%dbpassword% as sysdba @hot.bat %d_repertory% %log% %timestamp%
)ELSE (
IF %dbuser% ==sys (
sqlplus %dbuser%/%dbpassword% as sysdba @hot.bat %d_repertory% %log% %timestamp%
)ELSE (
sqlplus %dbuser%/%dbpassword% @hot.bat %d_repertory% %log% %timestamp%
)
)
)
exit