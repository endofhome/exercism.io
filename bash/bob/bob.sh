#!/bin/bash

INPUT=$@
INPUT_NO_WHITESPACE=$(echo $@ | tr -d [:space:])

if [ -z "$INPUT_NO_WHITESPACE" ]; then
  echo "Fine. Be that way!"
  exit 0
fi

if [ "$INPUT" = "$(echo $INPUT | tr [:lower:] [:upper:])" ]; then
  if [ "$INPUT" != "$(echo $INPUT | tr [:upper:] [:lower:])" ]; then 
    echo "Whoa, chill out!"  
    exit 0
  fi
fi

if [ "${INPUT: -1}" = "?" ]; then
  echo "Sure."
  exit 0
fi

echo "Whatever."
