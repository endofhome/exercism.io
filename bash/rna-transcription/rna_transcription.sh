#!/bin/bash

map() { local map=`echo "$*" | cksum`; echo "${map//[!0-9]}"; }

DNA_RNA[`map G`]="C"
DNA_RNA[`map C`]="G"
DNA_RNA[`map T`]="A"
DNA_RNA[`map A`]="U"

INPUT_LENGTH=$(echo $1 | awk "{print length}")

for ((i=0; i<INPUT_LENGTH; i++)); do
  char=${1:i:1}
  LOOKUP=${DNA_RNA[`map $char`]}
  if [ -z $LOOKUP ]; then
    echo "Invalid nucleotide detected."
    exit 1
  else
    OUTPUT+=$LOOKUP
  fi
done

echo $OUTPUT
