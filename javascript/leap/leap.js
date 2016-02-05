var Year = function(year) {
  this.testYear = year;
};

Year.prototype.isLeap = function() {
  var year = this.testYear;
  var isDivByFour = ((year % 4 === 0) ? true : false);
  var isNotDivByOneHundred = ((year % 100 !== 0) ? true : false);
  var isDivByFourHundred = ((year % 400 === 0 ? true : false));
  return (isDivByFour && isNotDivByOneHundred) || isDivByFourHundred; 
};

module.exports = Year;