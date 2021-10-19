<?php
	var arr[5] = rand(1,50); //generate 5 random numbers, between 1 to 50
	var a;
	var b;
	var c;
	var d;
	var e;
	for(var i=0;i < length;i++){
		if(i > 0 && i <=10){
			echo ("$ numbers are randomly generated in the range between 01-10"."<br>");	
			a++;
		} else if (i > 10 && i <= 20){
			echo ("$ numbers are randomly generated in the range between 11-20"."<br>");	
			b++;
		} else if (i > 20 && i <= 30){
			echo ("$ numbers are randomly generated in the range between 22-30"."<br>");
			c++;	
		} else if (i > 30 && i <= 40){
			echo ("$ numbers are randomly generated in the range between 33-40"."<br>");	
			d++;
		} else if (i > 40 && i <= 50){
			echo ("$ numbers are randomly generated in the range between 44-50"."<br>");	
			e++;
		}
	} //for end
	echo("<br><br><br>Histogram of starts as a percentage of the number of values are displayed below"."<br>");
	echo("01-10"."<br>");
	for(int i=0;i < a;i++){
		echo("*");
	}
	echo("11-20"."<br>");
	for(int i=0;i < b;i++){
		echo("*");
	}
	echo("<br>");
	echo("21-30"."<br>");
	for(int i=0;i < c;i++){
		echo("*");
	}
	echo("<br>");
	echo("31-40"."<br>");
	for(int i=0;i < d;i++){
		echo("*");
	}
	echo("<br>");
	echo("41-50"."<br>");
	for(int i=0;i < e;i++){
		echo("*");
	}
	echo("<br>");

?>