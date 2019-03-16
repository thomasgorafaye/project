-- Variables d'environnement de SQL*Plus de formatage de l'affichage
Set feedback off 
Set Linesize 200
Set Heading off 
Set Pagesize 0
Set Trimspool off 
Set Verify off

host echo &1

define repertoire=&1  --  répertoire de destination des fichiers sauvegardés 
define fichier_control=&1\control_backup.sql  -- définition du fichier de sortie

host echo &repertoire

exit