#!/bin/bash

name=$1
if [[ -n "$name" ]]; then
    echo "Hello, ${name}!"
else
    echo "Hello, World!"
fi