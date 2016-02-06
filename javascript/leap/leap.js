var Year = function(year) {
  this.testYear = year;
};

Year.prototype.isLeap = function() {
  var year = this.testYear;
  var isDivByFour = (year % 4 === 0);
  var isNotDivByOneHundred = (year % 100 !== 0);
  var isDivByFourHundred = (year % 400 === 0);
  return (isDivByFour && isNotDivByOneHundred) || isDivByFourHundred; 
};

module.exports = Year;