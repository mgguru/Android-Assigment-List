<?php
error_reporting(0);
include("db_config.php");

// array for JSON response
 // $response =  array( 
				  // array("Asus Fire", 115 , 3,""),
				  // array("Dell Wing", 100 , 1,""),
				  // );
 $response = array();

//echo json_encode($response);

   if( !(empty($_POST['TenNguoiDK']))&& !(empty($_POST['SoDienThoai']))&& !(empty($_POST['NgayKham']))&& !(empty($_POST['MaKhoa'])))
{
    $TenNguoiDK=$_POST['TenNguoiDK'];
	$SoDienThoai=$_POST['SoDienThoai'];
	$NgayKham=$_POST['NgayKham'];
	$MaKhoa=$_POST['MaKhoa'];

    $result = mysql_query("INSERT INTO nguoidk(MaNguoiDK,TenNguoiDK,SoDienThoai,NgayKham,MaKhoa,XacNhan) VALUES('','$TenNguoiDK','$SoDienThoai','$NgayKham','$MaKhoa',0)");   

    if($result>0){
           $response["success"] = 1;
         }   
     else{
           $response["success"] = 0;
         }
     // echoing JSON response 
     echo json_encode($response); 
}
?> 