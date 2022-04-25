/* 매장정보 */
DROP TABLE s1_store 
	CASCADE CONSTRAINTS;

/* 주소정보 */
DROP TABLE s1_zipcode 
	CASCADE CONSTRAINTS;

/* 상품카테고리 */
DROP TABLE s1_category 
	CASCADE CONSTRAINTS;

/* 상품정보 */
DROP TABLE s1_pd 
	CASCADE CONSTRAINTS;

/* 매출정보 */
DROP TABLE s1_to 
	CASCADE CONSTRAINTS;

/* 주문정보 */
DROP TABLE s1_od 
	CASCADE CONSTRAINTS;

/* 주문상제정보 */
DROP TABLE s1_oddt 
	CASCADE CONSTRAINTS;

/* 회원정보 */
DROP TABLE s1_mem 
	CASCADE CONSTRAINTS;

/* 정산현황 */
DROP TABLE s1_cal 
	CASCADE CONSTRAINTS;

/* 진행주문정보 */
DROP TABLE s1_oding 
	CASCADE CONSTRAINTS;

/* 매장정보 */
CREATE TABLE s1_store (
	st_no NUMBER NOT NULL, /* 매장번호 */
	st_name VARCHAR2(20) NOT NULL, /* 매장이름 */
	st_id VARCHAR2(20) NOT NULL, /* 매장ID */
	st_pw VARCHAR2(20) NOT NULL, /* 매장PW */
	st_tel VARCHAR2(20), /* 매장전화번호 */
	zip_seq NUMBER NOT NULL /* 매장주소정보 */
);

COMMENT ON TABLE s1_store IS '매장정보';

COMMENT ON COLUMN s1_store.st_no IS '매장번호';

COMMENT ON COLUMN s1_store.st_name IS '매장이름';

COMMENT ON COLUMN s1_store.st_id IS '매장ID';

COMMENT ON COLUMN s1_store.st_pw IS '매장PW';

COMMENT ON COLUMN s1_store.st_tel IS '매장전화번호';

COMMENT ON COLUMN s1_store.zip_seq IS '매장주소정보';

CREATE UNIQUE INDEX PK_s1_store
	ON s1_store (
		st_no ASC
	);

ALTER TABLE s1_store
	ADD
		CONSTRAINT PK_s1_store
		PRIMARY KEY (
			st_no
		);

/* 주소정보 */
CREATE TABLE s1_zipcode (
	zip_code VARCHAR2(20), /* 우편번호 */
	zip_si VARCHAR2(20) NOT NULL, /* 시 */
	zip_gugun VARCHAR2(20) NOT NULL, /* 구군 */
	zip_dong VARCHAR2(20) NOT NULL, /* 동 */
	zip_sbunji VARCHAR2(20), /* 시작번지 */
	zip_ebunji VARCHAR2(20), /* 끝번지 */
	zip_seq NUMBER NOT NULL /* 번호 */
);

COMMENT ON TABLE s1_zipcode IS '주소정보';

COMMENT ON COLUMN s1_zipcode.zip_code IS '우편번호';

COMMENT ON COLUMN s1_zipcode.zip_si IS '시';

COMMENT ON COLUMN s1_zipcode.zip_gugun IS '구군';

COMMENT ON COLUMN s1_zipcode.zip_dong IS '동';

COMMENT ON COLUMN s1_zipcode.zip_sbunji IS '시작번지';

COMMENT ON COLUMN s1_zipcode.zip_ebunji IS '끝번지';

COMMENT ON COLUMN s1_zipcode.zip_seq IS '번호';

CREATE UNIQUE INDEX PK_s1_zipcode
	ON s1_zipcode (
		zip_seq ASC
	);

ALTER TABLE s1_zipcode
	ADD
		CONSTRAINT PK_s1_zipcode
		PRIMARY KEY (
			zip_seq
		);

/* 상품카테고리 */
CREATE TABLE s1_category (
	cate_no NUMBER NOT NULL, /* 카테고리번호 */
	cate_name VARCHAR2(20) NOT NULL /* 카테고리명 */
);

COMMENT ON TABLE s1_category IS '상품카테고리';

COMMENT ON COLUMN s1_category.cate_no IS '카테고리번호';

COMMENT ON COLUMN s1_category.cate_name IS '카테고리명';

CREATE UNIQUE INDEX PK_s1_category
	ON s1_category (
		cate_no ASC
	);

ALTER TABLE s1_category
	ADD
		CONSTRAINT PK_s1_category
		PRIMARY KEY (
			cate_no
		);

