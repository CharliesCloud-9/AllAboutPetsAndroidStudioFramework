<?php
$servername = "just131.justhost.com"; 
$username = "username";  //I have purposely hidden the actual username details
$password = "password";  //I have purposely hidden the actual password details
$dbname = "db_name"; //I have purposely hidden the actual password details
// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
//echo "Connected successfully";
?>