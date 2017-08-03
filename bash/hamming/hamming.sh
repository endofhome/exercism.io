#!/bin/bash

FIRST_STRAND_LENGTH=${#1}
SECOND_STRAND_LENGTH=${#2}

if [ $# -eq 0 ]; then
  echo "Usage: hamming.sh <string1> <string2>"
  exit 1
elif [ $FIRST_STRAND_LENGTH -ne $SECOND_STRAND_LENGTH ]; then
  echo "The two strands must have the same length."
  exit 1
fi

COUNTER=0

for ((c=0; c<FIRST_STRAND_LENGTH; c++)); do
  if [ ${1:c:1} != ${2:c:1} ]; then
    ((COUNTER++))
  fi
done

echo $COUNTER
