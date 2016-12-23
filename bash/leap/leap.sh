#!/bin/bash

INPUT=$1
RESULT="This is not a leap year."

if [ $((${INPUT}%4)) -eq 0 ]; then
  if [ $((${INPUT}%100)) -ne 0 ]; then
    RESULT="This is a leap year."
  else 
    if [ $((${INPUT}%400)) -eq 0 ]; then
      RESULT="This is a leap year."
    fi
  fi
fi

echo $RESULT
