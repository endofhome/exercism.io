#!/bin/bash

INPUT=$@

if [ "$INPUT" = "$(echo $INPUT | awk '{print toupper}')" ]; then
  echo "Whoa, chill out!"  
  exit 0
fi

if [ "${INPUT: -1}" = "?" ]; then
  echo "Sure."
  exit 0
fi

echo "Whatever."

