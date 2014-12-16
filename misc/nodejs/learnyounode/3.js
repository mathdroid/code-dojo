var fs = require('fs');
var number = 0;
var reading = fs.readFileSync(process.argv[2]).toString().split('\n');
console.log(reading.length - 1);
