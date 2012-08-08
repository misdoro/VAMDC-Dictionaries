#!/bin/bash
wget http://dictionary.vamdc.org/dict.sqlite  -q -O dict.sqlite

./generate.sh Restrictable 1

./generate.sh Requestable 3

cp *.java ../main/java/org/vamdc/dictionary/

