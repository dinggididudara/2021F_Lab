<html>
<header style="background-color: rgb(239, 245, 191);font-size: 25pt;text-align:center;display: inline-block; width: 74%; height: 150px;position: relative;left: 25px;">
<?php
	include("Header.php");
?>
<body>
<?php
	for($i=0;$i < 20;$i++){
		for($j=0;$j <$i;$j++){
			echo ("*");
		} //for end
	echo "<br>";
	} //for end
	for($x=20;$x >= 0;$x--){
		for($y=0;$y <$x;$y++){
			echo ("*");
		} //for end
	echo "<br>";
	} //for end
?>
</body>
<footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;display: inline-block; width: 74%; height: 100px;position: relative;left: 25px;">
<?php
	include("Footer.php");
?>
</footer>
</html>