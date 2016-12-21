#!/bin/bash

ORIGIN=$1
SECONDS=$(gdate --date="${ORIGIN} 1000000000 seconds" '+%s')
RESULT=$(gdate -d "1970-01-01 UTC ${SECONDS} seconds" +'%a %b %e %H:%M:%S UTC %Y')
echo $RESULT