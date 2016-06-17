<?php
	include_once("connection.php");
	
	if(isset($_POST['txtName']) && isset($_POST['txtAge']) && 
		isset($_POST['txtUsername']) && isset($_POST['txtPassword'])){
		$name = $_POST['txtName'];
		$age = $_POST['txtAge'];
		$username = $_POST['txtUsername'];
		$password = $_POST['txtPassword'];
	
		$query = "INSERT INTO tbl_client(uid, name, age, username, password)
				VALUES (NULL,'$name', '$age', '$username', '$password')";
	
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
            Name <input type="text" name="txtName" value="" /><br/>
            Age <input type="text" name="txtAge" value="" /><br/>
            Username <input type="text" name="txtUsername" value="" /><br/>
            Password <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" name="btnSubmit" value="Login"/>
        </form>
    </body>
</html>