
CREATE DATABASE ApartmentDB;
USE ApartmentDB;
 
CREATE TABLE IF NOT EXISTS Account (
	id_account INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(100) NOT NULL,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(150) NOT NULL,
    amount BIGINT,
    role int NOT NULL,
    is_active INT NOT NULL,
    create_at date,
    verify INT,
    image VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS City (
    id_city INT PRIMARY KEY,
    name_city VARCHAR(50)
);
 
CREATE TABLE IF NOT EXISTS District (
    id_district INT PRIMARY KEY,
    name_district VARCHAR(50),
    id_city INT,
    CONSTRAINT FK_ThanhPho_idQsuan FOREIGN KEY(id_city) REFERENCES City(id_city)
);
 
CREATE TABLE IF NOT EXISTS Ward (
    id_ward INT PRIMARY KEY,
    name_ward  VARCHAR(50),
    id_district INT,
    CONSTRAINT FK_Phuongs_idquan FOREIGN KEY(id_district) REFERENCES district(id_district)
);
 CREATE TABLE IF NOT EXISTS ApartmentType (
	id_type INT AUTO_INCREMENT PRIMARY KEY,
    name_type VARCHAR(50)
 );
 
CREATE TABLE IF NOT EXISTS Apartment (
    id_apartment INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    name_apartment VARCHAR(50), 
    room INT NOT NULL,
    baths int, 
    area INT NOT NULL,
    price INT NOT NULL,
    description TEXT NOT NULL,
    listing_status INT NOT NULL,
    rental_status INT NOT NULL,
    street_name VARCHAR(50),
    posting_date DATE,
    end_date DATE,
    id_ward INT NOT NULL,
	id_type INT,
    id_account INT NOT NULL,
    heart_count INT, 
    CONSTRAINT FK_Apartment_idAccount FOREIGN KEY(id_account) REFERENCES Account(id_account),
    CONSTRAINT FK_Apartment_idDistrict FOREIGN KEY(id_ward) REFERENCES ward(id_ward),
    CONSTRAINT FK_Apartment_idType FOREIGN KEY(id_type) REFERENCES ApartmentType(id_type)
);

 
CREATE TABLE IF NOT EXISTS Image (
    id_image INT AUTO_INCREMENT PRIMARY KEY,
    name_image VARCHAR(50),
    link_image VARCHAR(200),
    id_apartment INT NOT NULL,
    CONSTRAINT FK_AnhCanHo_CanHo FOREIGN KEY(id_apartment) REFERENCES Apartment(id_apartment) ON DELETE CASCADE
);

 
CREATE TABLE IF NOT EXISTS PaymentReceipt (
    id_payment INT AUTO_INCREMENT PRIMARY KEY,
    payment_date DATE,
    payment_method VARCHAR(50),
    total_amount BIGINT,
    description VARCHAR(50),
    status VARCHAR(50),
    account_id INT NOT NULL,
    CONSTRAINT FK_PaymentReceipt_AccountID FOREIGN KEY(account_id) REFERENCES Account(id_account)
);


 
INSERT INTO Account (username, password, name, phone, email, amount, role, is_active, create_at, verify, image)
VALUES
('duyanh', 'duyanh', 'Duy Anh', '888888888', 'duyanh@example.com', 50000, 0, 1, '2023-09-02', 1, null),
('seller', 'seller', 'Seller Duy Anh', '098989898', 'seller@gmail.com', 123, 1, 1, '2023-09-13', 0, null),
('lock', 'lock', 'Account Lock', '0909090980', 'lock@gmail.com', 0, 2, 0, '2023-09-2', 0, null),
('user1', 'duyanh', 'User 1', '0987654321', 'user1@gmail.com', 0, 1, 1, '2023-09-2', 0, null),
('user2', 'duyanh', 'User 2', '0987654321', 'user2@gmail.com', 0, 1, 1, '2023-09-2', 0, null),
('user3', 'duyanh', 'User 3', '0987654321', 'user3@gmail.com', 0, 1, 1, '2023-09-2', 0, null),
('user4', 'duyanh', 'User 4', '0987654321', 'user4@gmail.com', 0, 1, 1, '2023-09-2', 0, null),
('user5', 'duyanh', 'User 5', '0987654321', 'user5@gmail.com', 0, 1, 1, '2023-09-2', 0, null),
('user6', 'duyanh', 'User 6', '0987654321', 'user6@gmail.com', 0, 1, 1, '2023-09-2', 0, null),
('user7', 'duyanh', 'User 7', '0987654321', 'user7@gmail.com', 0, 1, 1, '2023-09-13', 0, null),
('user8', 'duyanh', 'User 8', '0987654321', 'user8@gmail.com', 0, 1, 1, '2023-09-13', 0, null),
('user9', 'duyanh', 'User 9', '0987654321', 'user9@gmail.com', 0, 1, 1, '2023-09-13', 0, null),
('user10', 'duyanh', 'User 10', '0987654321', 'user10@gmail.com', 0, 1, 1, '2023-09-13', 0, null);






-- -- Thêm dữ liệu vào bảng Account
-- INSERT INTO Account VALUES
-- ('admin', '21232f297a57a5a743894a0e4a801fc3', 'Quản trị viên', '0888888888', 'ndanhx@gmail.com', 999999999, 3),
-- ('duyanh', 'e10adc3949ba59abbe56e057f20f883e', 'Duy Anh', '0868888548', 'ndanhx@gmail.com', 999999999, 0),
-- ('seller', 'e10adc3949ba59abbe56e057f20f883e', 'Seller', '0123456789', 'ndanhx@gmail.com', 0, 1),
-- ('binhthuong', 'e10adc3949ba59abbe56e057f20f883e', 'Buyer', '0987654324', 'ndanhx@gmail.com', 0, 1);

-- -- Thêm dữ liệu vào bảng Tinh_ThanhPho
INSERT INTO city VALUES

(1, 'An Giang'),
(2, 'Bà Rịa - Vũng Tàu'),
(3, 'Bạc Liêu'),
(4, 'Bắc Kạn'),
(5, 'Bắc Giang'),
(6, 'Bắc Ninh'),
(7, 'Bến Tre'),
(8, 'Bình Dương'),
(9, 'Bình Định'),
(10, 'Bình Phước'),
(11, 'Bình Thuận'),
(12, 'Cà Mau'),
(13, 'Cần Thơ'),
(14, 'Cao Bằng'),
(15, 'Đà Nẵng'),
(16, 'Đắk Lắk'),
(17, 'Đắk Nông'),
(18, 'Điện Biên'),
(19, 'Đồng Nai'),
(20, 'Đồng Tháp'),
(21, 'Gia Lai'),
(22, 'Hà Giang'),
(23, 'Hà Nam'),
(24, 'Hà Nội'),
(25, 'Hà Tĩnh'),
(26, 'Hải Dương'),
(27, 'Hải Phòng'),
(28, 'Hậu Giang'),
(29, 'Hòa Bình'),
(30, 'Hưng Yên'),
(31, 'Khánh Hòa'),
(32, 'Kiên Giang'),
(33, 'Kon Tum'),
(34, 'Lai Châu'),
(35, 'Lâm Đồng'),
(36, 'Lạng Sơn'),
(37, 'Lào Cai'),
(38, 'Long An'),
(39, 'Nam Định'),
(40, 'Nghệ An'),
(41, 'Ninh Bình'),
(42, 'Ninh Thuận'),
(43, 'Phú Thọ'),
(44, 'Phú Yên'),
(45, 'Quảng Bình'),
(46, 'Quảng Nam'),
(47, 'Quảng Ngãi'),
(48, 'Quảng Ninh'),
(49, 'Quảng Trị'),
(50, 'Sóc Trăng'),
(51, 'Sơn La'),
(52, 'Tây Ninh'),
(53, 'Thái Bình'),
(54, 'Thái Nguyên'),
(55, 'Thanh Hóa'),
(56, 'Thừa Thiên-Huế'),
(57, 'Tiền Giang'),
(58, 'Trà Vinh'),
(59, 'Tuyên Quang'),
(60, 'Vĩnh Long'),
(61, 'Vĩnh Phúc'),
(62, 'Yên Bái'),
(63, 'Phú Quốc'),
(64, 'Thành Phố Hồ chí Minh');

INSERT INTO District (id_district, name_district, id_city) VALUES
(1, 'Quận 1', 64),
(2, 'Quận 2', 64),
(3, 'Quận 3', 64),
(4, 'Quận 4', 64),
(5, 'Quận 5', 64),
(6, 'Quận 6', 64),
(7, 'Quận 7', 64),
(8, 'Quận 8', 64),
(9, 'Quận 9', 64),
(10, 'Quận 10', 64),
(11, 'Quận 11', 64),
(12, 'Quận 12', 64),
(13, 'Quận Bình Thạnh', 64),
(14, 'Quận Phú Nhuận', 64),
-- ha noi
(15, 'Quận Hoàn Kiếm', 24),
(16, 'Quận Tây Hồ', 24),
(17, 'Quận Ba Đình', 24),
(18, 'Quận Hai Bà Trưng', 24),
(19, 'Quận Đống Đa', 24),
(20, 'Quận Cầu Giấy', 24),
(21, 'Quận Hoàng Mai', 24),
(22, 'Quận Long Biên', 24),
(23, 'Huyện Sóc Sơn', 24),
(24, 'Huyện Đông Anh', 24),
(25, 'Huyện Gia Lâm', 24),
(26, 'Huyện Thanh Trì', 24),
(27, 'Huyện Ba Vì', 24),
(28, 'Huyện Phúc Thọ', 24),
(29, 'Huyện Đan Phượng', 24),
(30, 'Huyện Hoài Đức', 24),
(31, 'Huyện Quốc Oai', 24),
(32, 'Huyện Thạch Thất', 24),
(33, 'Huyện Chương Mỹ', 24),
(34, 'Huyện Thanh Oai', 24),
(35, 'Huyện Mỹ Đức', 24),
(36, 'Huyện Ứng Hòa', 24),
(37, 'Huyện Thường Tín', 24),
(38, 'Huyện Phú Xuyên', 24),
(39, 'Huyện Mê Linh', 24);


INSERT INTO ward (id_ward, name_ward, id_district) VALUES
(1, 'Phường 1', 13),
(2, 'Phường 2', 13),
(3, 'Phường 3', 13),
(4, 'Phường 4', 13),
(5, 'Phường 5', 13),
(6, 'Phường 6', 13),
(7, 'Phường 7', 13),
(8, 'Phường 8', 13),
(9, 'Phường 9', 13),
(10, 'Phường 10', 13),
(11, 'Phường 11', 13),
(12, 'Phường 12', 13),
(13, 'Phường 13', 13),
(14, 'Phường 14', 13),
(15, 'Phường 15', 13),
(16, 'Phường 16', 13),
(17, 'Phường 17', 13),
(18, 'Phường 18', 13),
(19, 'Phường 19', 13),
(20, 'Phường 20', 13),
(21, 'Phường 21', 13),
(22, 'Phường 22', 13);

 

INSERT INTO ApartmentType (name_type)
VALUES
('House'),
('Single'),
('Relationship');

INSERT INTO Apartment (title,name_apartment, room, baths, area, price, description, listing_status, rental_status, street_name, posting_date, end_date, id_ward, id_type, id_account, heart_count)
VALUES
('Apartment G','Apartment G', 2, 2, 100, 1000, 'DDDDDDDDDDDDDDDDDDDDDD of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2023-09-13', '2023-09-23', 11, 1, 2, 0),

('Apartment E','Apartment E', 2, 2, 100, 1000, 'DDDDDDDDDDDDDDDDDDDDDD of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2023-09-23', 11, 1, 2, 0),

('Apartment D','Apartment D', 2, 2, 100, 1000, 'DDDDDDDDDDDDDDDDDDDDDD of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2023-09-23', 11, 1, 2, 0),

('Apartment A','Apartment A', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2023-09-23', 11, 1, 1, 0),
('Apartment B','Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-14', '2023-09-24', 22, 2, 1, 0),
('Apartment C','Apartment C', 1, 1, 60, 800, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-15', '2023-09-25', 15, 3, 1,0);
 
 
 
 

UPDATE Apartment SET  listing_status=1, rental_status=1 WHERE id_apartment=8;
UPDATE Apartment SET  listing_status=1, rental_status=1 WHERE id_apartment=9;
UPDATE Apartment SET  listing_status=1, rental_status=1 WHERE id_apartment=6; 
UPDATE Apartment SET  listing_status=1, rental_status=1 WHERE id_apartment=7;
select * from Apartment where id_apartment=8 and id_apartment=9;
















