var PhoneNumber = function(phoneNumber) {
  this.phoneNumber = phoneNumber;
};

PhoneNumber.prototype.number = function() {
  var result = 0,
      num = this.phoneNumber;
  result = num.replace(/[() -.]/g, "");
  if (result.length !== 10) { 
    if ((result.length === 11) && (result.charAt(0)) === '1') {
      result = result.substr(1);
    } else {
      result = '0000000000';
    }
  }
  return result;
};

PhoneNumber.prototype.areaCode = function() {
  return this.phoneNumber.slice(0,3);
};

module.exports = PhoneNumber;
