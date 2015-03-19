delete from pembayaran;
delete from tagihan;
delete from peserta;

delete from s_user_permission;
delete from s_permission;
delete from s_user;

insert into peserta (id, nomer, nama)
values ('abc123', '1234567890', 'Endy Muhardin');

insert into tagihan (id, id_peserta, tanggal_tagihan, tanggal_jatuh_tempo, nilai, lunas)
values ('t001', 'abc123', '2015-03-01', '2015-03-20', 100000, false);

insert into s_permission (id, name) values 
('p001', 'BPJS_INQUIRY'),
('p002', 'BPJS_PAYMENT');

insert into s_user (id, username, password) values 
('u001', 'endy', '123'),
('u002', 'lukman', '123');

insert into s_user_permission (id_user, id_permission) values 
('u001', 'p001'),
('u002', 'p001'),
('u002', 'p002');