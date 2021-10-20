<!DOCTYPE html>
    <head>
        <title>Lab 6 - Pattern</title>
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

    <div class="container-xl p-3 my-3 bg-dark text-white" style="position:relative; left: -180px;top:-40px;text-size:10px;text-align:center;">
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
</div>
</body>
<footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;display: inline-block; width: 74%; height: 100px;position: relative;left: 25px;top:-50px;">
<?php
	include("Footer.php");
?>
</footer>
