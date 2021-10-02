function Palindrome() {
    var str = prompt("Please enter a string to check whether it is a Palindrome");
    const len = str.length;

    for (let i = 0; i <= len / 2; i++) {
        if (str[i] == str[len - 1 - i]) {
            document.getElementById('printhere').innerHTML = "<br>" + "<br>" + str + ": Palindrome -> true\n" + "<br>" + "<br>" + "<br>";
        }//if end
    } //for end
    for (let i = 0; i <= len / 2; i++) {
        if (str[i] != str[len - 1 - i]) {
            document.getElementById('printhere').innerHTML = "<br>" + "<br>" + str + ": Palindrome -> false\n" + "<br>" + "<br>" + "<br>";
        } //if end
    } //convertLength end
} //Palindrome end