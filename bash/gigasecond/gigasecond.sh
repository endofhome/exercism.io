#!/bin/bash

ORIGIN=$1
SECONDS=$(date --date="${ORIGIN} 1000000000 seconds" '+%s')
RESULT=$(date -d "1970-01-01 UTC ${SECONDS} seconds" +'%a %b %e %H:%M:%S UTC %Y')
echo $RESULT