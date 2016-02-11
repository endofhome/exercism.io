var DnaTranscriber = function() {
  this.mapDnaToRna = {'G':'C', 'C':'G', 'T':'A', 'A':'U'};
};

DnaTranscriber.prototype.toRna = function(dna) {
  var rna = new String(),
      i;
  for (i = 0; i < dna.length; i++) {
    rna = rna.concat(this.mapDnaToRna[dna[i]]);
  };
  return rna;
};

module.exports = DnaTranscriber;
