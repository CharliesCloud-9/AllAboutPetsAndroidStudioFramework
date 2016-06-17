<?php

	$var1 = "2";
	$var2 = "2";
	
	if($var1 == $var2) {
		$dir = '/Applications/MAMP/htdocs/client/upload';
		$files1 = scandir($dir);
		
		echo max($files1);	
		}	
		


?>