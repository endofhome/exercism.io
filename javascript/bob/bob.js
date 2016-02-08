var Bob = function() {};

Bob.prototype.hey = function(input) {
  switch(true) {
    case (input.toUpperCase() === input) && (input.toLowerCase() !== input):
      return 'Whoa, chill out!'; 
    case (input.charAt((input.length-1)) === '?'):
      return 'Sure.';
      case (/\S/.test(input) === false):
      return 'Fine. Be that way!';
    case (true):
      return 'Whatever.';
  };
};

module.exports = Bob;
