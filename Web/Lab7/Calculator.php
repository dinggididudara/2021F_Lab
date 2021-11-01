<!DOCTYPE html>
    <head>
        <title>Lab 7 - Calculator</title>
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
    <form method="post">
	<input type="text" name="num" id="num"/>
	<select name="operation" id="operation">
	<option>+</option>
	<option>-</option>
	<option>/</option>
	<option>x</option>
	<option>exp</option>
	</select>
	<input type="text" name="num2" id="num2"/>
	<input type="submit" class="=" value="="/>
	<?php
		if($_SERVER["REQUEST_METHOD"]=="POST"){ //if server got value from user
 		if (isset($_POST['num'])&& isset($_POST['num2'])){
			$num = $_POST['num']; //get num from input
			$num2 = $_POST['num2']; //get num from input
			$operation = $_POST['operation'];

			if($operation=="+"){ //plus
				$result = $num + $num2;
				echo "$num plus $num2 equals $result";
			}else if($operation=="-"){ //minus
				$result = $num - $num2;
				echo "$num minus $num2 equals $result";
			} else if($operation=="/") { //division
				$result = $num / $num2;
				echo "$num divided by $num2 equals $result";	
			} else if($operation=="x") { //multiple
				$result = $num * $num2;
				echo "$num multiply $num2 equals $result";
			} else if ($operation == "exp") { //exponent
				$result = pow($num,$num2);
				echo "$num exponent $num2 equals $result";
			} //if-else end

			//check prime number
			$a=0; //for counting
			for($i=1; $i<$result;$i++){
				if($result % $i == 0){ //error
					$a++;
				} //if end
			} //for end
			if($a < 3) {
				$str1 = "$result is a prime number";	
			} else {
				$str1 = "$result is NOT a prime number";
			} //if-else end

			//check even/odd
			if($result % 2==0){
				$str2 = "$result is an even number";
			} else if($result % 2 != 0) {
				$str2 = "$result is an odd number";
			} //if-else end
	
			//print
			echo '<h2 text-align="center"><br>'.$str1.'<br><br>'.$str2.'</h2>';

		} //if end
		} //if end
	?>
</form>
</div>
</body>
<footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;display: inline-block; width: 74%; height: 100px;position: relative;left: 25px;top:-50px;">
<?php
	include("Footer.php");
?>
</footer>
