CREATE TABLE board(
	cno number NOT NULL,
	ctitle varchar2(100) NULL,
	content varchar2(200) NULL,
	cday varchar2(30) NULL,
	mid varchar2(20) NOT NULL,
	uday varchar2(30) NULL,
	fileid varchar2(7) NULL,
	position number not null,
	depth number not null
);

CREATE TABLE boardFile(
	fileid varchar2(7) NOT NULL,
	volumeid varchar2(20) NULL,
	filepath varchar2(50) NULL,
	filename varchar2(50) NULL,
	filetype varchar2(10) NULL,
	filesize varchar2(10) NULL
);

CREATE TABLE member(
	mid varchar2(20) NOT NULL,
	mpw varchar2(20) NOT NULL,
	mname varchar2(20) NULL,
	mtel varchar2(20) NULL,
	mjuso varchar2(30) NULL
);




    create table "XR_VOLUME"(
        "VOL_NAME" VARCHAR2(64) not null,
       "VOL_TYPE" VARCHAR2(16) not null,
       "STORE_MODE" VARCHAR2(16) not null,
       "ROOT_PATH" VARCHAR2(255) not null,
       "PROCESSOR" VARCHAR2(255) not null,
       "CREATE_DATE" DATE,
       AUDIT_SIZE VARCHAR2(16),
       IS_ONLINE CHAR(1),
       IS_READONLY CHAR(1),
        constraint "XR_VOLUME_PK" primary key ("VOL_NAME")
    );
    
    create table "XR_TYPE"(
        "TYPE_ID" VARCHAR2(32) not null,
       "TBL_NAME" VARCHAR2(62),
       "CREATE_DATE" DATE,
       "IS_BASE" CHAR(1),
       "TYPE_NAME" VARCHAR2(128),
        constraint "XR_TYPE_PK" primary key ("TYPE_ID")
    );

    create table "XR_PAGE"(
        "DOC_ID" VARCHAR2(64) not null,
       "PAGE_NO" NUMBER(10) not null,
       "PAGE_TITLE" VARCHAR2(255),
       "CREATE_DATE" DATE,
       "FILE_SIZE" VARCHAR2(20),
       "CHECKSUM" VARCHAR2(32),
       "FILE_NAME" VARCHAR2(255),
        constraint "XR_PAGE_PK" primary key ("DOC_ID","PAGE_NO")
    );
    
    create table "XR_FOLDER"(
        "FOLDER_ID" VARCHAR2(64) not null,
       "FOLDER_NAME" VARCHAR2(64) not null,
       "FULL_PATH" VARCHAR2(255),
       "CREATE_DATE" DATE,
       "VOL_NAME" VARCHAR2(64) not null,
       "PARENT_ID" VARCHAR2(64),
        constraint "XR_FOLDER_PK" primary key ("FOLDER_ID")
    );
    
    create table "XR_ATTR"(
        "TYPE_ID" VARCHAR2(32) not null,
        "ATTR_ID" VARCHAR2(32) not null,
       "ATTR_NAME" VARCHAR2(32),
       "IS_EXTENDED" CHAR(1) not null,
       "ATTR_SIZE" NUMBER(8) not null,
       "IS_EDITABLE" CHAR(1),
       "IS_MANDATORY" CHAR(1),
        constraint "XR_ATTR_PK" primary key ("TYPE_ID","ATTR_ID")
    );
    
   create table "XR_DOCUMENT"(
        "DOC_ID" VARCHAR2(64) not null,
       "FOLDER_ID" VARCHAR2(64) not null,
       "DOC_NAME" VARCHAR2(255) not null,
       "CREATE_DATE" DATE,
       "DOC_TYPE" VARCHAR2(32),
       "TOTAL_PAGES" NUMBER(3),
        constraint "XR_DOCUMENT_PK" primary key ("DOC_ID")
    );
    
insert into XR_TYPE(TYPE_ID,TBL_NAME,CREATE_DATE,IS_BASE,TYPE_NAME) values ('XR_DOCUMENT','XR_DOCUMENT',sysdate,'T','기본문서');
insert into XR_ATTR(TYPE_ID,ATTR_ID,ATTR_NAME,IS_EXTENDED,ATTR_SIZE,IS_EDITABLE,IS_MANDATORY) values ('XR_DOCUMENT','CREATE_DATE','등록일자','F',0,'F','T');
insert into XR_ATTR(TYPE_ID,ATTR_ID,ATTR_NAME,IS_EXTENDED,ATTR_SIZE,IS_EDITABLE,IS_MANDATORY) values ('XR_DOCUMENT','DOC_ID','문서ID','F',64,'F','T');
insert into XR_ATTR(TYPE_ID,ATTR_ID,ATTR_NAME,IS_EXTENDED,ATTR_SIZE,IS_EDITABLE,IS_MANDATORY) values ('XR_DOCUMENT','DOC_NAME','문서이름','F',255,'T','T');
insert into XR_ATTR(TYPE_ID,ATTR_ID,ATTR_NAME,IS_EXTENDED,ATTR_SIZE,IS_EDITABLE,IS_MANDATORY) values ('XR_DOCUMENT','DOC_TYPE','문서유형','F',32,'F','T');
insert into XR_ATTR(TYPE_ID,ATTR_ID,ATTR_NAME,IS_EXTENDED,ATTR_SIZE,IS_EDITABLE,IS_MANDATORY) values ('XR_DOCUMENT','FOLDER_ID','폴더ID','F',64,'F','T');
insert into XR_ATTR(TYPE_ID,ATTR_ID,ATTR_NAME,IS_EXTENDED,ATTR_SIZE,IS_EDITABLE,IS_MANDATORY) values ('XR_DOCUMENT','TOTAL_PAGES','페이지수','F',0,'F','T');
