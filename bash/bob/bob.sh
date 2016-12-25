#!/bin/bash

INPUT=$@

if [ "$INPUT" = "$(echo $INPUT | awk '{print toupper}')" ]; then
  echo "Whoa, chill out!"  
else
  echo "Whatever."
fi
