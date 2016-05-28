<?php 
require "db_connect.php";

$nic = $_POST["nic"];

$output = array();
$index = 0;

$mysql_qry = "SELECT * from subscription WHERE National_ID = '" .$nic ."';";
$result = mysqli_query($conn ,$mysql_qry);


if(mysqli_num_rows($result) > 0) {
	
	while($row1 = mysqli_fetch_assoc($result)){
		
		$mysql_qry2 = "SELECT * from organization where Organization_ID = '" .$row1["Organization_ID"] . "';";
		$result2 = mysqli_query($conn ,$mysql_qry2);
		$row2 = mysqli_fetch_assoc($result2);
		
		$mysql_qry3 = "SELECT * from job_offer where Organization_ID = '" .$row1["Organization_ID"] . "';";
		$result3 = mysqli_query($conn ,$mysql_qry3);
		
		$index1 = 0;
		
		
		if(mysqli_num_rows($result3) > 0) {
			
			while($row3 = mysqli_fetch_assoc($result3)){
				
				$mysql_qry4 = "SELECT * from job where Job_ID = '" .$row3["Job_ID"] . "';";
				$result4 = mysqli_query($conn ,$mysql_qry4);
				$row4 = mysqli_fetch_assoc($result4);
		
				$mysql_qry5 = "SELECT * from job_title where Job_Title_ID = '" .$row4["Job_Title_ID"] . "';";
				$result5 = mysqli_query($conn ,$mysql_qry5);
				$row5 = mysqli_fetch_assoc($result5);
				
				$output['Last_Updated_Date'][$index][$index1] = $row1["Last_Updated_Date"];
				$output['Organization_Name'][$index][$index1] = $row2["Organization_Name"];
				$output['Job_Offer_Added_Time'][$index][$index1] = $row3["Job_Offer_Added_Time"];
				$output['Start_Tme'][$index][$index1] = $row4["Start_Tme"];
				$output['End_Time'][$index][$index1] = $row4["End_Time"];
				$output['Quantity'][$index][$index1] = $row4["Quantity"];
				$output['Job_Title_Description'][$index][$index1] = $row5["Job_Title_Description"];
				
				$index1++;
			}
		
		}else {
			echo "Error: " .mysql_qry3 . "<br>" .$conn->error;
		}
		
		$index++;
	}
	
	print(json_encode($output));
	
	echo "Select success ";
}
else {
	echo "Error: " .mysql_qry . "<br>" .$conn->error;
}

?>