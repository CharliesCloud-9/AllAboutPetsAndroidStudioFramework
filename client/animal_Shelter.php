<?php
	include_once("connection.php");
	
	$query = "SELECT * FROM tbl_animal_shelter ORDER BY sid DESC"; //...to this line of code instead
												// of using array_reverse() on the 12 line of code
	
	$result = mysqli_query($conn, $query);
	
	while($row = mysqli_fetch_assoc($result)){
		$data[] = $row;
	}
	echo json_encode($data);
	//array_reverse() allows for data array object to be shown in reverse. Workaround for 
	//ListView Reverse order. But look at other comment for other option
	
?>