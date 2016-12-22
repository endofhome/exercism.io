#!/bin/bash

INPUT=$1
if [ $((${INPUT}%4)) -eq 0 ] && [ $((${INPUT}%100)) -ne 0 ]; then
  echo "This is a leap year."
else
  echo "This is not a leap year."
fi
