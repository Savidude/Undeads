<?php 
require "db_connect.php";

$nic = $_POST["nic"];
$job_offer_id = $_POST["job_offer_id"];

$mysql_qry = "INSERT INTO accepted_job_offers (National_ID, Job_Offer_ID, Pending) VALUES ('" .$nic . "','" .$job_offer_id . "', 0);";

if($conn->query($mysql_qry) === TRUE) {
	echo "Insert Successful";
}
else {
	echo "Error: " .mysql_qry . "<br>" .$conn->error;
}
?>