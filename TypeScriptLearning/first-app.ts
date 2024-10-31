let userName:string = "John";

console.log(userName);
//1 Types number, string and boolean ,object
//2 When a variable is required to have two types, we use Union Types
let userId: string | number = "abxd";
// userId = true; //gives error
let user:{
    id:number;
    name:string;
    isAdultL: boolean;
};
let hobbies:Array<string>; // similar to let hobbies: string[];
hobbies=["play", "sing",""];

function add(a:number, b:number) : number{
    const res = a+b;
    console.log(res);
    return res;
}
function calculate(a:number,b:number, 
    add:(a:number,b:number)=> number) : number{
        return a+b+add(a,b);
}
calculate(2,5,add)

type AddFn = (a:number,b:number)=> number;
function calculate1(a:number,b:number, 
    add: AddFn) : number{
        return a+b+add(a,b);
}