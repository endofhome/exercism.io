#!/usr/bin/env bats

@test 'Complement of cytosine is guanine' {
  run bash rna_transcription.sh C

  [ "$status" -eq 0 ]
  [ "$output" == 'G' ]
}

@test 'Complement of guanine is cytosine' {
  run bash rna_transcription.sh G
  
  skip
  [ "$status" -eq 0 ]
  [ "$output" == 'C' ]
}

@test 'Complement of thymine is adenine' {
  run bash rna_transcription.sh T

  skip
  [ "$status" -eq 0 ]
  [ "$output" == 'A' ]
}

@test 'Complement of adenine is uracil' {
  run bash rna_transcription.sh A

  skip
  [ "$status" -eq 0 ]
  [ "$output" == 'U' ]
}

@test 'Complement of long string' {
  run bash rna_transcription.sh ACGTGGTCTTAA

  skip
  [ "$status" -eq 0 ]
  [ "$output" == 'UGCACCAGAAUU' ]
}

@test 'Handles invalid character' {
  run bash rna_transcription.sh U

  skip
  [ "$status" -eq 1 ]
  [ "$output" == 'Invalid nucleotide detected.' ]
}

@test 'Handles completely invalid string' {
  run bash rna_transcription.sh XXXX

  skip
  [ "$status" -eq 1 ]
  [ "$output" == 'Invalid nucleotide detected.' ]
}

@test 'Handles partially invalid string' {
  run bash rna_transcription.sh ACGTXCTTAA

  skip
  [ "$status" -eq 1 ]
  [ "$output" == 'Invalid nucleotide detected.' ]
}
