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
    // var fs = require('fs')
    // var path = require('path')
    //
    // fs.readdir(process.argv[2], function (err, list) {
    //   list.forEach(function (file) {
    //     if (path.extname(file) === '.' + process.argv[3])
    //       console.log(file)
    //   })
    // })
