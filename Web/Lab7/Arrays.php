<!DOCTYPE html>
    <head>
        <title>Lab 7 - Arrays</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
<header style="background-color: rgb(239, 245, 191);font-size: 25pt;text-align:center;display: inline-block; width: 74%; height: 150px;position: relative;left: 25px;">
<?php
	include("Header.php");
?>
</header>
<body>
  <h5>
    <?php
        include("Menu.php");
    ?>
  </h5>
    <div class="container-xl p-3 my-3 bg-dark text-white" style="position:relative; left:-180px; top:-40px;text-size:12px;text-align:left;">
	<?php
	$November = array("Friday"=>array("1st"=>5, "2nd"=>12, "3rd"=>19, "4th"=>26), 
			"Saturday"=>array("1st"=>6, "2nd"=>13, "3rd"=>20, "4th"=>27),
			"Sunday"=>array("1st"=>7, "2nd"=>14, "3rd"=>21, "4th"=>28),
			"Monday"=>array("1st"=>1, "2nd"=>8, "3rd"=>15, "4th"=>22, "5th"=>29),
			"Tuesday"=>array("1st"=>5, "2nd"=>9, "3rd"=>16, "4th"=>23, "5th"=>30),
			"Wednesday"=>array("1st"=>5, "2nd"=>10, "3rd"=>17, "4th"=>24),
			"Thursday"=>array("1st"=>5, "2nd"=>11, "3rd"=>18, "4th"=>25));
	//output-1
	echo "<h2>";
	print_r($November);
	echo "</h2><br>";

	//output-2
	foreach($November as $days => $arr){
		foreach($arr as $k => $v){
			echo "<h2>"."$v is the $k $days in November"."</h2><br>";
		}
	}
	
	//output-3
	echo "<h2>";
	$NovemberR = array_reverse($November);
	print_r($NovemberR);
	echo "</h2><br>";

	//output-4
	$November["Wednesday"]["5th"]= 31;
	echo "<h2>";
	print_r($November);
	echo "</h2><br>";
	?>
</div>
</body>
<footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;display: inline-block; width: 74%; height: 100px;position: relative;left: 25px;top:-50px;">
<?php
	include("Footer.php");
?>
</footer>