/* 상품정보 */
CREATE TABLE s1_pd (
	cate_no NUMBER, /* 카테고리번호 */
	pd_no NUMBER NOT NULL, /* 상품번호 */
	pd_name VARCHAR2(20) NOT NULL, /* 상품명 */
	pd_price NUMBER NOT NULL, /* 상품가격 */
	pd_img CLOB /* 이미지 */
);

COMMENT ON TABLE s1_pd IS '상품정보';

COMMENT ON COLUMN s1_pd.cate_no IS '카테고리번호';

COMMENT ON COLUMN s1_pd.pd_no IS '상품번호';

COMMENT ON COLUMN s1_pd.pd_name IS '상품명';

COMMENT ON COLUMN s1_pd.pd_price IS '상품가격';

COMMENT ON COLUMN s1_pd.pd_img IS '이미지';

CREATE UNIQUE INDEX PK_s1_pd
	ON s1_pd (
		pd_no ASC
	);

ALTER TABLE s1_pd
	ADD
		CONSTRAINT PK_s1_pd
		PRIMARY KEY (
			pd_no
		);

/* 매출정보 */
CREATE TABLE s1_to (
	st_no NUMBER NOT NULL, /* 매장번호 */
	od_number NUMBER, /* 주문번호 */
	to_total NUMBER NOT NULL, /* 판매가격 */
	to_date DATE NOT NULL, /* 판매일자 */
	to_pay VARCHAR2(20) NOT NULL /* 결제수단 */
);

COMMENT ON TABLE s1_to IS '매출정보';

COMMENT ON COLUMN s1_to.st_no IS '매장번호';

COMMENT ON COLUMN s1_to.od_number IS '주문번호';

COMMENT ON COLUMN s1_to.to_total IS '판매가격';

COMMENT ON COLUMN s1_to.to_date IS '판매일자';

COMMENT ON COLUMN s1_to.to_pay IS '결제수단';

/* 주문정보 */
CREATE TABLE s1_od (
	od_number NUMBER NOT NULL, /* 주문번호 */
	st_no NUMBER NOT NULL, /* 매장번호 */
	od_total NUMBER NOT NULL, /* 판매가격 */
	od_date DATE NOT NULL /* 주문일자 */
);

COMMENT ON TABLE s1_od IS '주문정보';

COMMENT ON COLUMN s1_od.od_number IS '주문번호';

COMMENT ON COLUMN s1_od.st_no IS '매장번호';

COMMENT ON COLUMN s1_od.od_total IS '판매가격';

COMMENT ON COLUMN s1_od.od_date IS '주문일자';

CREATE UNIQUE INDEX PK_s1_od
	ON s1_od (
		od_number ASC
	);

ALTER TABLE s1_od
	ADD
		CONSTRAINT PK_s1_od
		PRIMARY KEY (
			od_number
		);

/* 주문상제정보 */
CREATE TABLE s1_oddt (
	st_no NUMBER NOT NULL, /* 매장번호 */
	od_number NUMBER NOT NULL, /* 주문번호 */
	pd_no NUMBER NOT NULL, /* 상품번호 */
	oddt_cnt NUMBER, /* 수량 */
	oddt_io VARCHAR2(2), /* 매장이용여부 */
	oddt_ice VARCHAR2(2), /* 얼음 */
	oddt_shot VARCHAR2(2) /* 샷추가 */
);

COMMENT ON TABLE s1_oddt IS '주문상제정보';

COMMENT ON COLUMN s1_oddt.st_no IS '매장번호';

COMMENT ON COLUMN s1_oddt.od_number IS '주문번호';

COMMENT ON COLUMN s1_oddt.pd_no IS '상품번호';

COMMENT ON COLUMN s1_oddt.oddt_cnt IS '수량';

COMMENT ON COLUMN s1_oddt.oddt_io IS '매장이용여부';

COMMENT ON COLUMN s1_oddt.oddt_ice IS '얼음';

COMMENT ON COLUMN s1_oddt.oddt_shot IS '샷추가';

/* 회원정보 */
CREATE TABLE s1_mem (
	mem_no NUMBER NOT NULL, /* 회원번호 */
	mem_name VARCHAR2(20) NOT NULL, /* 이름 */
	mem_id VARCHAR2(20) NOT NULL, /* ID */
	mem_pw VARCHAR2(20) NOT NULL, /* PW */
	mem_birth VARCHAR2(20), /* 생년월일 */
	mem_tel VARCHAR2(30), /* 전화번호 */
	mem_coupon NUMBER, /* 쿠폰개수 */
	mem_stamp NUMBER /* 쿠폰카운트 */
);

