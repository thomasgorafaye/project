IF %object% ==database (
SET object=full
SET name=y 
)
IF %dbuser% ==system (
exp userid=\"%dbuser%/%dbpassword%@%sid% as sysdba\" file=%d_repertory%\export_full_%timestamp%.dump log=%log%\export_full_%timestamp%.log %object%=%name% rows=n 
)ELSE (
IF %dbuser% ==sys (
exp userid=\"%dbuser%/%dbpassword%@%sid% as sysdba\" file=%d_repertory%\export_full_%timestamp%.dump log=%log%\export_full_%timestamp%.log %object%=%name% rows=n 
)ELSE (
exp userid=\"%dbuser%/%dbpassword%@%sid%\" file=%d_repertory%\export_full_%timestamp%.dump log=%log%\export_full_%timestamp%.log %object%=%name% rows=n 
)
)