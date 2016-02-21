var PhoneNumber = function(phoneNumber) {
  this.phoneNumber = phoneNumber;
};

PhoneNumber.prototype.number = function() {
  var result = 0;
  result = this.phoneNumber.replace(/[() -.]/g, "");
  return result;
};

module.exports = PhoneNumber;
