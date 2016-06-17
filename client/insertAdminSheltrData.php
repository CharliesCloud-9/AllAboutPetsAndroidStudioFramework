<?php
	include_once("connection.php");
	
	if(isset($_POST['petName']) && isset($_POST['phoneNumber']) && isset($_POST['comment'])) {
			
		$petName = $_POST['petName'];
		$phoneNumber = $_POST['phoneNumber'];
		$comment = $_POST['comment'];
		
		$dir = '/Applications/MAMP/htdocs/client/upload';
		$files1 = scandir($dir);
		$id = max($files1);
		
		$path = "client/upload/$id.jpeg";
		$imagePet_url = "http://192.168.0.19/client/upload/$id";
		
		
	
		$query = "INSERT INTO tbl_animal_shelter(sid, petName, phoneNumber, imagePet_url, comment)
				VALUES (NULL,'$petName', '$phoneNumber', '$imagePet_url', '$comment')";
	
		$result = mysqli_query($conn, $query);
	
		if($result > 0){
			if(isset($_POST['mobile']) && $_POST['mobile'] == "android"){
			echo "success";
			exit;
		}
			echo "insert successfully";	
		}
		else{
			if(isset($_POST['mobile']) && $_POST['mobile'] == "android"){
				echo "failed";
				exit;
			}
			echo "error ocurred";
		}

	}
		
?>

<html>
<head><title>insert SignUp</title></head>
    <body>
        <h1>Insert Data<a href=”http://www.charliescloud9.com”>CharliesCloud9</a></h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
            petName <input type="text" name="petName" value="" /><br/>
            phoneNumber <input type="text" name="phoneNumber" value="" /><br/>
            imageAnimal <input type="text" name="imagePet_url" value="" /><br/>
            comment <input type="text" name="comment" value="" /><br/>
            <input type="submit" name="btnSubmit" value="Login"/>
        </form>
    </body>
</html>