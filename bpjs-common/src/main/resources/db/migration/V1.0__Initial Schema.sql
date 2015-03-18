create table peserta (
    id VARCHAR(36),
    nomer VARCHAR(255),
    nama VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (nomer)
) Engine=InnoDB ;

create table tagihan (
    id VARCHAR(36),
    id_peserta VARCHAR(36) NOT NULL,
    tanggal_tagihan DATE NOT NULL,
    tanggal_jatuh_tempo DATE NOT NULL,
    nilai DECIMAL(19,2) NOT NULL,
    lunas BOOLEAN NOT NULL,
    PRIMARY KEY (id), 
    UNIQUE KEY (id_peserta, tanggal_tagihan),
    FOREIGN KEY (id_peserta) REFERENCES peserta(id)
) Engine=InnoDB ;

create table pembayaran (
    id VARCHAR(36),
    id_tagihan VARCHAR(36) NOT NULL,
    waktu_transaksi DATETIME NOT NULL,
    user_loket VARCHAR(255) NOT NULL,
    kode_loket VARCHAR(255) NOT NULL,
    PRIMARY KEY (id), 
    UNIQUE KEY (id_tagihan),
    FOREIGN KEY (id_tagihan) REFERENCES tagihan(id)
) Engine=InnoDB ;