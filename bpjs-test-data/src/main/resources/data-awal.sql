delete from pembayaran;
delete from tagihan;
delete from peserta;

insert into peserta (id, nomer, nama)
values ('abc123', '1234567890', 'Endy Muhardin');

insert into tagihan (id, id_peserta, tanggal_tagihan, tanggal_jatuh_tempo, nilai, lunas)
values ('t001', 'abc123', '2015-03-01', '2015-03-20', 100000, false);