let person = {
  name: "kim",
  hello: function () {
    function printHello() {
      console.log(this);
      console.log(this.name);
    }
    setTimeout(printHello.bind(this), 1000);
  },
};
person.hello();

let btn = document.querySelector("button");
button.addEventListener("click", () => {
  console.log(this === window);
  this.innerHTML = "Clicked button";
});
