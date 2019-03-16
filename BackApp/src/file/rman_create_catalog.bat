create tablespace rman_ts_data datafile '/files1/RMAN/rman_ts_data01.dbf' size 50M ;
create user rman identified by rmanpwd  default tablespace RMAN_TS_DATA;
grant connect, resource, recovery_catalog_owner to rman;
host rman catalog rman/rmanpwd@orcl
create catalog tablespace rman_ts_data ;
exit
rman catalog rman/rmanpwd@aliascatalog target /
register database;