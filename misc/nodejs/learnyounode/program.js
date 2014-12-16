var fs = require('fs');
var path = process.argv[2];
var ext = process.argv[3];
fs.readdir(path, exFive);
function exFive(error,reading) {
  if (error) {
  return console.error(error);
}
  var filtered = reading.filter(function checkExt (files) {
    return (files.length>ext.length +1)&&(files.split('.')[files.split('.').length-1]===ext);
  });
  for (var i = 0; i < filtered.length; i++) {
    console.log(filtered[i]);
  }
}
