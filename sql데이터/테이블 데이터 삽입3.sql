select * from s1_zipcode where zip_dong like '%���ǵ�%';

insert into s1_zipcode
values(12021,'�����ֽ�','������','������','499-11','',61441);

--��������

select * from s1_store;
select st_pw from s1_store where st_id = 'sinchon';


insert into s1_store
values (1,'������','sinchon','1234','010-1234-1234',34365);

insert into s1_store
values (2,'�븲��','daerim','1234','010-1234-1234',47854);

insert into s1_store
values (3,'��������','namyang','1234','010-1234-1234',61441);

insert into s1_store
values (4,'���ǵ���','yeouido','1234','010-1234-1234',49774);


select * from s1_category;

insert into s1_category
values (1,'coffee');
insert into s1_category
values (2,'non-cof');
insert into s1_category
values (3,'iced');
insert into s1_category
values (4,'ade');
insert into s1_category
values (5,'tea');
insert into s1_category
values (6,'side');


select * from s1_pd;

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,1,'����������',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,2,'�Ƹ޸�ī��',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,3,'īǪġ��',2500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,4,'ī���',2500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,5,'ī���ī',2500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,6,'������Ӷ�',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,7,'��ü��',3000);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,8,'���ڶ�',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,9,'�׸�Ƽ��',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,10,'������',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,11,'���',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,12,'��Ű���ڶ�',3000);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,13,'�ڹ�Ĩ������',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,14,'��Ʈ������',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,15,'�׸�Ƽ������',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,16,'���⽺����',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,17,'��������',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,18,'���ڽ�����',3500);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,19,'�����̵�',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,20,'�ڸ����̵�',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,21,'�����̵�',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,22,'���ڿ��̵�',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,23,'Ű���ֽ�',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,24,'�������ֽ�',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,25,'�������ֽ�',3500);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,26,'���Ƽ',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,27,'ȫ��',2500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,28,'����ڸ�Ƽ',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,29,'��Ϸ���Ƽ',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,30,'������Ƽ',3500);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,31,'���ڸ�ī��',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,32,'���⸶ī��',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,33,'��ī��ī��',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,34,'�ó������',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,35,'�ٳ�������',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,36,'Ƽ��̽�',5000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,37,'��Ϻ극��',5000);


select * from s1_mem;
select * from user_sequences;
commit;

create sequence s1_mem_seq
increment by 1
start with 1
nocache;

create sequence s1_order_seq
increment by 1
start with 1
nocache;



commit;


insert into s1_mem
values(1,'ȫ�浿','testuser','1234','941215','010-1111-1111',5,9);
commit;

create sequence s1_od_seq
increment by 1
start with 1
nocache;
commit;


drop sequence s1_mem_seq;

create sequence s1_mem_seq
increment by 1
start with 2
nocache;


--ȯ��-�ֹ���ȣ ���� on delete cascade
/* 
ALTER TABLE s1_oding
drop constraint FK_S1_OD_TO_S1_oding;

alter table s1_oding
add constraint fk_s1_od_to_s1_oding foreign key(od_number)
references s1_od(od_number) on delete cascade;

ALTER TABLE s1_oddt
drop constraint FK_S1_OD_TO_S1_oddt;

alter table s1_oddt
add constraint fk_s1_od_to_s1_oddt foreign key(od_number)
references s1_od(od_number) on delete cascade;

ALTER TABLE s1_to
drop constraint FK_S1_OD_TO_S1_to;

alter table s1_to
add constraint fk_s1_od_to_s1_to foreign key(od_number)
references s1_od(od_number) on delete cascade;
*/
commit;

select * from s1_pd;
update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\1.png'
where pd_no = 1;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\2.png'
where pd_no = 2;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\3.png'
where pd_no = 3;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\4.png'
where pd_no = 4;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\5.png'
where pd_no = 5;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\6.png'
where pd_no = 6;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\7.png'
where pd_no = 7;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\8.png'
where pd_no = 8;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\9.png'
where pd_no = 9;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\10.png'
where pd_no = 10;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\11.png'
where pd_no = 11;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\12.png'
where pd_no = 12;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\13.png'
where pd_no = 13;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\14.png'
where pd_no = 14;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\15.png'
where pd_no = 15;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\16.png'
where pd_no = 16;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\17.png'
where pd_no = 17;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\18.png'
where pd_no = 18;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\19.png'
where pd_no = 19;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\20.png'
where pd_no = 20;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\21.png'
where pd_no = 21;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\22.png'
where pd_no = 22;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\23.png'
where pd_no = 23;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\24.png'
where pd_no = 24;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\25.png'
where pd_no = 25;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\26.png'
where pd_no = 26;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\27.png'
where pd_no = 27;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\28.png'
where pd_no = 28;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\29.png'
where pd_no = 29;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\30.png'
where pd_no = 30;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\31.png'
where pd_no = 31;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\32.png'
where pd_no = 32;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\33.png'
where pd_no = 33;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\34.png'
where pd_no = 34;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\35.png'
where pd_no = 35;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\36.png'
where pd_no = 36;

update s1_pd
set pd_img = 'src\\main\\java\\dbimg\\37.png'
where pd_no = 37;
commit;

