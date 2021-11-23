const {a} = require("./page");

console.log(a);

console.log("====second2 refresh");


if(module.hot){
    module.hot.accept("./page.js",(...a)=>{
        console.log("====render",a);
    })
}