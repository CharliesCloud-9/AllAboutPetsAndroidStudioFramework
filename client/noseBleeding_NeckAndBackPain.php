<?php
	include_once("connection.php");
	
	$query = "SELECT * FROM tbl_product WHERE name = 'Nose Bleeding' OR name = 'Neck and Back Pain'"; //LIMIT 0,2" use this to choose specifically 
															//which ones you want within table
	
	$result = mysqli_query($conn, $query);
	
	while($row = mysqli_fetch_assoc($result)){
		$data[] = $row;
	}
	echo json_encode($data);
	
?>