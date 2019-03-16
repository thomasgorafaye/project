-- Variables d'environnement de SQL*Plus de formatage de l'affichage
Set feedback off 
Set Linesize 200
Set Heading off 
Set Pagesize 0
Set Trimspool off 
Set Verify off

define repertoire=&1  --  répertoire de destination des fichiers sauvegardés 
define fichier_control=&1\control_backup.sql  -- définition du fichier de sortie

spool &fichier_control

select 'host copy  ' || name ||  ' &repertoire ' from v$datafile order by 1 ;
select 'host copy  ' || member || ' &repertoire ' from v$logfile order by 1 ;
select 'host copy  ' || name  || ' &repertoire ' from v$controlfile order by 1 ;
select 'host copy  ' || name  || ' &repertoire ' from v$tempfile order by 1 ;

spool off 

-- Fermeture de la base de données pour avoir des fichiers synchronisés 
shutdown immediate 
@&fichier_control
startup
exit