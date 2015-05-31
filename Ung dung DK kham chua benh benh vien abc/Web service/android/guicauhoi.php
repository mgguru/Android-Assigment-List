<?php
error_reporting(0);
include("db_config.php");
//$response = array(123,456,789,147,18);
//echo json_encode($response); 

if( !(empty($_POST['TenBenhNhan']))&&!(empty($_POST['NgayGui']))&& !(empty($_POST['SoDienThoai']))&& !(empty($_POST['Email']))&&!(empty($_POST['CauHoi']))&&!(empty($_POST['MaKhoa']))){
    $TenBenhNhan=$_POST['TenNguoiDK'];
	$SoDienThoai=$_POST['SoDienThoai'];
	$Email = $_POST['Email'];
	$CauHoi = $_POST['CauHoi'];	
	$NgayGui=$_POST['NgayGui'];
	$MaKhoa=$_POST['MaKhoa'];
   // $result = mysql_query("INSERT INTO nguoidk(MaNguoiDK,TenNguoiDK,SoDienThoai,NgayKham,MaKhoa,XacNhan) VALUES('','$TenNguoiDK','$SoDienThoai','$NgayKham','$MaKhoa',0)"); 
	$reset = mysql_query("insert into hoi (MaHoi,TenBenhNhan,SoDienThoai,Email,CauHoi,NgayGui,MaKhoa)values('','$TenBenhNhan','$SoDienThoai','$Email','$CauHoi','$NgayGui','$MaKhoa')");
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