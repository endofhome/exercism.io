#!/bin/bash

map() { local map=`echo "$*" | cksum`; echo "${map//[!0-9]}"; }

DNA_RNA[`map G`]="C"
DNA_RNA[`map C`]="G"
DNA_RNA[`map T`]="A"
DNA_RNA[`map A`]="U"

echo ${DNA_RNA[`map $1`]}
