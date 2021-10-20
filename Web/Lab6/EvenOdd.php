<!DOCTYPE html>
    <head>
        <title>Lab 6 - Even/Odd</title>
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

    <div class="container-xl p-3 my-3 bg-dark text-white" style="position:relative; left: -180px;top:-40px;text-size:12px;text-align:center;">
	<?php
	for($i=99; $i > 0; $i--){
		if($i % 2 == 0){ //if even number
			echo ("$i bottles of beer can serve even number of guests"."<br>");
		}else if($i != 0){	
			if($i == 1){
				echo("$i bottles of beer can serve ONLY ONE guest"."<br>");
				break;
			} //if end
			echo ("$i bottles of beer can serve odd number of guests"."<br>");
		} //if-else end
	} //for end

	?>
</div>
</body>
<footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;display: inline-block; width: 74%; height: 100px;position: relative;left: 25px;top:-50px;">
<?php
	include("Footer.php");
?>
</footer>
