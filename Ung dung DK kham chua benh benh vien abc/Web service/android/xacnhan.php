<?php
  error_reporting(0);
  include("db_config.php");

  // array for JSON response
  $response = array();
/*   $response =  array( 
				   array("Asus Fire", 115 , 3,""),
				   array("Dell Wing", 100 , 1,""),
				   );
  echo json_encode($response);
  if (isset($_GET['SoDienThoai'])){
	  echo $_GET['SoDienThoai'];
  } */

 if(isset($_GET['SoDienThoai'])) {
    $SoDienThoai=$_GET['SoDienThoai'];
    $result = mysql_query("update nguoidk 
						   set XacNhan=1 
						   where SoDienThoai='$SoDienThoai' ") or die(mysql_error());
    $row_count = mysql_affected_rows();
    if($row_count>0){
         $response["success"] = 1;
         $response["message"] = "Updated Sucessfully.";
     }
    else{
        $response["success"] = 0;
        $response["message"] = "Failed To Update."; 
     } 
  // echoing JSON response
  echo json_encode($response); 
}
?>