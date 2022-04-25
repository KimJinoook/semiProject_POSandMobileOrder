/* �������� */
DROP TABLE s1_store 
	CASCADE CONSTRAINTS;

/* �ּ����� */
DROP TABLE s1_zipcode 
	CASCADE CONSTRAINTS;

/* ��ǰī�װ� */
DROP TABLE s1_category 
	CASCADE CONSTRAINTS;

/* ��ǰ���� */
DROP TABLE s1_pd 
	CASCADE CONSTRAINTS;

/* �������� */
DROP TABLE s1_to 
	CASCADE CONSTRAINTS;

/* �ֹ����� */
DROP TABLE s1_od 
	CASCADE CONSTRAINTS;

/* �ֹ��������� */
DROP TABLE s1_oddt 
	CASCADE CONSTRAINTS;

/* ȸ������ */
DROP TABLE s1_mem 
	CASCADE CONSTRAINTS;

/* ������Ȳ */
DROP TABLE s1_cal 
	CASCADE CONSTRAINTS;

/* �����ֹ����� */
DROP TABLE s1_oding 
	CASCADE CONSTRAINTS;

/* �������� */
CREATE TABLE s1_store (
	st_no NUMBER NOT NULL, /* �����ȣ */
	st_name VARCHAR2(20) NOT NULL, /* �����̸� */
	st_id VARCHAR2(20) NOT NULL, /* ����ID */
	st_pw VARCHAR2(20) NOT NULL, /* ����PW */
	st_tel VARCHAR2(20), /* ������ȭ��ȣ */
	zip_seq NUMBER NOT NULL /* �����ּ����� */
);

COMMENT ON TABLE s1_store IS '��������';

COMMENT ON COLUMN s1_store.st_no IS '�����ȣ';

COMMENT ON COLUMN s1_store.st_name IS '�����̸�';

COMMENT ON COLUMN s1_store.st_id IS '����ID';

COMMENT ON COLUMN s1_store.st_pw IS '����PW';

COMMENT ON COLUMN s1_store.st_tel IS '������ȭ��ȣ';

COMMENT ON COLUMN s1_store.zip_seq IS '�����ּ�����';

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

/* �ּ����� */
CREATE TABLE s1_zipcode (
	zip_code VARCHAR2(20), /* �����ȣ */
	zip_si VARCHAR2(20) NOT NULL, /* �� */
	zip_gugun VARCHAR2(20) NOT NULL, /* ���� */
	zip_dong VARCHAR2(20) NOT NULL, /* �� */
	zip_sbunji VARCHAR2(20), /* ���۹��� */
	zip_ebunji VARCHAR2(20), /* ������ */
	zip_seq NUMBER NOT NULL /* ��ȣ */
);

COMMENT ON TABLE s1_zipcode IS '�ּ�����';

COMMENT ON COLUMN s1_zipcode.zip_code IS '�����ȣ';

COMMENT ON COLUMN s1_zipcode.zip_si IS '��';

COMMENT ON COLUMN s1_zipcode.zip_gugun IS '����';

COMMENT ON COLUMN s1_zipcode.zip_dong IS '��';

COMMENT ON COLUMN s1_zipcode.zip_sbunji IS '���۹���';

COMMENT ON COLUMN s1_zipcode.zip_ebunji IS '������';

COMMENT ON COLUMN s1_zipcode.zip_seq IS '��ȣ';

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

/* ��ǰī�װ� */
CREATE TABLE s1_category (
	cate_no NUMBER NOT NULL, /* ī�װ���ȣ */
	cate_name VARCHAR2(20) NOT NULL /* ī�װ��� */
);

COMMENT ON TABLE s1_category IS '��ǰī�װ�';

COMMENT ON COLUMN s1_category.cate_no IS 'ī�װ���ȣ';

COMMENT ON COLUMN s1_category.cate_name IS 'ī�װ���';

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

/* ��ǰ���� */
CREATE TABLE s1_pd (
	cate_no NUMBER, /* ī�װ���ȣ */
	pd_no NUMBER NOT NULL, /* ��ǰ��ȣ */
	pd_name VARCHAR2(20) NOT NULL, /* ��ǰ�� */
	pd_price NUMBER NOT NULL, /* ��ǰ���� */
	pd_img CLOB /* �̹��� */
);

COMMENT ON TABLE s1_pd IS '��ǰ����';

COMMENT ON COLUMN s1_pd.cate_no IS 'ī�װ���ȣ';

COMMENT ON COLUMN s1_pd.pd_no IS '��ǰ��ȣ';

COMMENT ON COLUMN s1_pd.pd_name IS '��ǰ��';

COMMENT ON COLUMN s1_pd.pd_price IS '��ǰ����';

COMMENT ON COLUMN s1_pd.pd_img IS '�̹���';

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

/* �������� */
CREATE TABLE s1_to (
	st_no NUMBER NOT NULL, /* �����ȣ */
	od_number NUMBER, /* �ֹ���ȣ */
	to_total NUMBER NOT NULL, /* �ǸŰ��� */
	to_date DATE NOT NULL, /* �Ǹ����� */
	to_pay VARCHAR2(20) NOT NULL /* �������� */
);

