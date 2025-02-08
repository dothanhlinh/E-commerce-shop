USE shopapp;
-- Khách hàng khi muốn mua hàng => phải đăng ký tài khoản => bảng users
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100) DEFAULT '',
    phone_number VARCHAR(15) NOT NULL,
    address VARCHAR(200) DEFAULT '',
    password VARCHAR(100) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- CURRENT_TIMESTAMP Tự động lưu thời gian khi bản ghi được tạo
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, --CURRENT_TIMESTAMP Tự động lưu thời gian khi bản ghi được cập nhật
    is_active TINYINT(1) DEFAULT 1,
    date_of_birth DATE,
    facebook_account_id INT DEFAULT 0,
    google_account_id INT DEFAULT 0
);

alter TABLE users add column role_id INT
CREATE TABLE roles (
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
);
alter TABLE users add FOREIGN KEY (role_id) INT REFERENCES roles(id)

CREATE TABLE tokens(
    id INT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) UNIQUE NOT NULL,
    phone_type VARCHAR(50) NOT NULL,
    expiration_date DATETIME,
    revoked TINYINT(1) NOT NULL,
    expired TINYINT(1) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- hỗ trợ đăng nhập từ facebook và google
CREATE TABLE social_accounts(
    id INT PRIMARY KEY AUTO_INCREMENT,
    provider VARCHAR(20) NOT NULL COMMENT 'Tên nhà social network',
    provider_id VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL COMMENT 'Email tài khoản',
    name VARCHAR(100) NOT NULL COMMENT 'Tên người dùng',
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Bảng danh mục sản phẩm

CREATE TABLE categories(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'Tên danh mục, vd: Đồ điện tử'
);

--Bảng chứa sản phẩm(Product)
CREATE TABLE products(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(350) COMMENT 'Tên sản phẩm, vd: Dây điện',
    price FLOAT NOT NULL,
    thumbnail VARCHAR DEFAULT '',
    description LONGTEXT DEFAULT '',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- Đặt hàng 
CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    fullname VARCHAR(100) DEFAULT '',
    email VARCHAR(100) DEFAULT '',
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR(200) NOT NULL,
    note VARCHAR(100) DEFAULT '',
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20),
    total_money FLOAT
);

alter TABLE orders add column  `shipping_method` VARCHAR(100)
alter TABLE orders add column  `shipping_address` VARCHAR(200)
alter TABLE orders add column  `shipping_date` DATE
alter TABLE orders add column  `tracking_number` VARCHAR(100)
alter TABLE orders add column  `payment_method` VARCHAR(100)
alter TABLE orders add column  `active` TINYINT(100);

-- Trạng thái đơn hàng chỉ được phép nhận " Một số giá trị cụ thể"
alter TABLE orders
modify column status enum('pending', 'processing','shipped', 'delivered','cancelled') 
COMMENT 'Trạng thái đơn hàng';

-- Chi tiết đơn hàng
CREATE TABLE order_details(
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id), 
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES products(id),
    price FLOAT,
    number_of_products INT,
    total_money FLOAT,
    color VARCHAR(20) DEFAULT ''    
);
