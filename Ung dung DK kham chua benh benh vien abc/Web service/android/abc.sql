-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2015 at 03:21 PM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `abc`
--

-- --------------------------------------------------------

--
-- Table structure for table `bacsi`
--

CREATE TABLE IF NOT EXISTS `bacsi` (
  `MaBS` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `TenBS` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `GioiTinh` int(11) NOT NULL,
  `TTCN` text COLLATE utf8_unicode_ci NOT NULL,
  `HinhAnh` text COLLATE utf8_unicode_ci NOT NULL,
  `MaKhoa` varchar(5) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bacsi`
--

INSERT INTO `bacsi` (`MaBS`, `TenBS`, `GioiTinh`, `TTCN`, `HinhAnh`, `MaKhoa`) VALUES
('BS01', 'Bùi Cao Mỹ Ái', 0, 'QUÁ TRÌNH CÔNG TÁC\r\n2008 – nay: Bệnh viện Đại học Y Dược TP.HCM \r\nQUÁ TRÌNH HỌC TẬP\r\n2005: Tốt nghiệp Bác sỹ Y Khoa tại Đai Học Y Phạm Ngọc Thạch \r\n2009: Tốt nghiệp Bác sỹ Chuyên khoa I, Nội Trú tại Đại học Y Dược TP.HCM \r\n\r\n', 'http://169.254.189.95:8080/android/imgBacsi/lap1.jpg', 'K02'),
('BS02', 'Nguyễn Xuân Tuấn Anh', 1, 'QUÁ TRÌNH CÔNG TÁC\r\n\r\n    1985 – 1995: BV Nguyễn Tri Phương - Bộ môn Nội Đại học Y Dược TP.HCM 1995 – nay: BV Chợ Rẫy - Bộ môn Nội Đại học Y Dược TP.HCM\r\n                      Công tác tại Bệnh viện Đại học Y Dược cơ sở 1\r\n                      Bác sĩ tham gia khám chữa bệnh tại phòng khám Tim mạch \r\n\r\nQUÁ TRÌNH HỌC TẬP\r\n\r\n    1985: Tốt nghiệp BS Y khoa 1995: Tốt nghiệp CKI 1997: Thạc sĩ 2012 – nay: Nghiên cứu sinh \r\n\r\nHỘI VIÊN\r\n\r\n    Hội viên Hội Tim mạch Thành phố Hồ Chí Minh \r\n\r\n', 'http://169.254.189.95:8080/android/imgBacsi/lap2.jpg', 'K02'),
('BS03', 'Huỳnh Thị Liễu', 0, 'QUÁ TRÌNH CÔNG TÁC\r\n\r\n    1984 – nay: Cán bộ giảng trường Đại học Y Dược TP. HCM. Bộ môn thần kinh\r\n                      Công tác tại Bệnh viện Đại học Y Dược cơ sở 1\r\n                      Bác sĩ tham gia khám chữa bệnh tại phòng khám Thần kinh \r\n\r\nQUÁ TRÌNH HỌC TẬP\r\n\r\n    1978 – 1984: Tốt nghiệp BS y khoa trường Đại học Y Dược TP HCM. 1984 – 1987: Tốt nghiệp BSCK I NỘI THẦN KINH. 1992 – 1995: Tốt nghiệp THS NỘI THẦN KINH . \r\n\r\nHỘI VIÊN\r\n\r\n    Hội viên Hội Thần kinh học TP. Hồ Chí Minh Hội viên Hội đột quỵ Việt Nam Hội viên Hội can thiệp thần kinh TP. Hồ Chí Minh \r\n\r\n', 'http://169.254.189.95:8080/android/imgBacsi/lap3.jpg', 'K01'),
('BS04', 'Lê Minh', 1, 'đang cập nhật...', 'http://169.254.189.95:8080/android/imgBacsi/lap9.jpg', 'K01'),
('BS05', 'Lê Phan Cẩm Tú', 0, 'QUÁ TRÌNH CÔNG TÁC\r\n\r\n    2009 – 2010: Phòng khám đa khoa Thuận Kiều, Bệnh viện Răng Hàm Mặt TW TP Hồ Chí Minh 2010 – nay: Khoa Phẫu thuật hàm mặt – RHM Bệnh viện Đại Học Y Dược TP Hồ Chí Minh \r\n\r\nQUÁ TRÌNH HỌC TẬP\r\n\r\n    2009: Tốt nghiệp Bác sỹ RHM Tại Trường Đại Học Y Dược TP Hồ Chí Minh 2012 – nay: Thạc sỹ - Trường Đại Học Y Dược TP Hồ Chí Minh \r\n\r\nHỘI VIÊN\r\n\r\n    Hội viên Hội Răng Hàm Mặt TP HCM \r\n\r\n', 'http://169.254.189.95:8080/android/imgBacsi/lap4.jpg', 'K03'),
('BS06', 'Lê Thị Viết', 0, 'QUÁ TRÌNH CÔNG TÁC\r\n\r\n    1981 – 2013: Khoa Phẫu thuật Hàm Mặt – Bệnh viện Răng Hàm Mặt TP HCM 2013 đến nay: Khoa Phẫu thuật hàm mặt – RHM Bệnh viện Đại Học Y Dược TP Hồ Chí Minh \r\n\r\nQUÁ TRÌNH HỌC TẬP\r\n\r\n    1981: Tốt nghiệp Bác sỹ Y khoa Tại Trường Đại Học Y Dược TP Hồ Chí Minh 1994: Bác sỹ CKI Phẫu thuật Hàm Mặt 1999: Phẫu thuật tạo hình \r\n\r\nHỘI VIÊN\r\n\r\n    Hội viện hội Răng Hàm Mặt Thành phố Hồ Chí Minh Hội viện Hội Phẫu thuật tạo hình. Hội viện Hội Phẫu thuật thẫm mỹ \r\n\r\n', 'http://169.254.189.95:8080/android/imgBacsi/lap5.jpg', 'K03'),
('BS07', 'Võ Quang Đỉnh', 1, 'QUÁ TRÌNH CÔNG TÁC\r\n\r\n    2000 – nay: Bộ môn Da Liễu Đại học Y Dược\r\n                     Công tác tại Bệnh viện Đại học Y Dược cơ sở 1\r\n                     Bác sĩ tham gia khám chữa bệnh tại phòng khám Da liễu \r\n\r\nQUÁ TRÌNH HỌC TẬP\r\n\r\n    1995: Tốt nghiệp Bác sĩ Y Khoa Đại học Y Dược 1999: Tốt nghiệp Bác sĩ nội trú ngành Da Liễu Đại học Y Dược 2008: Tốt nghiệp Cao học ngành Da Liễu Đại học Y Dược \r\n\r\nHỘI VIÊN\r\n\r\n    Hội viên hội Da Liễu TP.HCM Hội viên hội Da Liễu Việt Nam Hội viên hội Da Liễu Châu Âu \r\n\r\n', 'http://169.254.189.95:8080/android/imgBacsi/lap6.jpg', 'K04'),
('BS08', 'Lê Thái Vân Thanh', 0, 'QUÁ TRÌNH CÔNG TÁC\r\n\r\n    2001 – Nay : bộ môn Da Liễu Đại học Y dược TP.HCM \r\n\r\nQUÁ TRÌNH HỌC TẬP\r\n\r\n    1997: Tốt nghiệp Bác sĩ Y Khoa ĐHYD 2001: Tốt nghiệp Bác sĩ Nội trú Da Liễu ĐHYD 2003: Tốt nghiệp Cao học ngành Da Liễu ĐHYD 2010- Nay: Nghiên cứu sinh nghành Da Liễu \r\n\r\nHỘI VIÊN\r\n\r\n    Hội viên hội Da Liễu TP.HCM Hội viên hội Da Liễu Việt Nam Hội viên hội Da Liễu Châu Á \r\n\r\n', 'http://169.254.189.95:8080/android/imgBacsi/lap7.jpg', 'K04'),
('BS09', 'Trần Ngọc Lĩnh', 1, 'QUÁ TRÌNH CÔNG TÁC\r\n\r\n    2007 – nay: Bệnh viện Đại học Y Dược Tp. Hồ Chí Minh \r\n\r\nQUÁ TRÌNH HỌC TẬP\r\n\r\n    2003 : Tốt nghiệp Bác sĩ Y khoa tại Đại học Y Dược Tp. Hồ Chí Minh 2007 : Tốt nghiệp Chuyên khoa cấp I (Nội trú) \r\n\r\nHỘI VIÊN\r\n\r\n    Hội viên Hội phẫu thuật thẩm mỹ Tp. Hồ Chí Minh Hội viên Hội chấn thương chỉnh hình Tp. Hồ Chí Minh Hội viên Hội chấn thương chỉnh hình Việt Nam \r\n\r\n', 'http://169.254.189.95:8080/android/imgBacsi/lap8.jpg', 'K05'),
('BS10', 'Nguyễn Mạnh Đôn', 1, 'QUÁ TRÌNH CÔNG TÁC\r\n\r\n    2009 – nay: Bệnh viện Đại học Y Dược TP Hồ Chí Minh \r\n\r\nQUÁ TRÌNH HỌC TẬP\r\n\r\n    1992: Tốt nghiệp Bác sĩ Y khoa tại Đại học Y Dược TP Hồ Chí Minh 1997: Tốt nghiệp Thạc Sĩ Y học tại Đại học Y Dược TP Hồ Chí Minh 2007 - 2009: Văn Bằng Đại học Phẫu thuật Tạo hình vùng mặt, Đại học Lyon 1, Cộng hòa Pháp 2011: Chuyên khoa Tạo hình Thẩm mỹ Đại học Y Dược TP Hồ Chí Minh 2013: Nghiên cứu sinh, Đại học Y Dược TP Hồ Chí Minh 2014: Chứng nhận hoàn thành khóa học Phẫu thuật Tạo hình tại BV Đại học Quốc gia Seoul, Hàn Quốc \r\n\r\nHỘI VIÊN\r\n\r\n    Hội viên Hội phẫu thuật Thẩm mỹ TP Hồ Chí Minh Hội viên Hội phẫu thuật Tạo hình Việt nam \r\n\r\n', 'http://169.254.189.95:8080/android/imgBacsi/lap10.png', 'K05');

-- --------------------------------------------------------

--
-- Table structure for table `dap`
--

CREATE TABLE IF NOT EXISTS `dap` (
  `MaHoi` int(11) NOT NULL,
  `MaBS` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `CauTraLoi` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dap`
--

INSERT INTO `dap` (`MaHoi`, `MaBS`, `CauTraLoi`) VALUES
(1, 'BS01', 'Với những triệu chứng bạn kể trên bạn đăng ký khám chuyên khoa Thần kinh tại bệnh viện Đại học Y Dược TP.HCM (215 Hồng Bàng, Quận 5, TP. HCM) ) để bác sĩ khám xem tình trạng hiện tại và đưa ra hướng điều trị cho bạn nhé. Nếu bạn muốn được hưởng BHYT bạn đến nơi đăng ký BHYT ban đẩu, để xin giấy chuyển viện đúng tuyến đế bệnh viện Đại học Y Dược TP.HCM bạn nhé.\r\nThân ái. '),
(3, 'BS01', 'Bạn thân mến,\r\nVới những triệu chứng bạn kể trên bạn nên đến khám chuyên khoa Tâm Thần Kinh, phí khám bệnh 100.000đ/lượt tại bệnh viện Đại học Y Dược TP.HCM (215 Hồng Bàng, Quận 5, TP. HCM) để bác sĩ khám xem tình trạng hiện tại và đưa ra hướng diều trị cho bạn nhé.\r\nThân ái. ');

-- --------------------------------------------------------

--
-- Table structure for table `dkkhambenh`
--

CREATE TABLE IF NOT EXISTS `dkkhambenh` (
  `MaNguoiDK` int(11) NOT NULL,
  `STT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dkkhambenh`
--

INSERT INTO `dkkhambenh` (`MaNguoiDK`, `STT`) VALUES
(1, 1),
(2, 1),
(3, 2),
(6, 1),
(9, 2),
(16, 2),
(17, 3),
(18, 4),
(19, 5),
(20, 1),
(23, 6),
(24, 7),
(25, 3),
(26, 4),
(27, 1),
(28, 8),
(29, 9),
(30, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hoi`
--

CREATE TABLE IF NOT EXISTS `hoi` (
`MaHoi` int(11) NOT NULL,
  `TenBenhNhan` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `SoDienThoai` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `CauHoi` text COLLATE utf8_unicode_ci NOT NULL,
  `NgayGui` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `MaKhoa` varchar(5) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoi`
--

INSERT INTO `hoi` (`MaHoi`, `TenBenhNhan`, `SoDienThoai`, `Email`, `CauHoi`, `NgayGui`, `MaKhoa`) VALUES
(1, 'Vuong', '', '', 'Em hay bị đau đầu, mệt mỏi, khó ngủ, ngủ không sâu giấc, ngủ dậy hay bị hoa mắt, mệt mỏi, cảm giác ăn không ngon miệng và có bị sụt cân. Dễ bị cảm sốt nhẹ, chân tay hay bị lạnh và ra mồ hôi. Em có mua bảo hiểm tại bệnh viện Quận 10, vậy cho em hỏi em muốn khám tại Bệnh viện ABC thì sử dụng bảo hiểm được tính thế nào và em cần đăng kí khám khoa nào. Bảo hiểm có được khám thứ 7 không ạ? Chân thành cảm ơn!', '5-21-2015', 'K01'),
(3, 'Hoa', '', '', ' Chào bác sĩ cho em hỏi em hay bị mất ngủ kéo dài cũng nữa tháng nay rồi ạ ban đêm khoảng từ 1-2h e mới ngủ được.Bác sĩ cho em hỏi tình trạng của em như thế thì có nguy cơ mắc bệnh gì không ạ và em muốn đi khám thì em khám chuyên khoa nào ạ và chi phí có cao không? mong bác sĩ hồi âm sớm cho em ạ em cảm ơn', '5-21-2015', 'K01'),
(4, 'Ky', '', '', 'Chào bác sĩ cháu tôi Bệnh tim bẩm sinh Còn ống động mạch. Vậy xin bác sĩ tư vấn giúp, tôi nên khám chuyên đâu? theo phương pháp nào. Xin cảm ơn bác sĩ', '5-21-2015', 'K02'),
(5, 'Luan', '', '', 'chào bs!em năm nay 20t khoảng 1 năm trước em có biểu hiện khi chơi thể thao thì nhanh mệt,chóng mặt,buồn nôn,ù tai.2 tháng trước em có đi khám bs cho siêu âm tim thì phát hiện bị hở van 3 lá:1.5/4 và hở van 2 lá 1/4.Ko biết bệnh của e có tiếp tục chơi thể thao hay làm việc nặng dc ko ạ? hiện tại e đang là sv em cũng ít làm việc nặng ko biết nguyên nhân vì đâu mà e bị hở van tim bởi nhà em ko ai bị và từ nhỏ em cũng ko có bị bệnh này', '5-21-2015', 'K02'),
(6, 'Tuong', '', '', 'Chào bác sỹ! Cho em hỏi, em bị bướu máu trên vành môi đã hơn 10 năm nay rồi. Trước đây có mổ 1 lần ở viện RHM và vài lần ở các bv tư nhân nhưng đến nay vẫn ko hết. Em nghe nói o bv DHYD có điều trị cái này bằng tia laze là hết có đúng ko ạ? Bs cho hỏi chi phí và tgian điều trị là bao lâu ạ? Vì e dang ở tỉnh', '5-21-2015', 'K03'),
(7, 'Dan', '', '', 'Em năm nay 21 tuỗi, bị đau ỡ 1 vùng bên tai tai trái và há miệng ra hơi đau, vùng hàm có hơi bị xưng mất cân đối, em đã đi khám ỡ bệnh viện Trợ rẫy, và chụp CT, bác sĩ bão là viêm khớp cắn, cho thuốc uống có giãm và há miệng bình thường nhưng khi cắn chặc và hơi nghiến răng thì có cãm giác thốn ỡ bên tai. E đi tái khám thì bác sĩ bão khồng cần uống thuôc nữa. Bây giờ đã gần nữa tháng nhưng hiện tương thốn ỡ bên tai vẫn còn, có cãm giác nặng bên lỗ tai . E muốn biết có phãi bị viêm khơp cắn không và e muốn đi khám thì đk khoa nào ạ ?', '5-21-2015', 'K03'),
(8, 'Hoang', '', '', 'Thưa Bác sỹ cho em hỏi trên đầu em bị nổi rất nhiều mụn có mủ, em có đi khám ở bệnh viện một lần Bác sỹ chẩn đoán là viêm da mủ nhưng em uống thuốc mà vẫn không hết, ban đầu thì hết nhưng sau đó lại nổi lên lại. em không biết phải làm sao mới hết, vì mỗi lần đụng vào những mụn đó rất đau và em thấy tóc mình cũng bị rụng nhiều nữa. mong Bác sỹ tư vấn giúp em, Em xin cám ơn bác sỹ nhiều.', '5-21-2015', 'K04'),
(9, 'Van', '', '', 'Ba tôi năm nay đã 85 tuổi, thời gian gần đây các đầu ngón chân bị sưng và loét, có ngón đã mất móng. gia đình tôi cho rằng bị nấm hay nhiễm trùng gì đó. Tôi sợ ba tôi bị tắc mạch máu. Vậy Bs cho tôi hỏi: Tôi nên đưa ba tôi khám ở đâu? Các khả năng điều trị? Có phải phẫu thuật không?', '5-21-2015', 'K04'),
(10, 'Toan', '', '', 'Chào bs.. cháu điều trị mụn dk 4 tháng rồi.. nay đã giảm và gần như là hết. nhưng bây giờ còn nhìu thẹo và vết lõm. Cho cháu hỏi làm cách gì để giảm bớt ko ạ.. và nên kiên ăn gì k ạ. Cháu cám ơn ', '5-21-2015', 'K05'),
(11, 'Ha', '', '', 'Chào bác sĩ. Trước đây tôi đeo bông tai và bị em bé kéo rách tai làm cho lỗ đeo bông tai bị rộng ra. Nay tôi muốn thu hẹp lỗ đeo bông tai có được không ? nếu có tôi phải khám tại phòng khám nào và chi phí là bao nhiêu ạ. Cảm ơn bác sĩ', '5-21-2015', 'K05'),
(12, '', '999999', 'dragon@gmail.com', 'Dao gan day toi mua thi, em thuong xuyen hay bi dau nua dau, em rat lo lang vi sap toi la em thi dai hoc roi, bac si co cach nao giup em khong a ?', '5-28-2015', 'K01');

-- --------------------------------------------------------

--
-- Table structure for table `khambenh`
--

CREATE TABLE IF NOT EXISTS `khambenh` (
  `MaLichKham` int(11) NOT NULL,
  `MaBS` varchar(5) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khambenh`
--

INSERT INTO `khambenh` (`MaLichKham`, `MaBS`) VALUES
(1, 'BS01'),
(1, 'BS03'),
(1, 'BS05'),
(1, 'BS07'),
(1, 'BS09'),
(3, 'BS01'),
(3, 'BS03'),
(3, 'BS05'),
(3, 'BS07'),
(3, 'BS09'),
(5, 'BS01'),
(5, 'BS03'),
(5, 'BS05'),
(5, 'BS07'),
(5, 'BS09'),
(7, 'BS01'),
(7, 'BS03'),
(7, 'BS05'),
(7, 'BS07'),
(7, 'BS09'),
(9, 'BS01'),
(9, 'BS03'),
(9, 'BS05'),
(9, 'BS07'),
(9, 'BS09'),
(11, 'BS01'),
(11, 'BS03'),
(11, 'BS05'),
(11, 'BS07'),
(11, 'BS09'),
(13, 'BS01'),
(13, 'BS03'),
(13, 'BS05'),
(13, 'BS07'),
(13, 'BS09');

-- --------------------------------------------------------

--
-- Table structure for table `khoa`
--

CREATE TABLE IF NOT EXISTS `khoa` (
  `MaKhoa` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `TenKhoa` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khoa`
--

INSERT INTO `khoa` (`MaKhoa`, `TenKhoa`) VALUES
('K01', 'Thần Kinh'),
('K02', 'Tim Mạch'),
('K03', 'Răng - Hàm - Mặt'),
('K04', 'Da Liễu'),
('K05', 'Chỉnh Hình');

-- --------------------------------------------------------

--
-- Table structure for table `lichkham`
--

CREATE TABLE IF NOT EXISTS `lichkham` (
  `MaLichKham` int(11) NOT NULL,
  `TenLichKham` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lichkham`
--

INSERT INTO `lichkham` (`MaLichKham`, `TenLichKham`) VALUES
(1, 'Sáng thứ Hai'),
(2, 'Chiều thứ Hai'),
(3, 'Sáng thứ Ba'),
(4, 'Chiều thứ Ba'),
(5, 'Sáng thứ Tư'),
(6, 'Chiều thứ Tư'),
(7, 'Sáng thứ Năm'),
(8, 'Chiều thứ Năm'),
(9, 'Sáng thứ Sáu'),
(10, 'Chiều thứ Sáu'),
(11, 'Sáng thứ Bảy'),
(12, 'Chiều thứ Bảy'),
(13, 'Sáng Chủ Nhật'),
(14, 'Chiều Chủ Nhật');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidk`
--

CREATE TABLE IF NOT EXISTS `nguoidk` (
`MaNguoiDK` int(11) NOT NULL,
  `TenNguoiDK` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SoDienThoai` varchar(20) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `NgayKham` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `MaKhoa` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `XacNhan` int(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nguoidk`
--

INSERT INTO `nguoidk` (`MaNguoiDK`, `TenNguoiDK`, `SoDienThoai`, `NgayKham`, `MaKhoa`, `XacNhan`) VALUES
(1, 'Thien', '474758', '5-24-2015 ', 'K02', 1),
(2, 'Hoang', '094545454', '5-23-2015 ', 'K02', 1),
(3, 'Nguyen', '0999999', '5-23-2015 ', 'K05', 1),
(4, 'Nhan', '016879456', '5-30-2015 ', 'K01', 0),
(5, 'Nhap', '123456789', '5-25-2015 ', 'K03', 0),
(6, 'Vy', '1234567', '5-27-2015 ', 'K02', 1),
(7, 'Huy', '12345678', '5-30-2015 ', 'K02', 0),
(8, 'Hien', '016661987', '5-28-2015 ', 'K01', 0),
(9, 'Hung', '989089', '5-27-2015 ', 'K03', 1),
(10, 'Khang', '01675321', '5-22-2015 ', 'K01', 0),
(11, 'Nhung', '090629', '5-23-2015 ', 'K02', 0),
(12, 'Ha', '01999666', '5-21-2015 ', 'K03', 0),
(13, 'Nguyet', '0159357', '5-23-2015 ', 'K03', 0),
(14, 'Vuong', '0166605775', '5-22-2015 ', 'K05', 0),
(15, 'Uy', '567', '5-23-2015 ', 'K03', 0),
(16, 'Khuong', '1076', '5-24-2015 ', 'K04', 1),
(17, 'Hong', '0166543210', '5-23-2015 ', 'K04', 1),
(19, 'Van', '01666000', '5-23-2015 ', 'K05', 1),
(20, 'Kien', '890098', '5-20-2015 ', 'K02', 1),
(23, 'Hoa', '11111', '5-23-2015 ', 'K01', 1),
(24, 'Bong', '2222', '5-23-2015 ', 'K01', 1),
(25, 'Cuc', '3333', '5-24-2015 ', 'K02', 1),
(26, 'Luan', '988989', '5-24-2015 ', 'K05', 1),
(27, 'Toan', '01219756', '5-25-2015 ', 'K02', 1),
(29, 'Vinh', '0123456', '5-23-2015 ', 'K03', 1),
(30, 'Tuy', '0159753654', '5-30-2015 ', 'K05', 1);

--
-- Triggers `nguoidk`
--
DELIMITER //
CREATE TRIGGER `trigger_STT` AFTER UPDATE ON `nguoidk`
 FOR EACH ROW IF ((old.XacNhan=0) and (new.XacNhan = 1))THEN
    	begin
            declare STT int;
            
            select count(*) into STT 
            from nguoidk
            where ngaykham=old.NgayKham and XacNhan=1
            group by ngaykham;
            
            insert into dkkhambenh(MaNguoiDK,STT) values 										(new.MaNguoiDK,STT);
    	end;
    end if
//
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bacsi`
--
ALTER TABLE `bacsi`
 ADD PRIMARY KEY (`MaBS`);

--
-- Indexes for table `dap`
--
ALTER TABLE `dap`
 ADD PRIMARY KEY (`MaHoi`,`MaBS`);

--
-- Indexes for table `dkkhambenh`
--
ALTER TABLE `dkkhambenh`
 ADD PRIMARY KEY (`MaNguoiDK`);

--
-- Indexes for table `hoi`
--
ALTER TABLE `hoi`
 ADD PRIMARY KEY (`MaHoi`);

--
-- Indexes for table `khambenh`
--
ALTER TABLE `khambenh`
 ADD PRIMARY KEY (`MaLichKham`,`MaBS`);

--
-- Indexes for table `khoa`
--
ALTER TABLE `khoa`
 ADD PRIMARY KEY (`MaKhoa`);

--
-- Indexes for table `lichkham`
--
ALTER TABLE `lichkham`
 ADD PRIMARY KEY (`MaLichKham`);

--
-- Indexes for table `nguoidk`
--
ALTER TABLE `nguoidk`
 ADD PRIMARY KEY (`MaNguoiDK`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoi`
--
ALTER TABLE `hoi`
MODIFY `MaHoi` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `nguoidk`
--
ALTER TABLE `nguoidk`
MODIFY `MaNguoiDK` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
