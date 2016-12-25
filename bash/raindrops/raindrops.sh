#!/bin/bash

if [ $((${1}%3)) -eq 0 ]; then
  OUTPUT+="Pling"
fi

if [ $((${1}%5)) -eq 0 ]; then
  OUTPUT+="Plang"
fi

if [ $((${1}%7)) -eq 0 ]; then
  OUTPUT+="Plong"
fi

if [ -z $OUTPUT ]; then
  echo $1
  exit 0
fi

echo $OUTPUT
