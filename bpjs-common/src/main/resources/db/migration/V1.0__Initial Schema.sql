create table peserta (
    id INT AUTO_INCREMENT,
    ktp VARCHAR(255) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    tempat_lahir VARCHAR(255) NOT NULL,
    tanggal_lahir DATE NOT NULL,
    alamat VARCHAR(255) NOT NULL,
    kelurahan VARCHAR(255) NOT NULL,
    kecamatan VARCHAR(255) NOT NULL,
    kodepos VARCHAR(255) NOT NULL,
    no_ponsel VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (ktp),
    UNIQUE KEY (email)
) Engine=InnoDB ;