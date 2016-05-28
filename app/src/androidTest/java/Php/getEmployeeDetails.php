<?php 
require "db_connect.php";

$nic = $_POST["nic"];

$mysql_qry = "SELECT * from employee where National_ID = " .$nic . ";";

$result = mysqli_query($conn ,$mysql_qry);

if(mysqli_num_rows($result) > 0) {
	
	$row = mysqli_fetch_assoc($result);
	
	print(json_encode($row));
	
	echo "Select success ";
}
else {
	echo "Select success";
}

conn->close();

?>