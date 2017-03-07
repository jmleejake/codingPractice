drop table account;
drop table admin;
drop table client;
drop table product;
drop table teller;
drop table trade;

drop sequence seq_teller;
drop sequence seq_client;

create table client(
			cltNum number(10) constraint client_cltNum_pk primary key,
			cltName varchar2(30) not null,
			cltRrn varchar2(13) not null,
			cltTel varchar2(30) not null,
			cltCel varchar2(30) not null,
			cltAddr varchar2(50) not null,
			cltEmail varchar2(30) not null
);

CREATE SEQUENCE seq_client START WITH 1 INCREMENT BY 1 ;

create table account (
			accNum varchar2(20) constraint account_accNum_pk primary key,
			cltNum number(10) constraint client_cltNum_fk references client(cltNum),
			accPw varchar2(10) not null,
			crtDay date not null,
			expDay varchar2(20),
			payDay varchar2(20),
			balance number(20) not null,
			prdCode varchar2(20) not null
);

create table admin (
			adId varchar2(10) not null,
			adPw varchar2(10) not null,
			adName varchar2(30) not null,
			adRrn varchar2(15) not null,
			adTel varchar2(30) not null,
			adCel varchar2(30) not null,
			adAddr varchar2(50) not null,
			adEmail varchar2(30) not null
);
			
create table product(
	prdCode VarChar2(10) constraint product_prdCode_pk primary key,
	prdName VarChar2(20) not null,
	interest number(3,1) not null,
	adminPw varchar2(10)
);

create table teller (
			tlrNum number(10) constraint teller_tlrNum_pk primary key,
			tlrId varchar2(10) not null,
			tlrPw varchar2(10) not null,
			tlrName varchar2(30) not null,
			tlrRrn varchar2(15) not null,
			tlrTel varchar2(30) not null,
			tlrCel varchar2(30) not null,
			tlrAddr varchar2(50) not null,
			tlrEmail varchar2(30) not null
);

CREATE SEQUENCE seq_teller START WITH 1 INCREMENT BY 1 ;

create table trade(
	trdNum number(20),
	accNum VarChar2(20),
	trdBalance Number(20) not null,
	trdCode VarChar2(10) not null,
	trdMoney Number(20) not null,		
	trdDate Date not null
);
				
insert into teller values(seq_teller.nextval, 'jm', '1234', '�����', '860825', '010-1234-5678', '02-123-4567', '����� ���ϱ�', 'jae@naver.com');
insert into teller values(seq_teller.nextval, 'nt', '3333', '���ڷ�', '900825', '011-1234-5678', '02-223-4567', '����� �ڷ��� 1��', 'tel@naver.com');
insert into teller values(seq_teller.nextval, 'ntr', '4444', '���׷�', '780902', '011-1234-5678', '02-223-4567', '����� �ڷ��� 2��', 'terror@naver.com');

insert into product values ('or', '���뿹��', 3.5, '12345');
insert into product values ('sa', '���࿹��', 3.5, '12345');
insert into product values ('ti', '���⿹��', 3.5, '12345');
insert into product values ('pe', '��������', 3.5, '12345');

insert into client values (seq_client.nextval, '������', '840101', '02-000-0000', '010-0001-0000', '����� ���¿�', 'jsh@naver.com');
insert into client values (seq_client.nextval, 'ȫ�ο�', '860301', '041-000-0000', '010-1234-0000', '��⵵ ����', 'alsdn15@naver.com');
insert into client values (seq_client.nextval, '������', '861126', '041-000-0000', '010-0002-0000', '��⵵ ����', 'kang@naver.com');
insert into client values (seq_client.nextval, '�����', '860825', '02-000-0000', '010-0003-0000', '����� ��ε�', 'jaemin@naver.com');
insert into client values (seq_client.nextval, '�̻��', '860726', '02-000-0000', '010-0004-0000', '����� ���ʵ�', 'nem0@naver.com');
			
insert into admin values('admin', '12345', '���ع�', '680101', '010-1234-5678', '02-123-4567', '���� ���', 'admin@naver.com');					

commit