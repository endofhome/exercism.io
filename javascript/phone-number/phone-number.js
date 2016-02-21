var PhoneNumber = function(phoneNumber) {
  this.phoneNumber = phoneNumber;
};

PhoneNumber.prototype.number = function() {
  var result = 0,
      num = this.phoneNumber;
  result = num.replace(/[() -.]/g, "");
  if ((result.length === 11) && (result.charAt(0) === '1')) {
  result = result.substr(1);
  }
  return result;
};

module.exports = PhoneNumber;
