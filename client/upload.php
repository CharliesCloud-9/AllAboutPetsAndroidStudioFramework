<?php
	if(isset($_POST['image'])){
		$now = DateTime::createFromFormat('U.u', microtime(true));
		$id = $now->format('YmdHisu');
		
		$upload_folder = "upload";
		$path = "$upload_folder/$id.jpeg";
		$image = $_POST['image'];
		if(file_put_contents($path, base64_decode($image)) != false){
			echo "uploaded_success";
			exit;
		}
		else{
			echo "uploaded_failed";
			exit;
		}
	}
	else{
		echo "image_not_in";
		exit;
	}
	
?>