<?php
error_reporting(0);
include("db_config.php");
$response = array();
if(isset($_GET['MaKhoa'])) {
	$MaKhoa = $_GET['MaKhoa'];
	mysql_query("SET NAMES 'UTF8'"); 
	$result = mysql_query("select MaHoi, TenBenhNhan,CauHoi,NgayGui from hoi where MaKhoa='$MaKhoa'") or die(mysql_error());
	if (mysql_num_rows($result) > 0) { 
    $response["cau_hoi"] = array();
    while ($row = mysql_fetch_array($result)) {
            $items = array();
            $items['MaHoi'] = $row['MaHoi'];
			$items['TenBenhNhan'] = $row['TenBenhNhan'];
			$items['CauHoi'] = $row['CauHoi'];
			$items['NgayGui'] = $row['NgayGui'];			
            array_push($response["cau_hoi"],$items); 					
           }	
     $response["success"] = 1;
}
}
else {
      $response["success"] = 0;
      $response["message"] = "Not Found";
}	
echo json_encode($response);
?> 