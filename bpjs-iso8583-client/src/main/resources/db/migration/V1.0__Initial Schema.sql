create table inquiry_bpjs (

    id VARCHAR(36),
    idpel VARCHAR(12) NOT NULL,
    tanggal_tagihan DATE,
    tanggal_jatuh_tempo DATE,
    nilai DECIMAL(19,2),
    status VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)

) Engine=InnoDB;