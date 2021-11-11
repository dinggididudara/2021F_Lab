<!DOCTYPE html>
<html lang="en">
<head>
   <meta http-equiv="Content-Type" content="text/html; 
   charset=UTF-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>Book Template</title>

   <link rel="shortcut icon" href="../../assets/ico/favicon.png">

   <!-- Google fonts used in this theme  -->
<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic,700italic' rel='stylesheet' type='text/css'>  

   <!-- Bootstrap core CSS -->
   <link href="bootstrap3_bookTheme/dist/css/bootstrap.min.css" rel="stylesheet">
   <!-- Bootstrap theme CSS -->
   <link href="bootstrap3_bookTheme/theme.css" rel="stylesheet">


   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]>
   <script src="bootstrap3_bookTheme/assets/js/html5shiv.js"></script>
   <script src="bootstrap3_bookTheme/assets/js/respond.min.js"></script>
   <![endif]-->
</head>

<body>
<?php include 'book-header.inc.php'; ?>
   
<div class="container">
   <div class="row">  <!-- start main content row -->

      <div class="col-md-2">  <!-- start left navigation rail column -->
         <?php include 'book-left-nav.inc.php'; ?>
      </div>  <!-- end left navigation rail --> 

      <div class="col-md-10">  <!-- start main content column -->
        
         <!-- Customer panel  -->
         <div class="panel panel-danger spaceabove">           
           <div class="panel-heading"><h4>My Customers</h4></div>
           <table class="table">
             <tr>
               <th>Name</th>
               <th>Email</th>
               <th>University</th>
               <th>City</th>
             </tr>
			 <tr>
			  <?php
				$cfile = file('customers.txt') or die('Cannot open file');
				$arr = array();
				$comma = ',';
	
				foreach($cfile as $line){
					$splitcontents = explode($comma,$line);
					$arr[] = $splitcontents;
					
					$id = $splitcontents[0];
					$name = utf8_encode($splitcontents[1].' '.$splitcontents[2]);
					$email = utf8_encode($splitcontents[3]);
					$univ = utf8_encode($splitcontents[4]);
					$city = utf8_encode($splitcontents[6]);
		
					echo "<tr>
					<td><a href='BookRepCRM.php?id=$id'>".$name."</td>
					<td>".$email."</td>
					<td>".$univ."</td>
					<td>".$city."</td>
					</tr>";
				}
				echo "
				</table>
				</div>";
				
				$oFile = null;
				foreach($_GET as $tem => $check){
					if($tem == "id"){
						$id = $_GET["id"];
						
						$oFile = file("orders.txt") or die("Cannot open file");
						$tf = false;
						
						foreach($oFile as $info){
							$book = explode($comma, $info);
							
							if($book[1] == $id){
								orders($id);
								$tf = true;
								break;
							} 
						} 
						
						if($tf == false){
							echo "<div class='panel panel-heading'>No Orders</div>";
						} 
					} 			
				} 
				
				function orders($id){
					global $arr;
					foreach($arr as $splitcontents){
						if($id == $splitcontents[0]){
							echo '<div class="panel panel-danger spaceabove">
							<div class="panel-heading">
								<h4>Orders from '.utf8_encode($splitcontents[1]." ".$splitcontents[2]).'s</h4>
							</div>
							<table class="table">
							<tr>
							<th></th>
							<th>ISBN</th>
							<th>Title</th>
							<th>Category</th>
							</tr>';
						}
					} 
					
					global $oFile;
					foreach($oFile as $info){
						$book = explode(',',$info);
						if ($book[1] == $id){
							echo '
							<tr>
							<td><img src=.jpg></td>
							<td>'.$book[2].'</td>
							<td><a href>'.$book[3].'</a></td>
							<td>'.$book[4].'</td>
							</tr>';
						} 
					} 
					echo '</table></div>';					
				} 
			?>         
      </div>
      </div>  <!-- end main content column -->
   </div>  <!-- end main content row -->
</div>   <!-- end container -->
   


   
   
 <!-- Bootstrap core JavaScript
 ================================================== -->
 <!-- Placed at the end of the document so the pages load faster -->
 <script src="bootstrap3_bookTheme/assets/js/jquery.js"></script>
 <script src="bootstrap3_bookTheme/dist/js/bootstrap.min.js"></script>
 <script src="bootstrap3_bookTheme/assets/js/holder.js"></script>
</body>
</html>