COMMENT ON TABLE s1_mem IS '회원정보';

COMMENT ON COLUMN s1_mem.mem_no IS '회원번호';

COMMENT ON COLUMN s1_mem.mem_name IS '이름';

COMMENT ON COLUMN s1_mem.mem_id IS 'ID';

COMMENT ON COLUMN s1_mem.mem_pw IS 'PW';

COMMENT ON COLUMN s1_mem.mem_birth IS '생년월일';

COMMENT ON COLUMN s1_mem.mem_tel IS '전화번호';

COMMENT ON COLUMN s1_mem.mem_coupon IS '쿠폰개수';

COMMENT ON COLUMN s1_mem.mem_stamp IS '쿠폰카운트';

CREATE UNIQUE INDEX PK_s1_mem
	ON s1_mem (
		mem_no ASC
	);

ALTER TABLE s1_mem
	ADD
		CONSTRAINT PK_s1_mem
		PRIMARY KEY (
			mem_no
		);

/* 정산현황 */
CREATE TABLE s1_cal (
	st_no NUMBER, /* 매장번호 */
	cal_scash NUMBER, /* 개점준비금 */
	cal_ecash NUMBER, /* 마감현금 */
	cal_ecard NUMBER, /* 마감카드 */
	cal_sum NUMBER, /* 당일정산 */
	cal_date DATE /* 마감일 */
);

COMMENT ON TABLE s1_cal IS '정산현황';

COMMENT ON COLUMN s1_cal.st_no IS '매장번호';

COMMENT ON COLUMN s1_cal.cal_scash IS '개점준비금';

COMMENT ON COLUMN s1_cal.cal_ecash IS '마감현금';

COMMENT ON COLUMN s1_cal.cal_ecard IS '마감카드';

COMMENT ON COLUMN s1_cal.cal_sum IS '당일정산';

COMMENT ON COLUMN s1_cal.cal_date IS '마감일';

/* 진행주문정보 */
CREATE TABLE s1_oding (
	od_number NUMBER /* 주문번호 */
);

COMMENT ON TABLE s1_oding IS '진행주문정보';

COMMENT ON COLUMN s1_oding.od_number IS '주문번호';

ALTER TABLE s1_store
	ADD
		CONSTRAINT FK_s1_zipcode_TO_s1_store
		FOREIGN KEY (
			zip_seq
		)
		REFERENCES s1_zipcode (
			zip_seq
		);

ALTER TABLE s1_pd
	ADD
		CONSTRAINT FK_s1_category_TO_s1_pd
		FOREIGN KEY (
			cate_no
		)
		REFERENCES s1_category (
			cate_no
		);

ALTER TABLE s1_to
	ADD
		CONSTRAINT FK_s1_store_TO_s1_to
		FOREIGN KEY (
			st_no
		)
		REFERENCES s1_store (
			st_no
		);

ALTER TABLE s1_to
	ADD
		CONSTRAINT FK_s1_od_TO_s1_to
		FOREIGN KEY (
			od_number
		)
		REFERENCES s1_od (
			od_number
		)
		ON DELETE CASCADE;

ALTER TABLE s1_od
	ADD
		CONSTRAINT FK_s1_store_TO_s1_od
		FOREIGN KEY (
			st_no
		)
		REFERENCES s1_store (
			st_no
		);

ALTER TABLE s1_oddt
	ADD
		CONSTRAINT FK_s1_store_TO_s1_oddt
		FOREIGN KEY (
			st_no
		)
		REFERENCES s1_store (
			st_no
		);

ALTER TABLE s1_oddt
	ADD
		CONSTRAINT FK_s1_od_TO_s1_oddt
		FOREIGN KEY (
			od_number
		)
		REFERENCES s1_od (
			od_number
		)
		ON DELETE CASCADE;

ALTER TABLE s1_oddt
	ADD
		CONSTRAINT FK_s1_pd_TO_s1_oddt
		FOREIGN KEY (
			pd_no
		)
		REFERENCES s1_pd (
			pd_no
		);

ALTER TABLE s1_cal
	ADD
		CONSTRAINT FK_s1_store_TO_s1_cal
		FOREIGN KEY (
			st_no
		)
		REFERENCES s1_store (
			st_no
		);

ALTER TABLE s1_oding
	ADD
		CONSTRAINT FK_s1_od_TO_s1_oding
		FOREIGN KEY (
			od_number
		)
		REFERENCES s1_od (
			od_number
		)
		ON DELETE CASCADE;