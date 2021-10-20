<!DOCTYPE html>
    <head>
        <title>Lab 6 - Random</title>
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

    <div class="container-xl p-3 my-3 bg-dark text-white" style="position:relative; left: -180px; top:-40px;text-size:12px;text-align:left;">
	<?php
	for($q=0;$q<500;$q++){
		$arr[$q] = rand(1,50); //generate random numbers, between 1 to 50
	} //for end

	sort($arr); //sort for easier search

	for($i=0;$i < 500;$i++){
		if($arr[$i] > 0 && $arr[$i] <=10){
			$a = $a+1;
		} else if ($arr[$i] > 10 && $arr[$i] <= 20){
			$b = $b+1;
		} else if ($arr[$i] > 20 && $arr[$i] <= 30){
			$c = $c+1;	
		} else if ($arr[$i] > 30 && $arr[$i] <= 40){
			$d = $d+1;
		} else if ($arr[$i] > 40 && $arr[$i] <= 50){
			$e = $e+1;
		}
	} //for end

	echo ("$a numbers are randomly generated in the range between 01-10"."<br>");	
	echo ("$b numbers are randomly generated in the range between 11-20"."<br>");	
	echo ("$c numbers are randomly generated in the range between 22-30"."<br>");
	echo ("$d numbers are randomly generated in the range between 33-40"."<br>");	
	echo ("$e numbers are randomly generated in the range between 44-50"."<br>");		
	
	//percentage
	$a=$a/5;
	$b=$b/5;	
	$c=$c/5;
	$d=$d/5;
	$e=$e/5;
	
	echo("<br><br><br>Histogram of starts as a percentage of the number of values are displayed below"."<br>");
	
	
	echo("01-10: ");
	for($x=0;$x < $a;$x++){
		echo("*");
	}
	echo("<br>"."11-20: ");
	for($y=0;$y < $b;$y++){
		echo("*");
	}

	echo("<br>"."21-30: ");
	for($z=0;$z < $c;$z++){
		echo("*");
	}

	echo("<br>"."31-40: ");
	for($u=0;$u < $d;$u++){
		echo("*");
	}

	echo("<br>"."41-50: ");
	for($k=0;$k < $e;$k++){
		echo("*");
	}
	echo("<br>");

?>
</div>
</body>
<footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;display: inline-block; width: 74%; height: 100px;position: relative;left: 25px;top:-50px;">
<?php
	include("Footer.php");
?>
</footer>
