var Gigasecond = function(input) {
  this.startDate = input;
};

Gigasecond.prototype.date = function() {
  return (new Date((Date.parse(this.startDate) + 1e12)));
};

module.exports = Gigasecond;
