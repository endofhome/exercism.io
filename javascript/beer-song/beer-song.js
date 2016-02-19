var BeerSong = function() {
};

BeerSong.prototype.verse = function(integer) {
  var i = integer;

  var capitalise = function(string) { 
    return string.charAt(0).toUpperCase() + string.slice(1); 
  };

  var plural = function(integer) {
    var result = 's';
    if (integer === 1) { 
      result = '';
    }
    return result;
  };

  var noMore = function(integer, oneLess) {
    var result = integer,
        oneLess = oneLess || false;
    if (oneLess === true) { 
      result = integer -1;
    }
    if (result === 0) {
      result = 'no more';
    }
    return result;
  };

  var it = function(integer) {
    var result = 'one';
    if (integer === 1) {
      result = 'it';
    }
    return result;
  };

  var lineOne = function(integer) {
    var i = integer;
    return noMore(i) + ' bottle' + plural(i) + ' of beer on the wall, ' + noMore(i) + ' bottle' + plural(i) + ' of beer.';
  };
 
  var lineTwo = function(integer) {
    var result = '',
        i = integer,
        ending = ' bottle' + plural(noMore(i-1)) + ' of beer on the wall.\n';
    if (integer > 0) {
      result = 'Take ' + it(i) + ' down and pass it around, ' + noMore(i, true);
    } else {
      result = 'Go to the store and buy some more, 99';
    }
    return result + ending;
  };

  return capitalise(lineOne(i)) + '\n' + lineTwo(i);
};

BeerSong.prototype.sing = function(startVerse, endVerse) {
  endVerse = endVerse || 0;
  var repeats = (startVerse - endVerse),
      results = '',
      i;
  for (i = 0; i <= repeats; i++) {
    results = results + this.verse(startVerse -i);
    if (i === repeats) { break; }
    results = results + '\n';
  }
  return results;
};

module.exports = BeerSong;