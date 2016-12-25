#!/bin/bash

INPUT=$@

if [ "$INPUT" = "$(echo $INPUT | awk '{print toupper}')" ]; then
  if [ "$INPUT" != "$(echo $INPUT | awk '{print tolower}')" ]; then 
    echo "Whoa, chill out!"  
    exit 0
  fi
fi

if [ "${INPUT: -1}" = "?" ]; then
  echo "Sure."
  exit 0
fi

echo "Whatever."
