select * from s1_zipcode where zip_dong like '%여의도%';

insert into s1_zipcode
values(12021,'남양주시','진접읍','진벌리','499-11','',61441);

--매장정보

select * from s1_store;
select st_pw from s1_store where st_id = 'sinchon';


insert into s1_store
values (1,'신촌점','sinchon','1234','010-1234-1234',34365);

insert into s1_store
values (2,'대림동','daerim','1234','010-1234-1234',47854);

insert into s1_store
values (3,'남양주점','namyang','1234','010-1234-1234',61441);

insert into s1_store
values (4,'여의도점','yeouido','1234','010-1234-1234',49774);


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
values (1,1,'에스프레소',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,2,'아메리카노',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,3,'카푸치노',2500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,4,'카페라떼',2500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,5,'카페모카',2500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,6,'헤이즐넛라떼',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (1,7,'돌체라떼',3000);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,8,'초코라떼',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,9,'그린티라떼',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,10,'고구마라떼',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,11,'곡물라떼',3000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (2,12,'쿠키초코라떼',3000);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,13,'자바칩프라페',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,14,'민트프라페',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,15,'그린티프라페',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,16,'딸기스무디',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,17,'망고스무디',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (3,18,'유자스무디',3500);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,19,'레몬에이드',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,20,'자몽에이드',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,21,'망고에이드',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,22,'유자에이드',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,23,'키위주스',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,24,'복숭아주스',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (4,25,'오렌지주스',3500);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,26,'허브티',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,27,'홍차',2500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,28,'허니자몽티',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,29,'허니레몬티',3500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (5,30,'복숭아티',3500);

insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,31,'초코마카롱',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,32,'딸기마카롱',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,33,'모카마카롱',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,34,'시나몬와플',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,35,'바나나와플',1500);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,36,'티라미슈',5000);
insert into s1_pd(cate_no,pd_no,pd_name,pd_price)
values (6,37,'허니브레드',5000);


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
values(1,'홍길동','testuser','1234','941215','010-1111-1111',5,9);
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


--환불-주문번호 삭제 on delete cascade
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

