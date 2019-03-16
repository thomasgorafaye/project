--export full des données

C:\> exp userid=system/manager file=c:\backup\export_full.dump 
log=c:\control\export_full.log full=y rows=n 

--export du schéma scott

C:\> exp userid=system/manager file=c:\backup\export_full.dump 
log=c:\control\export_full.log owner=scott

--export de la table ACCOUNT de SCOOT

C:\> exp userid=system/manager file=c:\backup\export_full.dump 
log=c:\control\export_full.log tables=scott.account 

--export du tablespace userid

C:\> exp userid=system/manager file=c:\backup\export_full.dump 
log=c:\control\export_full.log tablespaces=user

exp parfile=c:\backup\parfile.prm