function Pattern() { //implement logical and conditional statements
    document.getElementById('printhere').innerHTML = "&nbsp";
    var pattern = prompt("Please select the pattern you want to draw \n(1:Triangle, 2:Diamond, 3:Hollow-Rectangle)", "");
    var size = prompt("Please enter the size of the triangle", "");
    size = Number(size); //change to number

    if (pattern == "1") { //Triangle
        document.getElementById('printhere').innerHTML += "Make Triange with size: " + size + "<br>";
        triangle(size);
    } else if (pattern == "2") { //Diamond
        document.getElementById('printhere').innerHTML += "Make Diamond with size: " + size + "<br>";
        diamond(size);
    } else if (pattern == "3") { //hollow-rectangle
        document.getElementById('printhere').innerHTML += "Make Hollow-rectangle with size: " + size + "<br>";
        hollow(size);
    } //else-if end
} //Pattern end

function triangle(size) {
    for (var i = 0; i < size; i++) {
        for (var j = 0; j <= i; j++) {
            document.getElementById('printhere').innerHTML += "*";
        }
        document.getElementById('printhere').innerHTML += "<br>";
    } //for end
} //triangle end

function diamond(size) {
    triangle(size / 2);
    for (var j = 0; j <= size / 2; j++) {
        for (var b = ((size / 2) - j - 1); b > 0; b--) {
            document.getElementById('printhere').innerHTML += "*";
        } //for end
        document.getElementById('printhere').innerHTML += "<br>";
    } //for end
} //diamond end

function hollow(size) {
    for (var i = 0; i < size; i++) {
        if (i == 0 || i == (size - 1)) { //first and last line
            for (var a = 0; a < size; a++) {
                document.getElementById('printhere').innerHTML += "*";
            }
            document.getElementById('printhere').innerHTML += "<br>";
        } else {
            for (var b = 0; b < size; b++) {
                if (b == 0 || b == (size - 1)) {
                    document.getElementById('printhere').innerHTML += "*";
                } else {
                    document.getElementById('printhere').innerHTML += "_";
                } //if-else end
            } //for end
            document.getElementById('printhere').innerHTML += "<br>";
        } //if-else end
    } //for end
} //hollow end