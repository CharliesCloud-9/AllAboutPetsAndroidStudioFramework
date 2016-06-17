<?php
	include_once("connection.php");
	
	$query = "SELECT * FROM tbl_product ORDER BY pid DESC"; //LIMIT 0,2" use this to choose specifically 
															//which ones you want within table
	
	$result = mysqli_query($conn, $query);
	
	while($row = mysqli_fetch_assoc($result)){
		$data[] = $row;
	}
	echo json_encode($data);
	
?>