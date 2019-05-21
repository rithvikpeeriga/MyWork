<!--stargate link-->
<!--http://stargate.ncc.edu/~pee2723/ite256hm6.php-->



<html>
<head>
<title></title>
 
<style type="text/css">
 
body {
background-image: url("http://newton.ncc.edu/gansonj/ite254/img/vgbkg.png");
font-family: arial;
color: #454F8C;
}
 
#contentwrap {
background: #FFFFFF;
background-image: url("http://newton.ncc.edu/gansonj/ite254/img/spyro.jpg");
background-repeat: no-repeat;
background-position: right 150; 
border: 8px #FF9E01 solid;
padding: 20px;
width: 650px;
margin: 20px auto 0px auto;
border-radius: 25px;
min-height: 400px;
}
 
#heading {
font-size: 2.2em;
border-bottom: 6px #484452 double;
padding: 10px 0px 10px 0px;
text-align: center;
margin-bottom: 20px;
}
 
.bottomdiv {
margin-bottom: 15px;
}
 
.spacer {
margin-bottom: 10px;
}
#red{
	color:red;
	margin-bottom:10px;
}
#green {
	color:green;
	margin-bottom:10px;
}
</style>
 
</head>
<body>
 
<div id="contentwrap">
 
<div id="heading">Search Video Games in Inventory</div>
 
<div>
 
<!-- php goes here -->
<?php
 
// establish connection with DB
$db = mysqli_connect( "stargate.ncc.edu", "pee2723", "pee2723", "pee2723" );
 
// consturct query
$query = "select * from inventory where quantity > '10'";
 
// perform the query and grab the results from the DB
$results = mysqli_query( $db, $query )
or die("Could not connect to DB ". mysqli_error($db) );
 
 $records = mysqli_num_rows($results);

echo "<div class='spacer'>Number of games found with quantity > 10 is" .$records."</div>";
 
 
// use a for loop to go through and print all found records
for( $i = 0; $i < $records ;$i++ ) {
 
$gamearray = mysqli_fetch_array( $results );
echo "<div> title of the game is  ". $gamearray['title']."</div>";
echo "<div> Quantity is  ". $gamearray['quantity']."</div>";
  
  
  if ($gamearray['score'] >= '7'){
	  echo  "<div id ='red'> with a critic score of " . $gamearray['score']. "this game is hot pick</div>";
	  
  }
 else{
     echo "<div id='green'> with a critic score of " . $gamearray['score']. "this game is not hot pick</div>"; 
 } 
	 
} // ends for loop
 
?>
</div>  
 
</div> <!-- ends div#contentwrap -->
 
</body>
</html>