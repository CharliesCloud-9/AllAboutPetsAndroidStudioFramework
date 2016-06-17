<?php
	include_once("connection.php");
	
	if(isset($_POST['sid']) && 
		isset($_POST['mobile']) && $_POST['mobile'] == "android"){
		
		$sid = $_POST['sid'];
		$query = "DELETE FROM tbl_animal_shelter WHERE sid=$sid";
	
		$result = mysqli_query($conn, $query);
		
		if($result > 0){
			echo "success";
			exit;	
		}
		else{
			echo "failed";
			exit;		
		}
	}
		
?>

