<?php
error_reporting(0);
include("db_config.php");

// array for JSON response
$response = array();

if(isset($_GET['SoDienThoai'])) {
	$SoDienThoai = $_GET['SoDienThoai'];
	$result = mysql_query("SELECT STT 
						   from dkkhambenh 
						   where MaNguoiDK=(select MaNguoiDK
											from nguoidk
											where SoDienThoai='$SoDienThoai')") or die(mysql_error());
	if (mysql_num_rows($result) > 0) { 
    $response["Sokhambenh"] = array();
    while ($row = mysql_fetch_array($result)) {
            // temp user array
            $item = array();
            $item["STT"] = $row["STT"];
            //$item["item"] = $row["item"];
       
            // push ordered items into response array
            array_push($response["Sokhambenh"], $item);
           }
      // success
     $response["success"] = 1;
}
else {
    // order is empty
      $response["success"] = 0;
      $response["message"] = "Not Found";
}
	
}
// echoing JSON response
echo json_encode($response);
?> 