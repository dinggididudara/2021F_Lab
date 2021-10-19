<?php
	for(var i=99;i > 0;i--){
		if($i%==0){ //if even number
			echo ("$i bottles of beer can serve odd number of guests"."<br>");
		}else if($i!=0){
			echo ("$i bottles of beer can serve even number of guests"."<br>");
		}
		if(i==1){
			echo("$i bottles of beer can serve ONLY ONE guest"."<br>");
			break;
		} //if end
	} //for end

?>