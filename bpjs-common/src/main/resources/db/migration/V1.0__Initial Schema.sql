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

create table s_permission (
    id VARCHAR(36),
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
) Engine=InnoDB ;

create table s_user (
    id VARCHAR(36),
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (username)
) Engine=InnoDB ;

create table s_user_permission (
    id_user VARCHAR(255) NOT NULL,
    id_permission VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_user,id_permission),
    FOREIGN KEY (id_user) REFERENCES s_user(id),
    FOREIGN KEY (id_permission) REFERENCES s_permission(id)
) Engine=InnoDB ;