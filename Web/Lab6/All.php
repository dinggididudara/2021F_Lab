<?php
	for(var i=99;i >= 0;i--){
		echo ("$i bottles of beer on the wall..."."<br>");
		echo ("You take one down you pass it around..."."<br>");
		echo ("$(i-1) bottles of beer on the wall."."<br><br>");
		if(i==0){
			echo("There are no moe bottles of beer."."<br>");
			break;
		} //if end
	} //for end

?>