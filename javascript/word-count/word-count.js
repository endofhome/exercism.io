var Words = function() {};

Words.prototype.count = function(string) {
  return convertToHash(convertToArray(string));
};
  
var convertToArray = function(string) {
  var array = [];
  array = string.trim().split(/\s+/);
  return array;
};

var convertToHash = function(array) {
  var hash = Object.create(null);
  for (i = 0; i < array.length; i++) {
    var word = array[i];
    if (!hash[word]) {
      hash[word] = 1;
    } else {
      hash[word]++;
    }
  }
  return hash;
};

module.exports = Words;