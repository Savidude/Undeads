<?php 
require "db_connect.php";

$nic = $_POST["nic"];

$output = array();
$index = 0;

$mysql_qry = "SELECT * from job_offer;";
$result = mysqli_query($conn ,$mysql_qry);

if(mysqli_num_rows($result) > 0) {
	
	while($row1 = mysqli_fetch_assoc($result)){
		
		$mysql_qry2 = "SELECT * from organization where Organization_ID = '" .$row1["Organization_ID"] . "';";
		$result2 = mysqli_query($conn ,$mysql_qry2);
		$row2 = mysqli_fetch_assoc($result2);
		
		$mysql_qry3 = "SELECT * from job where Job_ID = '" .$row1["Job_ID"] . "';";
		$result3 = mysqli_query($conn ,$mysql_qry3);
		$row3 = mysqli_fetch_assoc($result3);
		
		$mysql_qry4 = "SELECT * from job_title where Job_Title_ID = '" .$row3["Job_Title_ID"] . "';";
		$result4 = mysqli_query($conn ,$mysql_qry4);
		$row4 = mysqli_fetch_assoc($result4);
		
		
		$output['Organization_Name'][$index] = $row2["Organization_Name"];
		$output['Start_Tme'][$index] = $row3["Start_Tme"];
		$output['End_Time'][$index] = $row3["End_Time"];
		$output['Quantity'][$index] = $row3["Quantity"];
		$output['Job_Title_Description'][$index] = $row4["Job_Title_Description"];
		
		$index++;
	}
	
	print(json_encode($output));
	
	echo "Select success ";
}
else {
	echo "Error: " .mysql_qry . "<br>" .$conn->error;
}

?>