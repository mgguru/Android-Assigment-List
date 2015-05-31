<?php
error_reporting(0);
include("db_config.php");
$response = array();
//if(isset($_GET['MaHoi'])) /*{*/
	//$MaHoi = $_GET['MaHoi'];
	mysql_query("SET NAMES 'UTF8'"); 
	$result = mysql_query("select MaBS, TenBS, GioiTinh, HinhAnh, TenKhoa,TTCN from bacsi, khoa where bacsi.makhoa= khoa.makhoa") or die(mysql_error());
	if (mysql_num_rows($result) > 0) { 
    $response["dsBacsi"] = array();
    while ($row = mysql_fetch_array($result)) {
            $items = array();
            $items['MaBS'] =$row['MaBS'];
			$items['TenBS'] = $row['TenBS'];
			$items['GioiTinh'] = $row['GioiTinh'];
			$items['TTCN'] = $row['TTCN'];
			$items['HinhAnh'] = $row['HinhAnh'];
			$items['MaKhoa'] = $row['TenKhoa'];
            array_push($response["dsBacsi"],$items); 					
           }	
     $response["success"] = 1;
}
//}
else {
      $response["success"] = 0;
      $response["message"] = "Not Found";
}	
echo json_encode($response);
?> 