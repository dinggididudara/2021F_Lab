<!DOCTYPE html>
    <head>
        <title>Lab 7 - Objects</title>
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

    <div class="container-xl p-3 my-3 bg-dark text-white" style="position:relative; left: -180px;top:-40px;text-size:10px;">
<?php
	ini_set('display_errors', 1);
	ini_set('display_startup_errors', 1);
	error_reporting(E_ALL);
	
	interface Vehicle{
		public function displayVehicleInfo();
	} //displayVehicleInfo interface end
	
	class LandVehicle implements Vehicle {
		protected $make;
		protected $model;
		protected $year;
		protected $price;
		
		public function __construct($make, $model, $year, $price){
			$this->make = $make;
			$this->model = $model;
			$this->year = $year;
			$this->price = $price;	
		} //constructor end
		
		public function displayVehicleInfo(){
			echo "<b>Make: </b>".$this->make."<b>, Model: </b>".$this->model."<b>, Year: </b>".$this->year."<b>, Price: </b>".$this->price;
		} //displayVehicleInfo end
	} //LandVehicle class end
	
	class Car extends LandVehicle {
		private $speedLimit;
		public function __construct($make,$model,$year,$price,$speedLimit){
			$this->make = $make;
			$this->model = $model;
			$this->year = $year;
			$this->price = $price;	
			$this->speedLimit = $speedLimit;
			
			parent::__construct($make,$model, $year,$price);
		} //constructor end
		public function displayVehicleInfo(){
			parent::displayVehicleInfo();
			echo "<b>, Speed Limit: </b>".$this->speedLimit."<br>";
		} //displayVehicle end
	} //Car class end
	
	class WaterVehicle implements Vehicle {
		protected $make;
		protected $model;
		protected $year;
		protected $price;
		
		public function __construct($make, $model, $year, $price){
			$this->make = $make;
			$this->model = $model;
			$this->year = $year;
			$this->price = $price;	
		} //constructor end
		
		public function displayVehicleInfo(){
			echo "<b>Make:</b>".$this->make."<b>, Model: </b>".$this->model."<b>, Year: </b>".$this->year."<b>, Price: </b>".$this->price;
		} //displayVehicleInfo end
	} //WaterVehicle class end
	
	class Boat extends WaterVehicle{
		private $boatCapacity;
		public function __construct($make, $model, $year, $price, $boatCapacity){
			$this->make = $make;
			$this->model = $model;
			$this->year = $year;
			$this->price = $price;
			$this->boatCapacity = $boatCapacity;
			parent::__construct($make,$model,$year,$price);		
		} //constructor end
		
		public function displayVehicleInfo(){
			parent::displayVehicleInfo();
			echo "<b>, Boat Capacity: </b>".$this->boatCapacity."<br>";
		} //displayVehicleInfo end
	} //Boat class end
		
	echo '<h2><u>Car</u></h2>';
	$car1 = new Car("Toyota", "Camry", "1992", "2000", "180");
	$car2 = new Car("Honda", "Accord", "2002", "6000", "200");
	$car3 = new Car("VW","Tiguan","2019","5000","210");
	$car1->displayVehicleInfo();
	$car2->displayVehicleInfo();
	$car3->displayVehicleInfo();

	echo '<h2><u>Boat</u></h2>';
	$boat1 = new Boat("Mitsubishi", "Turbo", "1999", "20000", "18");
	$boat2 = new Boat("Hyndai", "XT", "2012", "26000", "8");
	$boat1->displayVehicleInfo();
	$boat2->displayVehicleInfo();

?>
</div>
</body>
<footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;display: inline-block; width: 74%; height: 100px;position: relative;left: 25px;top:-50px;">
<?php
	include("Footer.php");
?>
</footer>
