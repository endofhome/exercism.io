#!/bin/bash

args=$1
name=World

if [[ -n "$1" ]]; then
    name=${args}
fi

echo "Hello, ${name}!"
