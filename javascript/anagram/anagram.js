var Anagram = function(string) {
  this.string = string;
};

Anagram.prototype.matches = function(testArray) {
  var result = [],
      i,
      j;
  for (i = 0; i < testArray.length; i++) {
    for (j = 0; j < testArray[i].length; j++) {
      var found = true;
      if (this.string.indexOf(testArray[i].charAt(j)) === -1) {
	found = false;
	break;
      };
    }
    if (j === (testArray[i].length -1) && (found === true)) {
      result.push(testArray[i]);
    };
  }
  return result;
};

module.exports = Anagram;