COMMENT ON TABLE s1_to IS '��������';

COMMENT ON COLUMN s1_to.st_no IS '�����ȣ';

COMMENT ON COLUMN s1_to.od_number IS '�ֹ���ȣ';

COMMENT ON COLUMN s1_to.to_total IS '�ǸŰ���';

COMMENT ON COLUMN s1_to.to_date IS '�Ǹ�����';

COMMENT ON COLUMN s1_to.to_pay IS '��������';

/* �ֹ����� */
CREATE TABLE s1_od (
	od_number NUMBER NOT NULL, /* �ֹ���ȣ */
	st_no NUMBER NOT NULL, /* �����ȣ */
	od_total NUMBER NOT NULL, /* �ǸŰ��� */
	od_date DATE NOT NULL /* �ֹ����� */
);

COMMENT ON TABLE s1_od IS '�ֹ�����';

COMMENT ON COLUMN s1_od.od_number IS '�ֹ���ȣ';

COMMENT ON COLUMN s1_od.st_no IS '�����ȣ';

COMMENT ON COLUMN s1_od.od_total IS '�ǸŰ���';

COMMENT ON COLUMN s1_od.od_date IS '�ֹ�����';

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

/* �ֹ��������� */
CREATE TABLE s1_oddt (
	st_no NUMBER NOT NULL, /* �����ȣ */
	od_number NUMBER NOT NULL, /* �ֹ���ȣ */
	pd_no NUMBER NOT NULL, /* ��ǰ��ȣ */
	oddt_cnt NUMBER, /* ���� */
	oddt_io VARCHAR2(2), /* �����̿뿩�� */
	oddt_ice VARCHAR2(2), /* ���� */
	oddt_shot VARCHAR2(2) /* ���߰� */
);

COMMENT ON TABLE s1_oddt IS '�ֹ���������';

COMMENT ON COLUMN s1_oddt.st_no IS '�����ȣ';

COMMENT ON COLUMN s1_oddt.od_number IS '�ֹ���ȣ';

COMMENT ON COLUMN s1_oddt.pd_no IS '��ǰ��ȣ';

COMMENT ON COLUMN s1_oddt.oddt_cnt IS '����';

COMMENT ON COLUMN s1_oddt.oddt_io IS '�����̿뿩��';

COMMENT ON COLUMN s1_oddt.oddt_ice IS '����';

COMMENT ON COLUMN s1_oddt.oddt_shot IS '���߰�';

/* ȸ������ */
CREATE TABLE s1_mem (
	mem_no NUMBER NOT NULL, /* ȸ����ȣ */
	mem_name VARCHAR2(20) NOT NULL, /* �̸� */
	mem_id VARCHAR2(20) NOT NULL, /* ID */
	mem_pw VARCHAR2(20) NOT NULL, /* PW */
	mem_birth VARCHAR2(20), /* ������� */
	mem_tel VARCHAR2(30), /* ��ȭ��ȣ */
	mem_coupon NUMBER, /* �������� */
	mem_stamp NUMBER /* ����ī��Ʈ */
);

COMMENT ON TABLE s1_mem IS 'ȸ������';

COMMENT ON COLUMN s1_mem.mem_no IS 'ȸ����ȣ';

COMMENT ON COLUMN s1_mem.mem_name IS '�̸�';

COMMENT ON COLUMN s1_mem.mem_id IS 'ID';

COMMENT ON COLUMN s1_mem.mem_pw IS 'PW';

COMMENT ON COLUMN s1_mem.mem_birth IS '�������';

COMMENT ON COLUMN s1_mem.mem_tel IS '��ȭ��ȣ';

COMMENT ON COLUMN s1_mem.mem_coupon IS '��������';

COMMENT ON COLUMN s1_mem.mem_stamp IS '����ī��Ʈ';

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

/* ������Ȳ */
CREATE TABLE s1_cal (
	st_no NUMBER, /* �����ȣ */
	cal_scash NUMBER, /* �����غ�� */
	cal_ecash NUMBER, /* �������� */
	cal_ecard NUMBER, /* ����ī�� */
	cal_sum NUMBER, /* �������� */
	cal_date DATE /* ������ */
);

COMMENT ON TABLE s1_cal IS '������Ȳ';

COMMENT ON COLUMN s1_cal.st_no IS '�����ȣ';

COMMENT ON COLUMN s1_cal.cal_scash IS '�����غ��';

COMMENT ON COLUMN s1_cal.cal_ecash IS '��������';

COMMENT ON COLUMN s1_cal.cal_ecard IS '����ī��';

COMMENT ON COLUMN s1_cal.cal_sum IS '��������';

COMMENT ON COLUMN s1_cal.cal_date IS '������';

/* �����ֹ����� */
CREATE TABLE s1_oding (
	od_number NUMBER /* �ֹ���ȣ */
);

COMMENT ON TABLE s1_oding IS '�����ֹ�����';

COMMENT ON COLUMN s1_oding.od_number IS '�ֹ���ȣ';

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