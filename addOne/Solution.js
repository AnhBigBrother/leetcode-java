/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. 
The digits are ordered from most significant to least significant in left-to-right order. 
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
*/

/**
 * @param {number[]} digits
 * @return {number[]}
 */

function plusOne(digits) {
    let n = digits.length;
    let rem = 1;
    for (let i=n-1; i>=0; i--){
        if (i !== n-1 && rem === 0){
            return digits;
        }
        let x = digits[i] + rem;
        if (x == 10){
            rem = 1;
            digits[i] = 0
        }
        else{
            digits[i] = x;
            rem = 0;
        }
    }
    if (rem === 1){
        digits = [1,...digits];
    }
    return digits;
};

let digits= [1,9,9,9,9];
digits = plusOne(digits);
console.log(digits);