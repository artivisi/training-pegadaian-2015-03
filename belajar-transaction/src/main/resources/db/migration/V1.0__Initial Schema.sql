create table running_number (
    id INT AUTO_INCREMENT,
    pemakaian VARCHAR(20),
    terakhir INT,
    PRIMARY KEY (id),
    UNIQUE KEY (pemakaian)
) Engine=InnoDB ;

create table tagihan (
    id INT AUTO_INCREMENT,
    no_tagihan VARCHAR(100) NOT NULL,
    tanggal_transaksi DATE,
    pelanggan VARCHAR(255) NOT NULL,
    keterangan VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (no_tagihan)
) Engine=InnoDB ;