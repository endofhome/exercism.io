#!/bin/bash

ORIGIN_SECONDS=$(date --date="$1 1000000000 seconds" '+%s')
RESULT=$(date -d "1970-01-01 UTC ${ORIGIN_SECONDS} seconds" +'%a %b %e %H:%M:%S UTC %Y')
echo $RESULT
