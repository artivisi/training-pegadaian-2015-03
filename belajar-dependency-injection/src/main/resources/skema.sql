create table produk (
    id INT PRIMARY KEY AUTO_INCREMENT,
    kode VARCHAR(255) NOT NULL UNIQUE,
    nama VARCHAR(255) NOT NULL,
    harga DECIMAL(19,2) NOT NULL
) Engine=InnoDB ;