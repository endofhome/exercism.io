var Year = function(year) {
  this.testYear = year;
};

Year.prototype.isLeap = function() {
  var year = this.testYear,
      isDivByFour = (year % 4 === 0),
      isNotDivByOneHundred = (year % 100 !== 0),
      isDivByFourHundred = (year % 400 === 0);
  return (isDivByFour && isNotDivByOneHundred) || isDivByFourHundred; 
};

module.exports = Year;