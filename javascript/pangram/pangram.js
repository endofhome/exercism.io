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
  var alphabet = [('a'), 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                  'k', 'l', 'm', 'n', ('o'), 'p', 'q', 'r', ('s'), 't',
                  ('u'), 'v', 'w', 'x', 'y', 'z'],
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
  return (alphabet.length === 0);
};

module.exports = Pangram;