var fs = require('fs');

function finishedReading (error, reading) {
  if (error) {
    return console.error(error);
  }
  return console.log(reading.split('\n').length - 1);
}


fs.readFile(process.argv[2], 'utf8', finishedReading);
