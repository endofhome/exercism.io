var Pangram = function(string) {
  this.sentence = string;
};

Pangram.prototype.isPangram = function() {
  if (this.sentence === '') { 
    return false; 
  } else {
    return processString(this.sentence.toLowerCase());
  }
};           

var processString = function(string) {
  var alphabet = [('a' || 'ä'), 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                  'k', 'l', 'm', 'n', ('o' || 'ö'), 'p', 'q', 'r', ('s' || 'ß'), 't',
                  ('u' || 'ü'), 'v', 'w', 'x', 'y', 'z'],
      stringArray = string.trim().split(''),
      i,
      j;   
  for (i = 0; i < alphabet.length; i++) {
    for (j = 0; j < stringArray.length; j++) {
      if (alphabet[i] === stringArray[j]) {
        alphabet.splice(i, 1);
        i = (i-1);
      }
    }
  }
  return ((alphabet.length === 0) ? true : false);
};

module.exports = Pangram;