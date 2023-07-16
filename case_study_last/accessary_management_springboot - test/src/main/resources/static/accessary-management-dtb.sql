create database accessary_management;
use accessary_management;
CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    is_active TINYINT(1) DEFAULT 1 NULL,
    name VARCHAR(255) NULL
)  ENGINE=MYISAM;
CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    detail VARCHAR(255) NULL,
    image VARCHAR(255) NULL,
    is_active TINYINT(1) DEFAULT 1 NULL,
    name VARCHAR(100) NULL,
    category_id BIGINT NULL
)  ENGINE=MYISAM;

create index FKog2rp4qthbtt2lfyhfo32lsw9
    on products (category_id);
CREATE TABLE variants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    price DOUBLE NULL,
    product_id BIGINT NULL,
    size VARCHAR(255) NULL,
    is_active TINYINT(1) DEFAULT 1 NULL,
    origin_name VARCHAR(255) NULL
)  ENGINE=MYISAM;

create index FK95bued017vcya4rf4s7n31ew4
    on variants (product_id);
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NULL,
    name VARCHAR(255) NULL
);
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NULL,
    is_active TINYINT(1) DEFAULT 1 NULL,
    password VARCHAR(255) NULL,
    activated BIT NULL,
    address VARCHAR(255) NULL,
    avatar VARCHAR(255) NULL,
    fullname VARCHAR(255) NULL,
    phone VARCHAR(255) NULL,
    remember_token VARCHAR(255) NULL,
    username VARCHAR(255) NULL,
    role_id BIGINT NOT NULL
)  ENGINE=MYISAM;

create index FKp56c1712k691lhsyewcssf40f
    on users (role_id);