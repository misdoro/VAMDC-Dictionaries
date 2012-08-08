#!/bin/bash

TYPE=$1
USAGE=$2

cp ${TYPE}_header._java $TYPE.java

#SQLITE to sphinx conversion for restrictables
sqlite3 -line -separator '@'  -nullvalue 'null' dict.sqlite "select bk.name, bk.sdescr, bk.ldescr, bk.unit, bk.type, bk.constr from \
keyword as bk,keyword_usage as bku \
where bk.id = bku.keyword_id and bku.usage_id=$USAGE order by bk.name;" |
sed -e 's/"/\\"/g' |
sed -e 's/^ *name = \(.*\)/\1(/g' |
sed -e 's/^ *sdescr = \(.*\)/"\1",/g' |
sed -e 's/^ *ldescr = \(.*\)/"\1",/g' |
sed -e 's/^ *unit = \(.*\)/"\1",/g' |
sed -e 's/^ *type = \(.*\)/"\1",/g' |
sed -e 's/^ *constr = \(.*\)/"\1"),/g' |
sed -e 's/"\."/""/g'|
sed ':a;N;$!ba;s/[\n\x0A\x0D]/ /g' |
sed -e 's/"),/"),\n/g' |
sed -e 's/"null"/""/g' >> $TYPE.java

cat ${TYPE}_footer._java >>  $TYPE.java


