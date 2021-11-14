<!DOCTYPE html>
    <head>
        <title>Lab 8 - Session1</title>
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
	<div class="container-xl p-3 my-3 bg-dark text-white" style="position:relative; left: -180px;top:-40px;text-size:12px;text-align:left;">
    <div class="row">
	<div class="col">
	<form method="post">
		Employee Name: <input type="text" name="box1" placeholder="Enter a employee name" style="width: 300px;"><br></br>
        Employee ID: <input type="text" name="box2" placeholder="Enter a employee ID" style="width: 300px;"><br></br>
        Telephone Number: <input type="tel" name="box3" placeholder="Enter a telephone number" style="width: 300px;"><br></br>
        Email Address: <input type="email" name="box4" placeholder="Enter a email address" style="width: 300px;"><br></br>
        
		Position:
          <input type="radio" name="position" value="Manager">Manager
          <input type="radio" name="position" value="Team Lead">Team Lead
          <input type="radio" name="position" value="IT Developer" >IT Developer
          <input type="radio" name="position" value="IT Analyst">IT Analyst<br><br>
         
		 Project:
          <select name = "project">
            <option value="Project A">Project A</option>
            <option value="Project B">Project B</option>
            <option value="Project C">Project C</option>
            <option value="Project D">Project D</option>
		  </select>
        <br><br><button type="submit" value="Submit" name = "Sub_btn">Submit</button><br><br>
	</form>
	</div>
	
	<div class="col">
	<?php
		if(isset($_POST['Sub_btn'])){
			session_start();
			
			if(isset($_POST["box1"])){
			  $_SESSION["name"] = $_POST["box1"];
			}

		   if(isset($_POST["box2"])){
             $_SESSION["id"] = $_POST["box2"];
           }

           if(isset($_POST["box3"])){
       	     $_SESSION["tel"] = $_POST["box3"];
           }

          if(isset($_POST["box4"])){
            $_SESSION["email"] = $_POST["box1"];
          }

          if(isset($_POST["positon"])){
       	    $_SESSION["position"] = $_POST["position"];
          }

          if(isset($_POST["project"])){
        	$_SESSION["project"] = $_POST["projectOption"];
       	    header("Location: Session2.php");
       	    exit;
          }

		}
	?>
	</div>
</div>
</div>
</body>
<footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;display: inline-block; width: 74%; height: 100px;position: relative;left: 25px;top:-50px;">
<?php
	include("Footer.php");
?>
</footer>
