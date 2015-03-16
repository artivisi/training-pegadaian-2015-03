create table running_number (
    id INT AUTO_INCREMENT,
    pemakaian VARCHAR(20) NOT NULL,
    tanggal_transaksi DATE NOT NULL,
    terakhir INT NOT NULL,
    PRIMARY KEY (id)
) Engine=InnoDB ;

create table tagihan (
    id INT AUTO_INCREMENT,
    nomer_tagihan VARCHAR(100) NOT NULL,
    waktu_transaksi DATETIME NOT NULL,
    pelanggan VARCHAR(255) NOT NULL,
    keterangan VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (nomer_tagihan)
) Engine=InnoDB ;