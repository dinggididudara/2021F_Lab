<?php
	for(var i=90;i >= 0;i-=10){
		echo ("$i bottles of beer on the wall..."."<br>");
		echo ("You take one down you pass it around..."."<br>");
		echo ("$(i-1) bottles of beer on the wall."."<br><br>");
		if(i==0){
			echo("There are no moe bottles of beer."."<br>");
			break;
		} //if end
	} //for end

?>