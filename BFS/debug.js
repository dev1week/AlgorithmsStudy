function sum(num) {
  let total = 0;
  for (let i = 0; i < num; i++) {
    total += i;
    printTotal(total);
  }
  return total;
}

function printTotal(num) {
  console.log("ddd");
}

const result = sum(2);
console.log(result);
