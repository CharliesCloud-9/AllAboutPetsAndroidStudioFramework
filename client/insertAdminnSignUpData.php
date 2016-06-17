<?php
	include_once("connection.php");
	
	if(isset($_POST['name']) && isset($_POST['age']) && 
		isset($_POST['username']) && isset($_POST['password'])){
		$name = $_POST['name'];
		$age = $_POST['age'];
		$username = $_POST['username'];
		$password = $_POST['password'];
	
		$query = "INSERT INTO tbl_adminLogin(uid, name, age, username, password)
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
            Name <input type="text" name="name" value="" /><br/>
            Age <input type="text" name="age" value="" /><br/>
            Username <input type="text" name="username" value="" /><br/>
            Password <input type="password" name="password" value="" /><br/>
            <input type="submit" name="btnSubmit" value="Login"/>
        </form>
    </body>
</html>