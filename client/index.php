<?PHP 
    include_once("connection.php"); 
    if( isset($_POST['txtUsername']) && isset($_POST['txtPassword']) ) { 
        $username = $_POST['txtUsername'];
        $password = $_POST['txtPassword'];
        $query = "SELECT * FROM tbl_client WHERE username = '$username' AND password = '$password'";
        
       /* 
	       Also can be done this way:
	       $query = "SELECT username, password FROM tbl_client ". 
        " WHERE username = '$username' AND password = '$password'"; */
        
        $result = mysqli_query($conn, $query);
        
        if($result->num_rows > 0){
            
                echo "success";
                exit; 
          
          }else{
	          
	          echo "Incorrect username and password";
	          exit; 
          }
    } 
?>

<html>
<head><title>Login</title></head>
    <body>
        <h1>Login<a href=”http://www.charliescloud9.com”>CharliesCloud9</a></h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
            Username <input type="text" name="txtUsername" value="" placeholder="Enter Username"/><br/>
            Password <input type="password" name="txtPassword" value="" placeholder="Enter Password"/><br/>
            <input type="submit" name="btnSubmit" value="Login"/>
        </form>
    </body>
</html>