run {
allocate channel t1 type disk;
backup format '%d_repertory%/df_%d_%t_%s_%p' %strategy% %object% %name%;
sql 'alter system switch logfile';
backup format '%d_repertory%/al_%d_%t_%s_%p'
archivelog all delete input;
backup format '%d_repertory%/ctl_%d_%t_%s_%p' current controlfile;
}