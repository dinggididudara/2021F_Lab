<!DOCTYPE html>
    <head>
        <title>Lab 8 - Session2</title>
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
	   session_start();
	    if(isset($_SESSION["name"]))
     			echo "<strong>Employee Name: </strong>".$_SESSION["name"]."</br>";

         if(isset($_SESSION["id"]))
     			echo "<strong>Employee ID: </strong>".$_SESSION["id"]."</br>";

         if(isset($_SESSION["tel"]))
     			echo "<strong>Telephone Number: </strong>".$_SESSION["tel"]."</br>";

         if(isset($_SESSION["email"]))
     			echo "<strong>Email Address: </strong>".$_SESSION["email"]."</br>";

         if(isset($_SESSION["position"]))
     			echo "<strong>Position: </strong>".$_SESSION["position"]."</br>";

         if(isset($_SESSION["project"]))
     			echo "<strong>Project: </strong>".$_SESSION["project"]."</br>";
	?>
</div>
</body>
<footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;display: inline-block; width: 74%; height: 100px;position: relative;left: 25px;top:-50px;">
<?php
	include("Footer.php");
?>
</footer>
