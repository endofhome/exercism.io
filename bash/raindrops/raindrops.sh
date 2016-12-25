#!/bin/bash

if [ $((${1}%3)) -eq 0 ]; then
  echo "Pling"
else
  echo $1
fi
