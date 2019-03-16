run {
allocate channel t1 type disk;
backup format '\\PC-THOMAS\applications/df_%d_%t_%s_%p' incremental level 1 database ;
sql 'alter system switch logfile';
backup format '\\PC-THOMAS\applications/al_%d_%t_%s_%p'
archivelog all delete input;
backup format '\\PC-THOMAS\applications/ctl_%d_%t_%s_%p' current controlfile;
}
