#¡/bin/bash

FIRST_STRAND_LENGTH=$(echo $1 | awk "{print length}")
SECOND_STRAND_LENGTH=$(echo $2 | awk "{print length}")

COUNTER=0

for ((c=0; c<FIRST_STRAND_LENGTH; c++)); do
  if [ ${1:c:1} != ${2:c:1} ]; then
    ((COUNTER++))
  fi
done

echo $COUNTER
