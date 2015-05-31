<?php
error_reporting(0);
include("db_config.php");
$response = array();
if(isset($_GET['MaHoi'])) {
	$MaHoi = $_GET['MaHoi'];
	mysql_query("SET NAMES 'UTF8'"); 
	$result = mysql_query("select c.Mahoi,TenBenhNhan, NgayGui, CauHoi, TenBS, CauTraLoi 
							from bacsi a, dap b, hoi c 
							where b.mahoi='$MaHoi' and a.mabs=b.mabs and b.mahoi = c.mahoi") or die(mysql_error());
	if (mysql_num_rows($result) > 0) { 
    $response["cau_dap"] = array();
    while ($row = mysql_fetch_array($result)) {
            $items = array();
            $items['MaHoi'] = $MaHoi;//$row['MaHoi'];
			$items['TenBS'] = $row['TenBS'];
			$items['CauTraLoi'] = $row['CauTraLoi'];
			$items['TenBenhNhan'] = $row['TenBenhNhan'];
			$items['CauHoi'] = $row['CauHoi'];
			$items['NgayGui'] = $row['NgayGui'];
            array_push($response["cau_dap"],$items); 					
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