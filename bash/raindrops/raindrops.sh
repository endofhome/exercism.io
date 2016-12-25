#!/bin/bash

if [ $((${1}%3)) -eq 0 ]; then
  echo "Pling"
elif [ $((${1}%5)) -eq 0 ]; then
  echo "Plang"
elif [ $((${1}%7)) -eq 0 ]; then
  echo "Plong"
else
  echo $1
fi
