function isPrime(num) {
    if (num < 2) { //1 is not prime number
        return false;
    } //if end
    for (var i = 2; i <= num; i++) { //deciding prime number or not
        if (num % i === 0 && num !== i) {
            return false;
        }
    }
    return true;
} //isPrime end

function Prime() { //implement logical and conditional statements
    document.getElementById('printhere').innerHTML = "";
    var lower = prompt("Please enter the lower range of the Prime Generator");
    var upper = prompt("Please enter the upper range of the Prime Generator");
    lower = Number(lower);
    upper = Number(upper);
    document.getElementById('printhere').innerHTML += `Generate prime number between ${lower} and ${upper}<br>`;
   
    var primes = [];

    for (var m = lower; m <= upper; m++) {
        if (isPrime(m)) { //if return true
            primes.push(m);
        } //if end
    } //for end

    for (var d = 0; d < primes.length; d++) {
        document.getElementById('printhere').innerHTML += `Prime Number: ${primes[d]}<br>`;
    } //for end              
} //prime end

