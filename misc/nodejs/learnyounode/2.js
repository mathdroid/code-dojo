var limit = process.argv.length;
var total = 0;
for (var i = 2; i<limit;i++) {
  total += Number(process.argv[i]);
}
console.log(total);
