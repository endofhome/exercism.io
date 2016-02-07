var Hamming = function() {};

Hamming.prototype.compute = function(a, b) {
  var hammingDistance = 0;
  var i;
  if (a.length !== b.length) { throw new Error ('DNA strands must be of equal length.'); }
  for (i = 0; i < a.length; i++) {
    if (a[i] !== b[i]) { hammingDistance++; }
  }
  return hammingDistance;
};

module.exports = Hamming;
