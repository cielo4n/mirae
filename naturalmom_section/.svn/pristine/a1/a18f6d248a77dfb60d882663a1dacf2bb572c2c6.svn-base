--------------------------------------------------------
--  파일이 생성됨 - 금요일-4월-22-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence EVENT_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."EVENT_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 15 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EVENT_RE_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."EVENT_RE_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 9 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence FAQ_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."FAQ_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 8 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence NOTICE_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."NOTICE_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 13 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence NOTICE_RE_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."NOTICE_RE_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 13 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence ORDER_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."ORDER_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 10048 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PRODUCT_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."PRODUCT_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 10015 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence QNA_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."QNA_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence QNA_RE_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."QNA_RE_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 12 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REVIEW_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."REVIEW_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 27 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REVIEW_RE_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "NMDB"."REVIEW_RE_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 33 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table TB_BOARD
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_BOARD" 
   (	"BOARD_CD" NUMBER, 
	"BOARD_NM" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_CART
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_CART" 
   (	"PRODUCT_NO" NUMBER DEFAULT 10000, 
	"MEM_ID" VARCHAR2(32 BYTE), 
	"BUY_NUM" NUMBER DEFAULT 1
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_CATEGORY
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_CATEGORY" 
   (	"CATEGORY_CD" NUMBER, 
	"CATEGORY_NM" VARCHAR2(64 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_CATEGORY"."CATEGORY_CD" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_CREDIT
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_CREDIT" 
   (	"CREDIT_CD" NUMBER, 
	"CREDIT_NM" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_DELIVERY_COM
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_DELIVERY_COM" 
   (	"DELIVERY_COM_CD" NUMBER, 
	"DELIVERY_COM_NM" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_EVENT
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_EVENT" 
   (	"EVENT_NO" NUMBER, 
	"EVT_TITLE" VARCHAR2(256 BYTE), 
	"EVT_WRITE_DAY" DATE DEFAULT SYSDATE, 
	"EVT_HITS" NUMBER, 
	"EVT_CONTENT" VARCHAR2(4000 BYTE), 
	"EVT_DEL_CHECK" NUMBER DEFAULT 0, 
	"BOARD_ID" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_EVENT"."EVENT_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_EVENT_RE
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_EVENT_RE" 
   (	"EVENT_RE_NO" NUMBER, 
	"EVT_RE_CONTENT" VARCHAR2(1024 BYTE), 
	"EVT_RE_WRITE_DAY" DATE DEFAULT SYSDATE, 
	"EVT_RE_DEL_CHECK" NUMBER DEFAULT 0, 
	"EVT_NO" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_EVENT_RE"."EVENT_RE_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_FAQ
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_FAQ" 
   (	"FAQ_NO" NUMBER, 
	"FAQ_TITLE" VARCHAR2(256 BYTE), 
	"FAQ_CONTENT" VARCHAR2(4000 BYTE), 
	"FAQ_DEL_CHECK" NUMBER DEFAULT 0, 
	"BOARD_ID" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_FAQ"."FAQ_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_INTEREST
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_INTEREST" 
   (	"PRODUCT_NO" NUMBER DEFAULT 10000, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_MEMBER
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_MEMBER" 
   (	"MEM_ID" VARCHAR2(32 BYTE), 
	"MEM_PW" VARCHAR2(32 BYTE), 
	"MEM_NAME" VARCHAR2(32 BYTE), 
	"MEM_PHONE" VARCHAR2(32 BYTE), 
	"MEM_ADDR_POST" VARCHAR2(256 BYTE), 
	"MEM_ADDR_DETAIL" VARCHAR2(256 BYTE), 
	"MEM_EMAIL" VARCHAR2(64 BYTE), 
	"MEM_BIRTH" DATE, 
	"MEM_GENDER" NUMBER, 
	"DROP_OUT" NUMBER DEFAULT 0, 
	"MEM_LEVEL_CD" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_MEM_LEVEL
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_MEM_LEVEL" 
   (	"MEM_LEVEL_CD" NUMBER, 
	"MEM_LEVEL_NM" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_MEM_LEVEL_N_BOARD
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" 
   (	"MEM_LEVEL_CD" NUMBER, 
	"BOARD_CD" NUMBER, 
	"BOARD_READ" NUMBER, 
	"BOARD_WRITE" NUMBER, 
	"BOARD_MODIFY" NUMBER, 
	"BOARD_DELETE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_NOTICE
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_NOTICE" 
   (	"NOTICE_NO" NUMBER, 
	"NTC_TITLE" VARCHAR2(256 BYTE), 
	"NTC_WRITE_DAY" DATE DEFAULT SYSDATE, 
	"NTC_HITS" NUMBER, 
	"NTC_CONTENT" VARCHAR2(4000 BYTE), 
	"NTC_DEL_CHECK" NUMBER DEFAULT 0, 
	"NTC_ATTACHED_FILE1" VARCHAR2(256 BYTE), 
	"NTC_ATTACHED_FILE2" VARCHAR2(256 BYTE), 
	"BOARD_ID" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_NOTICE"."NOTICE_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_NOTICE_RE
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_NOTICE_RE" 
   (	"NOTICE_RE_NO" NUMBER, 
	"NTC_RE_CONTENT" VARCHAR2(1024 BYTE), 
	"NTC_RE_WRITE_DAY" DATE DEFAULT SYSDATE, 
	"NTC_RE_DEL_CHECK" NUMBER DEFAULT 0, 
	"NOTICE_NO" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_NOTICE_RE"."NOTICE_RE_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_ORDER
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_ORDER" 
   (	"ORDER_NO" NUMBER, 
	"ORDER_DATE" DATE DEFAULT SYSDATE, 
	"CHARGE" NUMBER, 
	"CREDIT_NUM" VARCHAR2(32 BYTE), 
	"CREDIT_EXP" VARCHAR2(8 BYTE), 
	"RCV_NAME" VARCHAR2(64 BYTE), 
	"RCV_PHONE" VARCHAR2(32 BYTE), 
	"RCV_ADDR_POST" VARCHAR2(256 BYTE), 
	"RCV_ADDR_DETAIL" VARCHAR2(256 BYTE), 
	"DELIVERY_MSG" VARCHAR2(128 BYTE), 
	"TRACKING_NUM" NUMBER, 
	"CREDIT_CD" NUMBER, 
	"DELIVERY_COM_CD" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_PROCESS
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_PROCESS" 
   (	"PROCESS_CD" NUMBER, 
	"PROCESS_NM" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_PRODUCT
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_PRODUCT" 
   (	"PRODUCT_NO" NUMBER DEFAULT 10000, 
	"PRODUCT_NAME" VARCHAR2(64 BYTE), 
	"SELLING_PRICE" NUMBER, 
	"COST_PRICE" NUMBER, 
	"STOCK" NUMBER, 
	"DISPLAY_STATE" NUMBER DEFAULT 0, 
	"SALE_STATE" NUMBER DEFAULT 0, 
	"REPRESENT_IMG" VARCHAR2(256 BYTE), 
	"DETAIL_IMG" VARCHAR2(256 BYTE), 
	"SUMMARY_EX" VARCHAR2(128 BYTE), 
	"DETAIL_EX" VARCHAR2(4000 BYTE), 
	"DELETED_STATE" NUMBER DEFAULT 0, 
	"WEIGHT" NUMBER, 
	"CATEGORY_CD" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_PRODUCT"."PRODUCT_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_PRODUCT_N_ORDER
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_PRODUCT_N_ORDER" 
   (	"PRODUCT_NO" NUMBER DEFAULT 10000, 
	"ORDER_NO" NUMBER, 
	"BUY_NUM" NUMBER, 
	"PROCESS_CD" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TB_QNA
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_QNA" 
   (	"QNA_NO" NUMBER, 
	"QNA_TITLE" VARCHAR2(256 BYTE), 
	"QNA_WRITE_DAY" DATE DEFAULT SYSDATE, 
	"QNA_HITS" NUMBER, 
	"QNA_CONTENT" VARCHAR2(4000 BYTE), 
	"QNA_DEL_CHECK" NUMBER DEFAULT 0, 
	"QNA_PW" VARCHAR2(32 BYTE), 
	"QNA_POS" NUMBER, 
	"QNA_REF" NUMBER, 
	"BOARD_ID" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_QNA"."QNA_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_QNA_RE
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_QNA_RE" 
   (	"QNA_RE_NO" NUMBER, 
	"QNA_RE_CONTENT" VARCHAR2(1024 BYTE), 
	"QNA_RE_WRITE_DAY" DATE DEFAULT SYSDATE, 
	"QNA_RE_DEL_CHECK" NUMBER DEFAULT 0, 
	"QNA_NO" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_QNA_RE"."QNA_RE_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_REVIEW
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_REVIEW" 
   (	"REVIEW_NO" NUMBER, 
	"RVW_TITLE" VARCHAR2(256 BYTE), 
	"RVW_WRITE_DAY" DATE DEFAULT SYSDATE, 
	"RVW_HITS" NUMBER, 
	"RVW_CONTENT" VARCHAR2(4000 BYTE), 
	"RVW_DEL_CHECK" NUMBER, 
	"RVW_SATISFACTION" NUMBER DEFAULT 0, 
	"PRODUCT_NO" NUMBER DEFAULT 10000, 
	"BOARD_ID" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_REVIEW"."REVIEW_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for Table TB_REVIEW_RE
--------------------------------------------------------

  CREATE TABLE "NMDB"."TB_REVIEW_RE" 
   (	"REVIEW_RE_NO" NUMBER, 
	"RVW_RE_CONTENT" VARCHAR2(1024 BYTE), 
	"RVW_RE_WRITE_DAY" DATE DEFAULT SYSDATE, 
	"RVW_RE_DEL_CHECK" NUMBER DEFAULT 0, 
	"RVW_NO" NUMBER, 
	"MEM_ID" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "NMDB"."TB_REVIEW_RE"."REVIEW_RE_NO" IS 'auto_increment';
--------------------------------------------------------
--  DDL for View V_CART_PRODUCT
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_CART_PRODUCT" ("PRODUCT_NO", "PRODUCT_NAME", "SELLING_PRICE", "SALE_STATE", "REPRESENT_IMG", "STOCK", "BUY_NUM", "MEM_ID") AS 
  SELECT c.product_no, product_name, selling_price, sale_state, represent_img, stock, c.buy_num, c.mem_id
FROM tb_product p JOIN tb_cart c 
ON (p.product_no=c.product_no) WHERE p.DISPLAY_STATE=1 AND p.DELETED_STATE=0;
--------------------------------------------------------
--  DDL for View V_EVENT_LIST
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_EVENT_LIST" ("EVENT_NO", "EVT_TITLE", "MEM_ID", "EVT_WRITE_DAY", "EVT_HITS", "EVT_CONTENT", "COUNT_RE") AS 
  SELECT e.EVENT_NO, e.EVT_TITLE, e.MEM_ID, e.EVT_WRITE_DAY, e.EVT_HITS, e.EVT_CONTENT,
NVL((SELECT COUNT(re.EVENT_RE_NO) FROM TB_EVENT_RE re WHERE re.EVT_NO = 
e.EVENT_NO AND re.EVT_RE_DEL_CHECK = 0), 0) as count_re
FROM TB_EVENT e LEFT OUTER JOIN TB_EVENT_RE r
ON (e.EVENT_NO = r.EVT_NO)
WHERE e.EVT_DEL_CHECK =0 
GROUP BY e.EVENT_NO, e.EVT_TITLE, e.MEM_ID, e.EVT_WRITE_DAY, e.EVT_HITS, e.EVT_CONTENT
ORDER BY e.EVENT_NO ASC;
--------------------------------------------------------
--  DDL for View V_EVENT_LIST_RN
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_EVENT_LIST_RN" ("EVT_RNUM", "EVENT_NO", "EVT_TITLE", "MEM_ID", "EVT_WRITE_DAY", "EVT_HITS", "EVT_CONTENT", "COUNT_RE") AS 
  SELECT A."EVT_RNUM",A."EVENT_NO",A."EVT_TITLE",A."MEM_ID",A."EVT_WRITE_DAY",A."EVT_HITS",A."EVT_CONTENT",A."COUNT_RE" FROM (SELECT rownum as evt_rnum, V.* from V_EVENT_LIST V ORDER BY V.EVENT_NO DESC) A;
--------------------------------------------------------
--  DDL for View V_INTEREST_PRODUCT
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_INTEREST_PRODUCT" ("PRODUCT_NO", "PRODUCT_NAME", "SELLING_PRICE", "SALE_STATE", "REPRESENT_IMG", "STOCK", "MEM_ID") AS 
  SELECT i.product_no, product_name, selling_price, sale_state, represent_img, stock, i.mem_id
FROM tb_product p JOIN tb_interest i
ON (p.product_no = i.product_no) WHERE p.DISPLAY_STATE=1 AND p.DELETED_STATE=0;
--------------------------------------------------------
--  DDL for View V_NOTICE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_NOTICE" ("NOTICE_NO", "NTC_TITLE", "NTC_RE_NO", "NTC_CONTENT", "NTC_WRITE_DAY", "NTC_HITS", "MEM_ID") AS 
  SELECT n.notice_no,  ntc_title, 
NVL((SELECT COUNT(notice_re_no) FROM tb_notice_re r WHERE r.notice_no=n.notice_no AND r.ntc_re_del_check=0), 0) AS ntc_re_no, 
ntc_content, ntc_write_day, ntc_hits, n.mem_id
FROM tb_notice n LEFT OUTER JOIN tb_notice_re r
ON (n.notice_no = r.notice_no)
WHERE ntc_del_check=0
GROUP BY n.notice_no,  ntc_title,  ntc_write_day, ntc_content, ntc_hits,  n.mem_id
ORDER BY notice_no DESC;
--------------------------------------------------------
--  DDL for View V_ORDERER
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_ORDERER" ("ID", "NAME", "PHONE", "EMAIL", "ADDR_POST", "ADDR_DETAIL") AS 
  SELECT m.mem_id as id, m.mem_name as name, m.mem_phone as phone, m.mem_email as email, m.mem_addr_post as addr_post, m.mem_addr_detail 
as addr_detail FROM tb_member m;
--------------------------------------------------------
--  DDL for View V_ORDER_LIST
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_ORDER_LIST" ("ORDER_NO", "ORDER_DATE", "REPRESENT_IMG", "PRODUCT_NAME", "BUY_NUM", "CHARGE", "PROCESS_NM", "MEM_ID") AS 
  SELECT o.order_no, o.order_date, p.represent_img, p.product_name, 
po.buy_num, o.charge, pr.process_nm, m.mem_id
FROM tb_order o, tb_member m, tb_product p, tb_product_n_order po, tb_process pr
WHERE o.order_no = po.order_no AND o.mem_id = m.mem_id AND p.product_no = po.product_no 
AND pr.process_cd = po.process_cd;
--------------------------------------------------------
--  DDL for View V_ORDER_MANAGER
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_ORDER_MANAGER" ("ORDER_DATE", "ORDER_NO", "MEM_NAME", "PRODUCT_NAME", "BUY_NUM", "CHARGE", "DELIVERY_MSG", "TRACKING_NUM", "PROCESS_NM") AS 
  SELECT o.order_date, o.order_no, m.mem_name, p.product_name, 
po.buy_num, o.charge, o.delivery_msg, o.tracking_num, pr.process_nm
FROM tb_order o, tb_member m, tb_product p, tb_product_n_order po, tb_process pr
WHERE o.order_no = po.order_no AND o.mem_id = m.mem_id AND p.product_no = po.product_no 
AND pr.process_cd = po.process_cd;
--------------------------------------------------------
--  DDL for View V_PRODUCT_DELETED
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_PRODUCT_DELETED" ("PRODUCT_NO", "CATEGORY_NM", "PRODUCT_NAME", "REPRESENT_IMG", "SELLING_PRICE", "COST_PRICE", "STOCK", "ALL_SELLS") AS 
  SELECT p.product_no, c.category_nm, p.product_name, p.represent_img, p.selling_price,
p.cost_price, p.stock, 
NVL((SELECT SUM(o.buy_num) FROM tb_product_n_order o WHERE o.product_no = 
p.product_no AND o.process_cd = 21
GROUP BY o.product_no), 0) AS all_sells
FROM tb_product p, tb_category c
WHERE p.category_cd = c.category_cd AND p.deleted_state = 1;
--------------------------------------------------------
--  DDL for View V_PRODUCT_MANAGE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_PRODUCT_MANAGE" ("PRODUCT_NO", "CATEGORY_NM", "PRODUCT_NAME", "REPRESENT_IMG", "SELLING_PRICE", "COST_PRICE", "STOCK", "DISPLAY_STATE", "SALE_STATE", "ALL_SELLS") AS 
  SELECT p.product_no, c.category_nm, p.product_name,
p.represent_img, p.selling_price, p.cost_price, 
p.stock, p.display_state, p.sale_state,  
NVL((SELECT SUM(o.buy_num) FROM tb_product_n_order o WHERE o.product_no = 
p.product_no AND o.process_cd = 21
GROUP BY o.product_no), 0) AS all_sells
FROM tb_category c,tb_product p, tb_product_n_order o
WHERE c.category_cd = p.category_cd
AND p.product_no = o.product_no(+)
AND p.deleted_state = 0
GROUP BY p.product_no, c.category_nm, p.product_name, p.represent_img, p.selling_price, 
p.cost_price, p.stock, p.weight, p.display_state, p.sale_state
ORDER BY p.product_no;
--------------------------------------------------------
--  DDL for View V_QNA_QNARE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_QNA_QNARE" ("QNA_NO", "QNA_TITLE", "QNA_WRITE_DAY", "QNA_HITS", "QNA_CONTENT", "QNA_PW", "QNA_POS", "QNA_REF", "MEM_ID", "QNA_RE_COUNT") AS 
  SELECT q.qna_no, qna_title, qna_write_day, qna_hits, qna_content, qna_pw, qna_pos, qna_ref, q.mem_id, 
NVL((SELECT COUNT(qna_re_no) FROM tb_qna_re r WHERE r.qna_no=q.qna_no AND r.qna_re_del_check=0), 0) as qna_re_count 
FROM tb_qna q LEFT OUTER JOIN tb_qna_re r
ON (q.qna_no = r.qna_no)
WHERE qna_del_check=0
GROUP BY q.qna_no, qna_title, qna_write_day, qna_hits, qna_content, qna_pw, qna_pos, qna_ref, q.mem_id
ORDER BY qna_ref ASC, qna_pos DESC;
--------------------------------------------------------
--  DDL for View V_RANK_SELLS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_RANK_SELLS" ("ALL_SELLS", "PRODUCT_NAME") AS 
  SELECT NVL((SELECT SUM(o.buy_num) FROM tb_product_n_order o WHERE o.product_no = 
p.product_no AND o.process_cd = 21
GROUP BY o.product_no), 0) AS all_sells, p.product_name
FROM tb_product p
WHERE p.deleted_state = 0
ORDER BY all_sells DESC, product_name;
--------------------------------------------------------
--  DDL for View V_REVIEW_ADMIN
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_REVIEW_ADMIN" ("REVIEW_NO", "PRODUCT_NO", "PRODUCT_NAME", "RVW_TITLE", "RVW_CONTENT", "MEM_ID", "RVW_WRITE_DAY", "RVW_SATISFACTION", "RVW_HITS", "RE_NUM") AS 
  SELECT r.review_no, r.product_no, p.product_name, r.rvw_title,
r.rvw_content, r.mem_id, r.rvw_write_day, r.rvw_satisfaction, r.rvw_hits,
NVL((SELECT COUNT(review_re_no) FROM tb_review_re re WHERE re.rvw_no = 
r.review_no AND re.rvw_re_del_check = 0), 0) as re_num
FROM tb_product p, tb_review r 
WHERE r.product_no = p.product_no
AND r.rvw_del_check = 0 
group by r.review_no, r.product_no, p.product_name, r.rvw_title, r.mem_id, 
r.rvw_content, r.rvw_write_day, r.rvw_satisfaction, r.rvw_hits
order by r.review_no;
--------------------------------------------------------
--  DDL for View V_REVIEW_FRONT
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "NMDB"."V_REVIEW_FRONT" ("REVIEW_NO", "PRODUCT_NO", "RVW_TITLE", "RVW_WRITE_DAY", "RVW_HITS", "RVW_CONTENT", "RVW_SATISFACTION", "MEM_ID", "RE_NUM") AS 
  SELECT r.review_no, r.product_no, r.rvw_title, r.rvw_write_day, 
r.rvw_hits, r.rvw_content, r.rvw_satisfaction, r.mem_id,
NVL((SELECT COUNT(review_re_no) FROM tb_review_re re WHERE re.rvw_no = 
r.review_no AND re.rvw_re_del_check = 0), 0) as re_num
FROM tb_review r 
WHERE r.rvw_del_check = 0
group by r.review_no, r.product_no, r.rvw_title, r.rvw_write_day, 
r.rvw_hits, r.rvw_content, r.rvw_satisfaction, r.mem_id
order by r.review_no;
REM INSERTING into NMDB.TB_BOARD
SET DEFINE OFF;
Insert into NMDB.TB_BOARD (BOARD_CD,BOARD_NM) values (1,'공지사항');
Insert into NMDB.TB_BOARD (BOARD_CD,BOARD_NM) values (2,'이벤트');
Insert into NMDB.TB_BOARD (BOARD_CD,BOARD_NM) values (3,'자주하는질문');
Insert into NMDB.TB_BOARD (BOARD_CD,BOARD_NM) values (4,'QnA');
Insert into NMDB.TB_BOARD (BOARD_CD,BOARD_NM) values (5,'상품후기');
REM INSERTING into NMDB.TB_CART
SET DEFINE OFF;
Insert into NMDB.TB_CART (PRODUCT_NO,MEM_ID,BUY_NUM) values (10001,'soomin',4);
Insert into NMDB.TB_CART (PRODUCT_NO,MEM_ID,BUY_NUM) values (10001,'minhee',3);
Insert into NMDB.TB_CART (PRODUCT_NO,MEM_ID,BUY_NUM) values (10007,'admin02',1);
Insert into NMDB.TB_CART (PRODUCT_NO,MEM_ID,BUY_NUM) values (10001,'blacksmith',1);
Insert into NMDB.TB_CART (PRODUCT_NO,MEM_ID,BUY_NUM) values (10001,'hanagang',3);
REM INSERTING into NMDB.TB_CATEGORY
SET DEFINE OFF;
Insert into NMDB.TB_CATEGORY (CATEGORY_CD,CATEGORY_NM) values (1,'아토피/민감성/유아');
Insert into NMDB.TB_CATEGORY (CATEGORY_CD,CATEGORY_NM) values (2,'피부탄력/노화');
Insert into NMDB.TB_CATEGORY (CATEGORY_CD,CATEGORY_NM) values (3,'지성/여드름/트러블');
Insert into NMDB.TB_CATEGORY (CATEGORY_CD,CATEGORY_NM) values (4,'미백/피부톤개선');
REM INSERTING into NMDB.TB_CREDIT
SET DEFINE OFF;
Insert into NMDB.TB_CREDIT (CREDIT_CD,CREDIT_NM) values (10,'신한');
Insert into NMDB.TB_CREDIT (CREDIT_CD,CREDIT_NM) values (11,'삼성');
Insert into NMDB.TB_CREDIT (CREDIT_CD,CREDIT_NM) values (12,'하나');
Insert into NMDB.TB_CREDIT (CREDIT_CD,CREDIT_NM) values (13,'롯데');
Insert into NMDB.TB_CREDIT (CREDIT_CD,CREDIT_NM) values (14,'KB국민');
Insert into NMDB.TB_CREDIT (CREDIT_CD,CREDIT_NM) values (15,'NH채움');
Insert into NMDB.TB_CREDIT (CREDIT_CD,CREDIT_NM) values (16,'비씨');
Insert into NMDB.TB_CREDIT (CREDIT_CD,CREDIT_NM) values (17,'우리');
REM INSERTING into NMDB.TB_DELIVERY_COM
SET DEFINE OFF;
Insert into NMDB.TB_DELIVERY_COM (DELIVERY_COM_CD,DELIVERY_COM_NM) values (1,'cj대한통운');
Insert into NMDB.TB_DELIVERY_COM (DELIVERY_COM_CD,DELIVERY_COM_NM) values (2,'로젠택배');
Insert into NMDB.TB_DELIVERY_COM (DELIVERY_COM_CD,DELIVERY_COM_NM) values (3,'옐로우캡');
Insert into NMDB.TB_DELIVERY_COM (DELIVERY_COM_CD,DELIVERY_COM_NM) values (4,'우체국');
Insert into NMDB.TB_DELIVERY_COM (DELIVERY_COM_CD,DELIVERY_COM_NM) values (5,'한진택배');
Insert into NMDB.TB_DELIVERY_COM (DELIVERY_COM_CD,DELIVERY_COM_NM) values (6,'현대택배');
REM INSERTING into NMDB.TB_EVENT
SET DEFINE OFF;
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (1,'자연맘으로 좋아진 내 피부를 인증하고 상품 받아가세요~',to_date('16/04/17','RR/MM/DD'),23,'자연맘 어떤 상품을 사용해 보셨나요?<br><br>자연맘으로 좋아진 내 피부를 인증하고 상품 받아가세요~<br>Before와 After 인증샷이 있다면 당첨 확률은 Up!<br>자연맘 피부왕으로 뽑히신 5분께는 <br>10만원 상당의 자연맘 상품을 보내드립니다.<br><br>이벤트 기간 : 3월 10일~ 3월 31일<br><br>많은 참여 부탁드려요^^<br>',0,2,'admin01');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (2,'피부 인증샷',to_date('16/04/17','RR/MM/DD'),16,'<img src=http://i.imgur.com/xZQ9A66.jpg width=480><br>ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ인증임 상품내놔<br>',0,2,'soojin');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (3,'피부 인증샷2',to_date('16/04/17','RR/MM/DD'),10,'<img src=http://i.imgur.com/xZQ9A66.jpg width=480><br>ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ또 인증임 상품내놔<br>',1,2,'soojin');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (4,'맑아진 피부, 커진 자신감',to_date('16/04/17','RR/MM/DD'),14,'너무 좋아요<br>피부 자신감 얻었어요<br>화보도 찍었어요<br>포샵은 조금만 했어요<br><img src=http://i.imgur.com/Is27hIK.jpg width=690><br>',0,2,'soomin');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (5,'자연맘과 함께라면',to_date('16/04/17','RR/MM/DD'),24,'자연맘 친구가 추천해줘서 사용해봤는데<br>이제 자연맘 비누 없으면 안될거 같아요<br><br>아침마다 화장이 잘 먹어서 기분이 좋네요<br><br><img src=http://i.imgur.com/rbp8HpW.jpg height=575 width=383><br><br>친환경 제품은 역시 달라도 뭐가 다르군요<br>',0,2,'sora');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (6,'인증인증~',to_date('16/04/21','RR/MM/DD'),6,'<img src="http://i.imgur.com/iqttft2.jpg" width="630"><br><div><br></div><div>저희집 고양이도 자연맘 비누로 세수한답니다 ^^</div>',1,2,'maru0903');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (7,'인증샷 또 추가',to_date('16/04/21','RR/MM/DD'),4,'이번엔 제 사진 ^^~',1,2,'maru0903');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (8,'인증인증~',to_date('16/04/21','RR/MM/DD'),12,'저희집 고양이도 자연맘 비누로 세수한답니다 ^^!<div><br></div><div><br></div><div><br></div><div><img src="http://i.imgur.com/Qqxxy5i.jpg" width="630"><br></div>',0,2,'maru0903');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (9,'인증 하나 더~',to_date('16/04/21','RR/MM/DD'),11,'<img src="http://i.imgur.com/9bFvxez.jpg" width="100"><br><div><br></div><div>제 얼굴 너무 하얗죠 ^^?</div>',0,2,'maru0903');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (10,'인증 이벤트에 많은 참여 부탁드려요 ^^',to_date('16/04/21','RR/MM/DD'),10,'<img src="http://i.imgur.com/5nP4AN3.jpg" width="400"><br><div>여러분의 성원이 뜨거워질수록 상품이 더욱 더 팡팡!!</div><div>많은 참여 부탁드릴게요 ^^~</div>',0,2,'admin01');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (12,'저도 인증샷!!',to_date('16/04/22','RR/MM/DD'),5,'<img src="http://i.imgur.com/H0VXyiW.jpg" width="474"><br><div><br></div><div>제 얼굴 너무 포도 같네요ㅎㅎ</div>',1,2,'sora');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (14,'저두 대세따라 인증샷 ^^',to_date('16/04/22','RR/MM/DD'),2,'<img src="http://i.imgur.com/liv0SjY.jpg" width="640"><br><div><br></div><div>우리집 개 인증샷이요 ^^</div>',0,2,'hook1028');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (11,'인증샷입니다',to_date('16/04/21','RR/MM/DD'),7,'<img src="http://i.imgur.com/31708ZY.jpg" width="690"><br><div><br></div><div>얼굴이 더 노래진 거 같아요~</div>',0,2,'applepie');
Insert into NMDB.TB_EVENT (EVENT_NO,EVT_TITLE,EVT_WRITE_DAY,EVT_HITS,EVT_CONTENT,EVT_DEL_CHECK,BOARD_ID,MEM_ID) values (13,'피부가...',to_date('16/04/22','RR/MM/DD'),2,'광이 나네요<img src="http://i.imgur.com/veZvh6Y.png" width="38">',1,2,'soojin');
REM INSERTING into NMDB.TB_EVENT_RE
SET DEFINE OFF;
Insert into NMDB.TB_EVENT_RE (EVENT_RE_NO,EVT_RE_CONTENT,EVT_RE_WRITE_DAY,EVT_RE_DEL_CHECK,EVT_NO,MEM_ID) values (1,'헐 지금바로 참여ㄱㄱ',to_date('16/04/17','RR/MM/DD'),0,1,'soojin');
Insert into NMDB.TB_EVENT_RE (EVENT_RE_NO,EVT_RE_CONTENT,EVT_RE_WRITE_DAY,EVT_RE_DEL_CHECK,EVT_NO,MEM_ID) values (2,'좋은 정보네요^^',to_date('16/04/17','RR/MM/DD'),0,1,'sora');
Insert into NMDB.TB_EVENT_RE (EVENT_RE_NO,EVT_RE_CONTENT,EVT_RE_WRITE_DAY,EVT_RE_DEL_CHECK,EVT_NO,MEM_ID) values (3,'soojin님 사진보고 깜짝 놀라버렸어요!<br> 이벤트 참여해주셔서 감사해요^^',to_date('16/04/17','RR/MM/DD'),0,2,'admin02');
Insert into NMDB.TB_EVENT_RE (EVENT_RE_NO,EVT_RE_CONTENT,EVT_RE_WRITE_DAY,EVT_RE_DEL_CHECK,EVT_NO,MEM_ID) values (4,'sumin님 정말 미인이시네요!<br> 이벤트 참여해주셔서 감사해요^^',to_date('16/04/17','RR/MM/DD'),0,4,'admin02');
Insert into NMDB.TB_EVENT_RE (EVENT_RE_NO,EVT_RE_CONTENT,EVT_RE_WRITE_DAY,EVT_RE_DEL_CHECK,EVT_NO,MEM_ID) values (5,'이거 본인 사진 아닌듯..',to_date('16/04/17','RR/MM/DD'),1,4,'minhee');
Insert into NMDB.TB_EVENT_RE (EVENT_RE_NO,EVT_RE_CONTENT,EVT_RE_WRITE_DAY,EVT_RE_DEL_CHECK,EVT_NO,MEM_ID) values (6,'sora님 저희 제품 덕분에 화장이 잘된다니 영광이네요<br> 이벤트 참여해주셔서 감사해요^^',to_date('16/04/17','RR/MM/DD'),0,5,'admin02');
Insert into NMDB.TB_EVENT_RE (EVENT_RE_NO,EVT_RE_CONTENT,EVT_RE_WRITE_DAY,EVT_RE_DEL_CHECK,EVT_NO,MEM_ID) values (7,'헐 외국인인데 한국말 잘하시네요!!',to_date('16/04/20','RR/MM/DD'),0,4,'sora');
Insert into NMDB.TB_EVENT_RE (EVENT_RE_NO,EVT_RE_CONTENT,EVT_RE_WRITE_DAY,EVT_RE_DEL_CHECK,EVT_NO,MEM_ID) values (8,'우리집 개 넘 귀여움',to_date('16/04/22','RR/MM/DD'),0,14,'hook1028');
REM INSERTING into NMDB.TB_FAQ
SET DEFINE OFF;
Insert into NMDB.TB_FAQ (FAQ_NO,FAQ_TITLE,FAQ_CONTENT,FAQ_DEL_CHECK,BOARD_ID,MEM_ID) values (1,'결제 창이 안뜨는데 어떻게 해야하나요?','간혹 결제 창이 안뜬다고 말씀하시는 고객님들이 많으십니다.<br>이 경우 팝업 설정을 차단해놓아서 자동으로 KCP결제 창이 뜨지않기때문에 수동으로 결제창을 열어주셔야합니다.<br>주문결제 시도하셨을때 만약 아래와 같은 화면이 보이신다면 결제하기 버튼을 누르시면 KCP결제 페이지를 보실 수 있으십니다.<br><br><img src="http://i.imgur.com/UdtItem.png" width="690"><br><br>혹시 위에 사진과 같이 결제하기가 뜨지않고 이상한 문구가 뜨는 경우에는 KCP프로그램이 설치되지않아 발생하는 문제이오니, 결제하는 과정에서 KCP 결제에 필요한 자료를 설치 후 진행해주시기 바랍니다.<br>감사합니다.<br>',0,3,'admin01');
Insert into NMDB.TB_FAQ (FAQ_NO,FAQ_TITLE,FAQ_CONTENT,FAQ_DEL_CHECK,BOARD_ID,MEM_ID) values (2,'결제 창이 안뜨는데 어떻게 해야하나요?','간혹 결제 창이 안뜬다고 말씀하시는 고객님들이 많으십니다.<br>이 경우 팝업 설정을 차단해놓아서 자동으로 KCP결제 창이 뜨지않기때문에 수동으로 결제창을 열어주셔야합니다.<br>nbsp;<br>주문결제 시도하셨을때 만약 아래와 같은 화면이 보이신다면 결제하기 버튼을 누르시면 KCP결제 페이지를 보실 수 있으십니다.<br><br><img src=http://i.imgur.com/UdtItem.png width=690><br><br>혹시 위에 사진과 같이 결제하기가 뜨지않고 이상한 문구가 뜨는 경우에는 KCP프로그램이 설치되지않아 발생하는 문제이오니, 결제하는 과정에서 KCP 결제에 필요한 자료를 설치 후 진행해주시기 바랍니다.<br>감사합니다.<br>',1,3,'admin01');
Insert into NMDB.TB_FAQ (FAQ_NO,FAQ_TITLE,FAQ_CONTENT,FAQ_DEL_CHECK,BOARD_ID,MEM_ID) values (3,'빨리 배송받는 방법을 알려주세요','오전 11시까지 주문/결제를 완료하시면<br>다음날 바로 상품을 배송 받으실 수 있습니다.<br>',0,3,'admin01');
Insert into NMDB.TB_FAQ (FAQ_NO,FAQ_TITLE,FAQ_CONTENT,FAQ_DEL_CHECK,BOARD_ID,MEM_ID) values (4,'빨리 배송받는 방법을 알려주세요','오전 11시까지 주문/결제를 완료하시면<br>다음날 바로 상품을 배송 받으실 수 있습니다.<br>',1,3,'admin01');
Insert into NMDB.TB_FAQ (FAQ_NO,FAQ_TITLE,FAQ_CONTENT,FAQ_DEL_CHECK,BOARD_ID,MEM_ID) values (5,'제품은 어떻게 보관해야 하나요?','저희 자연맘 제품은 원재료 외엔 첨가된 것이 없어 보관을 잘못하실 경우<br>변질되거나 벌레가 생길 수 있으니 보관에 주의하시기 바랍니다.<br>직사광선 및 습기를 피해 건냉한 곳에 보관하시고 냉장 또는 냉동보관 하시는 것이 좋습니다.<br>',0,3,'admin01');
Insert into NMDB.TB_FAQ (FAQ_NO,FAQ_TITLE,FAQ_CONTENT,FAQ_DEL_CHECK,BOARD_ID,MEM_ID) values (6,'정말 국내산이 맞나요?','조금만 살펴보면 알 수 있는 약초 등은 이미지로 비교하시면 쉽게 알 수 있고<br>구분이 어려운 한방차 등을 전문적으로 취급하시는 분이라면 어렵지 않게 구별하실 수 있습니다.<br>그리고, 수많은 경쟁업체들이 주시하고 있으며 소비자인양 구매를 해서 원산지 허위표시를<br>신고하기 때문에 더욱 철저하게 확인을 하고 있습니다.<br>저희 자연맘은 고객님들의 신뢰를 위해 원산지, 생산자 표기를 하여 보내드리고 있습니다.<br>',0,3,'admin01');
Insert into NMDB.TB_FAQ (FAQ_NO,FAQ_TITLE,FAQ_CONTENT,FAQ_DEL_CHECK,BOARD_ID,MEM_ID) values (7,'이 비누 먹어도 되나요?','저희 자연맘 제품은 인체에 무해하지만 식품이 아니므로<div>먹는 것은 삼가해주시고 피부에 양보해주시기 바랍니다 ^^</div>',0,3,'admin02');
REM INSERTING into NMDB.TB_INTEREST
SET DEFINE OFF;
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10000,'minhee');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10001,'admin02');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10001,'sora');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10002,'minhee');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10003,'soojin');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10003,'sora');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10004,'hanagang');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10004,'soojin');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10005,'pasley');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10005,'soomin');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10006,'soomin');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10006,'sora');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10007,'applepie');
Insert into NMDB.TB_INTEREST (PRODUCT_NO,MEM_ID) values (10007,'soomin');
REM INSERTING into NMDB.TB_MEMBER
SET DEFINE OFF;
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('admin01','1111','자연맘','010-7473-2442','140-190','서울시 용산구 후암동@406-7번지 상원빌2차','sseun0402@hanmail.net',to_date('90/04/02','RR/MM/DD'),2,0,10);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('admin02','123456','자연맘','010-1234-5678','330-847','충청남도 아산시 대방읍 장재리@용연마을 감자하우스','geunhoo@gmail.com',to_date('88/10/24','RR/MM/DD'),1,0,10);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('soomin','123456','윤수민','010-0000-0000','000-000','서울시 강동구 강동3동 강동아파트@102동 202호','soomin@natural.com',to_date('90/01/01','RR/MM/DD'),2,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('sora','1234','최소라','010-1111-1111','111-111','서울시 광진구 구의2동 구의아파트@101동 202호','hook1028@naver.com',to_date('90/02/02','RR/MM/DD'),2,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('soojin','4321','이수진','010-2222-2222','222-222','경기도 안산시 안산구 안산3동@안산아파트 403동 101호','sojin@natural.com',to_date('90/03/03','RR/MM/DD'),2,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('minhee','4321','최민희','010-333-3333','33333','경기도 남양주시 양주동 남양주아파트@303동 202호','minhee@natural.com',to_date('90/04/04','RR/MM/DD'),1,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('blacksmith','123456','강블랙','010-3344-8944','04402','서울 용산구 대사관로 48@대사관아파트 104동 1205호','black_smith@hotmail.com',to_date('91/04/05','RR/MM/DD'),1,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('gorani','123456','김고란','010-3466-8892','57724','전남 광양시 가야등길 64-24@2층','gorani0505@naver.com',to_date('82/06/07','RR/MM/DD'),1,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('applepie','123456','김애플','010-2367-3467','63308','제주특별자치도 제주시 첨단로 58@1층','applepie@hotmail.com',to_date('84/11/06','RR/MM/DD'),1,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('hook1028','123456','박소라','010-3454-4567','05048','서울 광진구 강변역로 18@2층','hook1028@naver.com',to_date('89/04/19','RR/MM/DD'),2,1,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('sora4567','123456','박소라','010-3144-2344','04948','서울 광진구 구의동 3-19@301호','hook@naver.com',to_date('89/04/13','RR/MM/DD'),2,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('sora1234','123456','강소라','010-2345-6789','04948','서울 광진구 구의동 3-16@201호','hook1028@naver.com',to_date('89/07/16','RR/MM/DD'),2,0,2);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('maru0903','akfnakfn','황마루','010-4322-0903','48000','부산 해운대구 반송로 830@높은 아파트 102동 1802호','maru0903@gmail.com',to_date('91/10/13','RR/MM/DD'),1,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('hanagang','123456','강하나','010-3434-7764','41008','대구 동구 갓바위로 35-15@선샤인빌 302호','flowergang@hanmail.net',to_date('85/06/15','RR/MM/DD'),2,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('sohee0628','123456','강소희','010-3456-6655','05247','서울 강동구 구천면로 148@한강리버빌 402호','sohee0628@naver.com',to_date('99/07/28','RR/MM/DD'),2,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('pasley','123456','양승현','010-2554-3655','08327','서울 구로구 가마산로 87@더높은아파트 101동 302호','pasley@nate.com',to_date('97/06/03','RR/MM/DD'),1,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('arooroo','123456','남아름','010-3878-7788','05007','서울 광진구 광나루로 346@브라운빌 101호','arooroo@hanmail.net',to_date('98/03/09','RR/MM/DD'),2,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('mozamoza','123456','윤명숙','010-3134-5644','05003','서울 광진구 광나루로 347@지층','moza0714@hanmail.net',to_date('73/08/14','RR/MM/DD'),2,0,1);
Insert into NMDB.TB_MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADDR_POST,MEM_ADDR_DETAIL,MEM_EMAIL,MEM_BIRTH,MEM_GENDER,DROP_OUT,MEM_LEVEL_CD) values ('kia_baseball','123456','윤석민','010-9877-6533','25627','강원 강릉시 강동면 강동초교길 10-3@코코넛빌라 301호','yoon_baseball@nate.com',to_date('71/04/19','RR/MM/DD'),1,0,1);
REM INSERTING into NMDB.TB_MEM_LEVEL
SET DEFINE OFF;
Insert into NMDB.TB_MEM_LEVEL (MEM_LEVEL_CD,MEM_LEVEL_NM) values (10,'관리자');
Insert into NMDB.TB_MEM_LEVEL (MEM_LEVEL_CD,MEM_LEVEL_NM) values (1,'일반회원');
Insert into NMDB.TB_MEM_LEVEL (MEM_LEVEL_CD,MEM_LEVEL_NM) values (2,'불량회원');
Insert into NMDB.TB_MEM_LEVEL (MEM_LEVEL_CD,MEM_LEVEL_NM) values (3,'비회원');
REM INSERTING into NMDB.TB_MEM_LEVEL_N_BOARD
SET DEFINE OFF;
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (10,1,1,1,1,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (10,2,1,1,1,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (10,3,1,1,1,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (10,4,1,1,1,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (10,5,1,1,1,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (1,1,1,0,0,0);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (1,2,1,1,1,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (1,3,1,0,0,0);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (1,4,1,1,1,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (1,5,1,1,1,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (2,1,1,0,0,0);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (2,2,1,0,0,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (2,3,1,0,0,0);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (2,4,1,0,0,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (2,5,1,0,0,1);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (3,1,1,0,0,0);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (3,2,1,0,0,0);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (3,3,1,0,0,0);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (3,4,0,0,0,0);
Insert into NMDB.TB_MEM_LEVEL_N_BOARD (MEM_LEVEL_CD,BOARD_CD,BOARD_READ,BOARD_WRITE,BOARD_MODIFY,BOARD_DELETE) values (3,5,1,0,0,0);
REM INSERTING into NMDB.TB_NOTICE
SET DEFINE OFF;
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (1,'자연맘 사이트 오픈을 축하해주세요',to_date('16/02/17','RR/MM/DD'),79,'<img src=http://i.imgur.com/jhU5RJN.jpg width=299><br>자연맘 사이트가 그랜드 오픈했습니다.<br>이제 온라인으로 친환경 자연맘 비누를 마음껏 구입하실 수 있습니다.<br><br>여러분 축하해주세요 짝짝짝!<br>',0,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (2,'설날연휴 휴무안내',to_date('16/02/17','RR/MM/DD'),126,'<img src=http://i.imgur.com/VIRttJX.jpg width=690><br>',0,null,null,1,'admin02');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (3,' 설날연휴 휴무안내',to_date('16/04/17','RR/MM/DD'),2,'<img src=http://i.imgur.com/VIRttJX.jpg width=690><br>',1,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (4,'자연맘 고객님 배송이 늦어져 정말 죄송합니다.',to_date('16/03/03','RR/MM/DD'),78,'안녕하세요 자연맘입니다.<br>핑거루트관련 주문 폭주로인하여 핑거루트주문고객 및 일반주문고객님들의<br>배송 및 배송관리가 원활하지 못해<br>고객님께 불편을 끼쳐드리게 된 점 정말 죄송하다는 말씀을 드리고싶습니다.<br><br>우선, 저희지역쪽 택배물량이 급증하다보니 택배사측(cj대한통운)과도 소통이 지연되어<br>송장번호 입력이 늦어져 발송이 됐음에도 취소를 해드리거나<br>제품이 잘못 발송된 경우가 많을 것이라 예상이됩니다.<br><br>이에따라 2/29~3/4까지 오배송된 건들의 문의접수를 받고<br>재발송을 해드리려고합니다.<br><br>자연맘을 믿고 주문해주셨는데 배송이 늦어져 한번,<br>물건이 잘못 발송되어 두번,<br>배송관련 문의 대응부족 세번,<br>여러번 실망하셨을 고객님들께 정말 죄송하다는 말씀을 드립니다.<br><br>다음주는 전화문의량이 많아 연결이 원활하지 못할것으로 예상됩니다.<br>카카오톡 플러스친구 @자연맘을 등록하여 오배송건들에 대해 문의를 주시면<br>확인 후 최대한 빠른 시일내 제품을 재발송해드리도록 하겠습니다.<br>(@자연맘 검색 시 나오지않으신다면 @자연으로 검색하시면 16번째 @자연맘을 찾으실 수 있으십니다.)<br><br>이번 핑거루트사태를 계기로 자연맘 구성원들 모두 비상체제로<br>문제점을 개선해나가고 있사오니 조금만 넓은 아량으로 이해해주시면<br>보다 좋은 제품과 서비스로 보답하는 자연맘이 되도록 노력하겠습니다.<br>감사합니다.<br>',0,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (5,'트러블 살결에 좋은 강황비누 입고!!',to_date('16/03/14','RR/MM/DD'),11,'트러블에 좋은 비누가 있었으면 좋겠다는 많은 회원님의 건의에 따라<div>트러블 살결에 좋은 강황비누를 입고했습니다!</div><div><br></div><div>회원님들의 많은 이용 및 후기 부탁드립니다 ^^!</div><div>오늘도 자연맘과 함께 뽀득하고 깨끗한 하루 되세요~</div>',0,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (7,'어성초 비누 입고 안내',to_date('16/03/17','RR/MM/DD'),6,'깨끗한 살결을 위한 어성초 비누가 입고되었습니다.<div>발효어성초 비누와는 다른 제품이니 구매 시 참고해주시기 바랍니다.</div><div>고맙습니다^^</div>',0,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (6,'택배사 안내',to_date('16/03/22','RR/MM/DD'),11,'자연맘의 택배사가 우체국 택배에서 CJ 대한통운으로 바뀌게 되었습니다.<div>고맙습니다 ^^</div>',0,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (8,'감초비누 입고 지연 안내',to_date('16/03/27','RR/MM/DD'),15,'25일 입고 예정이었던 감초비누가 27일로 입고일이 미뤄졌습니다.<div>입고 지연으로 인한 불편을 드려 죄송합니다.</div>',0,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (9,'함초비누 입고 안내',to_date('16/04/02','RR/MM/DD'),5,'트러블 및 여드름에 좋은 함초비누가 입고되었습니다.<div>많은 구매 부탁드립니다 ^^</div>',0,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (10,'25일 주문 마감시간 변경 안내',to_date('16/04/20','RR/MM/DD'),9,'4월 25일(월) 하루에 한 해 주문 마감 시간이 오전 10시로 변경됩니다.<div>이용에 불편을 드려 죄송합니다.</div>',0,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (11,'결제 시스템 점검 안내',to_date('16/04/21','RR/MM/DD'),11,'27~29일 간 하나, (구)외환 카드사의 시스템 점검으로 인해 결제가 불가능합니다.<div>이용에 불편을 드려 정말 죄송합니다.</div>',0,null,null,1,'admin01');
Insert into NMDB.TB_NOTICE (NOTICE_NO,NTC_TITLE,NTC_WRITE_DAY,NTC_HITS,NTC_CONTENT,NTC_DEL_CHECK,NTC_ATTACHED_FILE1,NTC_ATTACHED_FILE2,BOARD_ID,MEM_ID) values (12,'카모마일 비누 입고 예정',to_date('16/04/22','RR/MM/DD'),23,'카모마일 비누가 빠르면 22일에 입고됩니다.<div>많은 구매 부탁드립니다. ^^</div>',0,null,null,1,'admin01');
REM INSERTING into NMDB.TB_NOTICE_RE
SET DEFINE OFF;
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (1,'오픈 ㅊㅋㅊㅋ여',to_date('16/04/17','RR/MM/DD'),0,1,'soomin');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (2,'관리자님.. 이거 중복인듯',to_date('16/04/17','RR/MM/DD'),0,3,'sora');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (3,'헐 늦으면 안되요 현기증나요',to_date('16/04/17','RR/MM/DD'),0,4,'soomin');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (4,'ㅠㅠ 비누 안오면 그동안 뭐로 닦죠?',to_date('16/04/17','RR/MM/DD'),0,4,'soojin');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (5,'난 이거 안시켰어요 아싸',to_date('16/04/17','RR/MM/DD'),1,4,'minhee');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (6,'불편을 드려 대단히 죄송합니다, 더 좋은 제품으로 보답하는 자연맘 되도록 하겠습니다.',to_date('16/04/17','RR/MM/DD'),0,4,'admin02');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (7,'추카드려욯ㅎㅎ',to_date('16/04/18','RR/MM/DD'),0,1,'sora1234');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (8,'추카추카~~',to_date('16/04/19','RR/MM/DD'),0,1,'maru0903');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (9,'강황비누 특이하네여!!',to_date('16/04/22','RR/MM/DD'),0,5,'sora');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (10,'우체국 택배가 더 좋았는데 아쉽네요ㅠㅠㅠ',to_date('16/04/22','RR/MM/DD'),0,6,'sora');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (11,'헐 트러블에 좋은 비누라니 대박! 꼭 살게요!!',to_date('16/04/22','RR/MM/DD'),0,9,'sora');
Insert into NMDB.TB_NOTICE_RE (NOTICE_RE_NO,NTC_RE_CONTENT,NTC_RE_WRITE_DAY,NTC_RE_DEL_CHECK,NOTICE_NO,MEM_ID) values (12,'우와 맛있겠다',to_date('16/04/22','RR/MM/DD'),0,12,'soojin');
REM INSERTING into NMDB.TB_ORDER
SET DEFINE OFF;
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10000,to_date('15/10/17','RR/MM/DD'),3900,'1234123412341234','1901','이수진','010-2222-2222','111-221','경기도 안산시 안산구 안산3동 안산아파트 403동 101호','배송전 연락바람',1234567890,10,1,'soojin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10001,to_date('15/10/17','RR/MM/DD'),9000,'1234123412341234','1901','최소라','010-1111-1111','111-222','서울시 광진구 구의2동 구의아파트 101동 202호','무인택배함에 넣어주세요',1234567880,10,2,'sora');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10002,to_date('15/11/17','RR/MM/DD'),8600,'1234123412341234','1901','이수진','010-2222-2222','111-223','경기도 안산시 안산구 안산3동 안산아파트 403동 101호','배송전 연락바람',12345676,13,4,'soojin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10003,to_date('15/11/27','RR/MM/DD'),5500,'1234123412341234','1901','윤수민','010-0000-0000','111-224','서울시 강동구 강동3동 강동아파트 102동 202호','빨리 갖다주세요 현기증나요',1234567,17,4,'soomin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10004,to_date('15/12/17','RR/MM/DD'),5500,'1234123412341234','1901','윤수민','010-0000-0000','111-225','서울시 강동구 강동3동 강동아파트 102동 202호','빨리 갖다주세요 현기증나요',1234567,17,4,'soomin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10005,to_date('15/12/25','RR/MM/DD'),10500,'1234123412341234','1901','최소라','010-1111-1111','111-226','서울시 광진구 구의2동 구의아파트 101동 202호','무인택배함에 넣어주세요',1234567,11,4,'sora');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10006,to_date('15/12/26','RR/MM/DD'),3500,'1234123412341234','1901','최민희','010-3333-3333','111-227','경기도 남양주시 양주동 남양주아파트 303동 202호','미니미니 택배왔숑',1234567,16,4,'minhee');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10007,to_date('15/12/26','RR/MM/DD'),4300,'1234123412341234','1901','최소라','010-1111-1111','111-228','서울시 광진구 구의2동 구의아파트 101동 202호','무인택배함에 넣어주세요',1234567,11,4,'sora');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10008,to_date('15/12/26','RR/MM/DD'),15100,'4322244534787799','2007','최소라','010-1111-1111','111-111','서울시 광진구 구의2동 구의아파트 101동 202호','부재 시 옆집에 맡겨주세요',12345678,13,4,'sora');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10009,to_date('16/01/04','RR/MM/DD'),33700,'2789445532768892','1805','윤수민','010-0000-0000','000-000','서울시 강동구 강동3동 강동아파트 102동 202호','배송 전에 연락주세요~',1234567,12,null,'soomin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10010,to_date('16/01/04','RR/MM/DD'),23100,'2345344445689973','2310','이수진','010-2222-2222','222-222','경기도 안산시 안산구 안산3동 안산아파트 403동 101호','-',4321234,14,1,'soojin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10011,to_date('16/01/04','RR/MM/DD'),25500,'9866404423883611','2804','이수진','010-2222-2222','222-222','경기도 안산시 안산구 안산3동 안산아파트 403동 701호','부재 시 경비실에 맡겨주세요~',4321233,10,1,'soojin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10012,to_date('16/01/04','RR/MM/DD'),45900,'4555666523769413','1906','강하나','010-3434-7764','41008','대구 동구 갓바위로 35-15 선샤인빌 302호','-',1234567,11,null,'hanagang');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10013,to_date('16/01/21','RR/MM/DD'),25100,'7833236544661779','1707','강블랙','010-3344-8944','04402','서울 용산구 대사관로 48 대사관아파트 104동 1205호','부재 시 경비실에 맡겨주세요',1234567,11,1,'blacksmith');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10014,to_date('16/01/21','RR/MM/DD'),33300,'2789436645772144','1803','최민희','010-333-3333','333-333','경기도 남양주시 양주동 남양주아파트 303동 202호','-',1234564,14,1,'minhee');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10015,to_date('16/01/24','RR/MM/DD'),20300,'4118455521657422','1804','황마루','010-4322-0903','48000','부산 해운대구 반송로 830 높은 아파트 102동 1802호','부재 시 무인택배함에 넣어주세요',12345670,15,null,'maru0903');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10017,to_date('16/02/21','RR/MM/DD'),44000,'2425334356885654','2405','강하나','010-3434-7764','41008','대구 동구 갓바위로 35-15 선샤인빌 302호','-',1234567,11,null,'hanagang');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10024,to_date('16/02/22','RR/MM/DD'),11700,'1234234534564567','2004','최소라','010-1111-1111','111-111','서울시 광진구 구의2동 구의아파트 101동 202호','-',1234567,13,1,'sora');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10034,to_date('16/02/22','RR/MM/DD'),59500,'4567655545635789','2405','김애플','010-2367-3467','63308','제주특별자치도 제주시 첨단로 58 1층','-',1234567,14,null,'applepie');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10038,to_date('16/02/22','RR/MM/DD'),28400,'5564645767835495','2404','강하나','010-3434-7764','41008','대구 동구 갓바위로 35-15 선샤인빌 302호','-',1234567,13,null,'hanagang');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10047,to_date('16/04/22','RR/MM/DD'),24900,'1234123443211234','2603','박소라','010-3454-4567','05048','서울 광진구 강변역로 18 2층','부재 시 아랫집에 맡겨주세요',1234567,14,1,'hook1028');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10016,to_date('16/02/22','RR/MM/DD'),33000,'6544334554363567','2107','김애플','010-2367-3467','63308','제주특별자치도 제주시 첨단로 58 1층','연락하고 와주세용',2345678,11,1,'applepie');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10018,to_date('16/02/22','RR/MM/DD'),16300,'3444346557554566','1906','양승현','010-2554-3655','08327','서울 구로구 가마산로 87 더높은아파트 101동 302호','부재 시 경비실에 맡겨주세요',12345678,12,3,'pasley');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10019,to_date('16/03/02','RR/MM/DD'),34200,'2467456544658865','2205','김고란','010-3466-8892','57724','전남 광양시 가야등길 64-24 2층','-',3456789,12,1,'gorani');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10020,to_date('16/03/02','RR/MM/DD'),44500,'422704563577486','1810','최소라','010-1111-1111','111-111','서울시 광진구 구의2동 구의아파트 101동 202호','-',1234567,16,null,'sora');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10021,to_date('16/03/12','RR/MM/DD'),24500,'3344337765775654','2007','이수진','010-2222-2222','222-222','경기도 안산시 안산구 안산3동 안산아파트 403동 101호','-',2345678,11,1,'soojin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10022,to_date('16/03/12','RR/MM/DD'),25500,'1234123443322554','2006','최소라','010-1111-1111','111-111','서울시 광진구 구의2동 구의아파트 101동 202호','-',1234567,10,null,'sora');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10023,to_date('16/03/12','RR/MM/DD'),7500,'1234433212345433','1804','최소라','010-1111-1111','111-111','서울시 광진구 구의2동 구의아파트 101동 202호','-',1234567,10,null,'sora');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10025,to_date('16/03/22','RR/MM/DD'),25400,'1234123443323456','3902','강소희','010-3456-6655','05247','서울 강동구 구천면로 148 한강리버빌 402호','-',12345670,15,null,'sohee0628');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10026,to_date('16/03/22','RR/MM/DD'),15900,'4566456665444564','2103','양승현','010-2554-3655','08327','서울 구로구 가마산로 87 더높은아파트 101동 302호','부재 시 경비실에 맡겨주세요',1234567,12,null,'pasley');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10029,to_date('16/03/22','RR/MM/DD'),40500,'1543545576443456','2204','윤수민','010-0000-0000','000-000','서울시 강동구 강동3동 강동아파트 102동 202호','-',1234567,13,null,'soomin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10030,to_date('16/03/22','RR/MM/DD'),23100,'4676464745475575','2304','이수진','010-2222-2222','222-222','경기도 안산시 안산구 안산3동 안산아파트 403동 101호','-',1234567,10,null,'soojin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10031,to_date('16/03/22','RR/MM/DD'),30100,'9785797989788788','2202','최민희','010-333-3333','33333','경기도 남양주시 양주동 남양주아파트 303동 202호','부재시 경비실에 맡겨주세요',1234567,14,null,'minhee');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10032,to_date('16/03/22','RR/MM/DD'),19600,'2446455623465776','2606','강블랙','010-3344-8944','04402','서울 용산구 대사관로 48 대사관아파트 104동 1205호','-',1234567,11,null,'blacksmith');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10033,to_date('16/04/02','RR/MM/DD'),40100,'6674453367448432','2402','김고란','010-3466-8892','57724','전남 광양시 가야등길 64-24 2층','-',12345670,12,null,'gorani');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10035,to_date('16/04/02','RR/MM/DD'),37200,'4354756735367567','2703','박소라','010-3144-2344','04948','서울 광진구 구의동 3-19 301호','배송 전 연락 부탁드려요',12345670,15,null,'sora4567');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10036,to_date('16/04/02','RR/MM/DD'),57000,'798035776554550','1810','강소라','010-2345-6789','04948','서울 광진구 구의동 3-16 201호','-',1234567,15,null,'sora1234');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10037,to_date('16/04/17','RR/MM/DD'),43700,'5009768966553567','2308','황마루','010-4322-0903','48000','부산 해운대구 반송로 830 높은 아파트 102동 1802호','-',1234567,16,null,'maru0903');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10039,to_date('16/04/22','RR/MM/DD'),20600,'3655456345342344','2708','강소희','010-3456-6655','05247','서울 강동구 구천면로 148 한강리버빌 402호','-',1234567,16,null,'sohee0628');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10040,to_date('16/04/22','RR/MM/DD'),36300,'5554455464786035','1611','양승현','010-2554-3655','08327','서울 구로구 가마산로 87 더높은아파트 101동 302호','-',12345670,13,null,'pasley');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10041,to_date('16/04/22','RR/MM/DD'),53200,'4576565456543455','2407','남아름','010-3878-7788','05007','서울 광진구 광나루로 346 브라운빌 101호','-',1234567,12,null,'arooroo');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10042,to_date('16/04/22','RR/MM/DD'),47200,'6788667544332567','2408','윤명숙','010-3134-5644','05003','서울 광진구 광나루로 347 지층','-',1234567,15,null,'mozamoza');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10043,to_date('16/04/22','RR/MM/DD'),87000,'3455653434533455','1909','윤석민','010-9877-6533','25627','강원 강릉시 강동면 강동초교길 10-3 코코넛빌라 301호','-',1234567,14,null,'kia_baseball');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10044,to_date('16/04/22','RR/MM/DD'),23700,'353456776655566','2705','이수진','010-2222-2222','222-222','경기도 안산시 안산구 안산3동 안산아파트 403동 101호','-',987654,17,1,'soojin');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10045,to_date('16/04/22','RR/MM/DD'),24500,'4566544577665564','2608','김고란','010-3466-8892','57724','전남 광양시 가야등길 64-24 2층','-',0,17,null,'gorani');
Insert into NMDB.TB_ORDER (ORDER_NO,ORDER_DATE,CHARGE,CREDIT_NUM,CREDIT_EXP,RCV_NAME,RCV_PHONE,RCV_ADDR_POST,RCV_ADDR_DETAIL,DELIVERY_MSG,TRACKING_NUM,CREDIT_CD,DELIVERY_COM_CD,MEM_ID) values (10046,to_date('16/04/22','RR/MM/DD'),26000,'4534534656444534','2604','강블랙','010-3344-8944','04402','서울 용산구 대사관로 48 대사관아파트 104동 1205호','-',0,12,null,'blacksmith');
REM INSERTING into NMDB.TB_PROCESS
SET DEFINE OFF;
Insert into NMDB.TB_PROCESS (PROCESS_CD,PROCESS_NM) values (11,'배송준비중');
Insert into NMDB.TB_PROCESS (PROCESS_CD,PROCESS_NM) values (12,'배송대기');
Insert into NMDB.TB_PROCESS (PROCESS_CD,PROCESS_NM) values (13,'배송중');
Insert into NMDB.TB_PROCESS (PROCESS_CD,PROCESS_NM) values (14,'배송완료');
Insert into NMDB.TB_PROCESS (PROCESS_CD,PROCESS_NM) values (21,'구매확정');
Insert into NMDB.TB_PROCESS (PROCESS_CD,PROCESS_NM) values (31,'환불요청');
Insert into NMDB.TB_PROCESS (PROCESS_CD,PROCESS_NM) values (32,'환불완료');
REM INSERTING into NMDB.TB_PRODUCT
SET DEFINE OFF;
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10000,'아마씨 비누',3500,3000,74,1,1,'soap1.jpg','soap1_desc.jpg','영양 가득한 생명의 씨앗',null,0,100,1);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10001,'붉나무 비누',5500,4000,45,0,1,'soap2.jpg','soap2_desc.jpg','건강하고 생기있는 살결을 위해',null,0,90,2);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10002,'뽕잎 비누',4300,3500,93,1,1,'soap12.jpg','soap12_desc.jpg','맑은 피부톤을 위한',null,0,90,3);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10003,'쑥 비누',4300,3500,82,1,1,'soap11.jpg','soap11_desc.jpg','풍부한 무기질과 비타민의',null,0,90,4);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10004,'발효어성초 비누',4500,3500,64,1,1,'soap10.jpg','soap10_desc.jpg','지성 피부를 위한','<br>',0,90,3);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10005,'로즈마리 비누',4500,3500,75,1,1,'soap9.jpg','soap9_desc.jpg','보습 및 피부 탄력을 위한',null,0,90,2);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10006,'감초 비누',3900,3000,77,1,1,'soap8.jpg','soap8_desc.jpg','민감한 살결에 좋은',null,0,90,3);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10007,'편백나무 비누',4300,3500,71,1,1,'soap7.jpg','soap7_desc.jpg','피톤치드가 함유되어 있는',null,0,90,4);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10008,'함초 비누',4600,3500,221,1,1,'soap4.jpg','soap4_desc.jpg','잡티, 트러블 피부에 도움되는~','<br>',0,100,3);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10014,'카모마일 비누',4500,3500,100,1,1,'1.jpg','6.jpg','테스트 상품입니다','<br>',1,90,4);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10011,'테스트',1234,123,1,1,1,'1.jpg','2.jpg','테스트','ㄴㄹㄴㄹㄴㄹ',1,2,1);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10013,'어성초비누',4000,3000,113,1,1,'soap3.jpg','soap3_desc.jpg','살결의 청결과 진정을 위한','<br>',0,90,4);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10009,'dd',1,2,3,1,1,'15.jpg','14.jpg','dgd','<br>dgdg',1,4,1);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10010,'sfsf',1,2,3,1,1,'1.jpg','2.jpg','sf','<br>sf',1,4,1);
Insert into NMDB.TB_PRODUCT (PRODUCT_NO,PRODUCT_NAME,SELLING_PRICE,COST_PRICE,STOCK,DISPLAY_STATE,SALE_STATE,REPRESENT_IMG,DETAIL_IMG,SUMMARY_EX,DETAIL_EX,DELETED_STATE,WEIGHT,CATEGORY_CD) values (10012,'강황 비누',4100,3000,68,1,1,'soap5.jpg','soap5_desc.jpg','트러블 살결에 추천!','<br>',0,87,3);
REM INSERTING into NMDB.TB_PRODUCT_N_ORDER
SET DEFINE OFF;
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10000,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10001,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10002,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10001,10003,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10001,10004,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10005,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10006,1,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10007,1,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10008,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10008,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10009,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10001,10009,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10009,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10009,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10009,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10010,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10010,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10010,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10010,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10011,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10001,10012,3,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10012,3,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10012,3,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10013,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10001,10013,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10013,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10013,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10013,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10001,10014,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10014,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10015,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10015,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10012,10015,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10012,10017,10,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10024,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10012,10024,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10034,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10034,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10012,10034,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10013,10034,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10038,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10038,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10038,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10047,3,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10047,2,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10016,3,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10016,5,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10018,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10018,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10019,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10019,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10012,10019,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10020,2,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10020,3,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10020,1,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10020,1,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10020,1,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10020,1,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10012,10020,1,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10021,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10022,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10023,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10025,4,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10025,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10025,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10026,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10026,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10029,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10029,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10029,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10029,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10029,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10013,10029,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10030,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10030,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10030,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10030,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10031,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10031,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10031,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10032,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10032,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10003,10032,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10032,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10033,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10033,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10033,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10035,6,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10035,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10035,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10012,10035,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10036,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10012,10036,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10037,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10037,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10037,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10013,10037,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10039,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10039,2,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10040,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10040,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10040,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10013,10040,1,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10041,3,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10041,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10041,4,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10042,6,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10042,4,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10043,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10004,10043,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10043,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10043,5,21);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10005,10044,2,12);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10006,10044,3,12);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10002,10045,4,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10007,10045,1,32);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10008,10046,5,11);
Insert into NMDB.TB_PRODUCT_N_ORDER (PRODUCT_NO,ORDER_NO,BUY_NUM,PROCESS_CD) values (10000,10036,3,21);
REM INSERTING into NMDB.TB_QNA
SET DEFINE OFF;
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (1,'이곳은 질문을 올리는 게시판입니다',to_date('16/04/17','RR/MM/DD'),39,'궁금한 사항이 있으면 언제든지 이 게시판에 글을 남겨주세요!<br>친절한 자연맘 지기가 여러분의 궁금증을 해결해 드립니다<br><br>QnA 게시판은 자연맘 회원만 이용하실 수 있습니다<br>감사합니다.<br>',0,null,0,1,4,'admin01');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (2,'제가 주문한 비누 언제와요?',to_date('16/04/17','RR/MM/DD'),7,'비누 방금 주문했는데<br>언제 받아볼 수 있나여<br>주말이 끼어있어서 내일은 못받아 보는건가요<br>저 현기증나요<br>',0,null,0,2,4,'soomin');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (3,'답변입니다^^',to_date('16/04/17','RR/MM/DD'),4,'soomin 고객님, <br>지금 주문하신 사항 바로 확인되었습니다.<br><br>현기증 나지 않게 바로 배송처리 해드렸습니다.<br>배송상태 바로 확인하시면 언제쯤 물건 받으실 지 알아 보실 수 있습니다<br><br>저희 자연맘을 이용해 주셔서 감사합니다^^<br>',0,null,1,2,4,'admin01');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (4,'이 비누 정말 자연 그대로인가요?',to_date('16/04/17','RR/MM/DD'),11,'유기농 재료로 인체에 무해한 비누인거 확실하나요?<br>저한테는 정말 중요한 사항이에요<br><br>실수로 비누를 먹을 수도 있잖아요<br>제가 그렇다는게 아니라<br>어쨋든 말이죠<br><br>빠른 답변바랍니다.<br>',0,'1234',0,4,4,'sora');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (5,'답변입니다^^',to_date('16/04/17','RR/MM/DD'),8,'sora 고객님,<br><br>저희는 천연 유기농 재료로만 사용하여 믿고 사용하실 수 있는 제품이 맞습니다.<br>하지만 고객님 비누를 섭취하시는 것은 몸에 유해할 수 있으니 삼가 주시는게 좋을 것 같습니다.<br><br>저희 자연맘을 이용해 주셔서 감사합니다^^<br>',0,'1234',1,4,4,'admin01');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (6,'정말 감사합니다 자연맘 사랑해요',to_date('16/04/17','RR/MM/DD'),6,'정말 이상한 질문 했다고 생각했는데<br>친절하게 답변해주시고.. 정말 자연맘 좋네요<br><br>다음에도 자주 구입할게요<br>비누도 너무 좋아요<br>맛도 좋아요<br>',0,null,2,4,4,'sora');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (7,'비누가 이상해요',to_date('16/04/17','RR/MM/DD'),10,'비누가 이상해요<br>미끌미끌하고<br>거품이나요<br><br>거의 다 써가는데 환불되나요?<br>',1,null,1,1,4,'minhee');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (8,'답변입니다^^',to_date('16/04/17','RR/MM/DD'),2,'minhee 고객님,<br><br>구입하신 비누가 미끌미끌하고 거품이 나는건<br>정상제품이기 때문에 환불이 불가능합니다.<br><br>거품으로 깨끗하게 세안하시고 남은 제품도 끝까지 사용하셔서<br>아름다운 피부 가꾸시길 바랍니다<br><br>감사합니다^^<br>',1,null,2,1,4,'admin02');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (13,'감초 비누 언제 들어오나요?',to_date('16/04/20','RR/MM/DD'),7,'감초비누 써보고 시픈데 품절이네여ㅠㅠㅠㅠ',0,null,0,13,4,'sora');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (11,'Re : 고맙습니다',to_date('16/04/18','RR/MM/DD'),5,'번창하세요',0,null,2,2,4,'soomin');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (19,'Re : 사과비누는 왜 없나요?',to_date('16/04/22','RR/MM/DD'),1,'사과비누에 쓰일 좋은 사과를 찾는 중입니다<div>기다려주세요 ^^</div>',0,null,1,14,4,'admin01');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (20,'건성에 좋은 비누는 없나요?',to_date('16/04/22','RR/MM/DD'),1,'건성에 좋은 비누 좀 입고시켜 주세요ㅠㅠ',0,'1234',0,20,4,'hook1028');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (12,'이 비누 먹을 수 있나요',to_date('16/04/18','RR/MM/DD'),8,'천연비누잖아여~~~~',0,null,0,12,4,'sora1234');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (14,'사과비누는 왜 없나요?',to_date('16/04/21','RR/MM/DD'),14,'사과비누도 만들어주세요...',0,'1234',0,14,4,'applepie');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (15,'Re : 사과비누는 맛있어요',to_date('16/04/21','RR/MM/DD'),5,'다른 비누는 별루...',0,null,1,12,4,'applepie');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (16,'Re : 사과비누는 왜 없나요?',to_date('16/04/22','RR/MM/DD'),2,'안녕하세요 고객님<div>사과비누는 비누에 쓰일 좋은 사과를 물색중이랍니다 ^^</div><div>기다려주세요!</div>',1,null,2,14,4,'admin01');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (17,'Re : Re : 사과비누 원래 먹는거예요?',to_date('16/04/22','RR/MM/DD'),2,'헐..비눈데 먹어요?',0,null,2,12,4,'sora');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (18,'품절된 비누중에...',to_date('16/04/22','RR/MM/DD'),1,'먹고 싶은게 있는대<img src="http://i.imgur.com/VOmB9Wz.png" width="190">',0,'1234',0,18,4,'soojin');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (9,'이 비누 먹어도 되나요?',to_date('16/04/18','RR/MM/DD'),12,'천연 비누니까 먹어도 되죠?',0,'1234',0,9,4,'soomin');
Insert into NMDB.TB_QNA (QNA_NO,QNA_TITLE,QNA_WRITE_DAY,QNA_HITS,QNA_CONTENT,QNA_DEL_CHECK,QNA_PW,QNA_POS,QNA_REF,BOARD_ID,MEM_ID) values (10,'이 스테이지는 내 스테이지야',to_date('16/04/18','RR/MM/DD'),2,'메롱메롱',1,null,0,10,4,'soomin');
REM INSERTING into NMDB.TB_QNA_RE
SET DEFINE OFF;
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (1,'좋은 게시판이네요 야호',to_date('16/04/17','RR/MM/DD'),0,1,'soojin');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (2,'궁금한게 많았는데 다행',to_date('16/04/17','RR/MM/DD'),0,1,'soomin');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (3,'빨리 답글좀여.. 현기증나여',to_date('16/04/17','RR/MM/DD'),0,2,'soomin');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (4,'관리자님 진짜 수고하시는듯 해요ㅠㅠ',to_date('16/04/17','RR/MM/DD'),0,8,'sora');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (5,'나만 그래요?',to_date('16/04/17','RR/MM/DD'),1,7,'minhee');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (10,'sora 회원님
항상 저희 자연맘을 이용해주셔서 고맙습니다~
감초비누 재입고 되었답니다 ^^',to_date('16/04/21','RR/MM/DD'),0,13,'admin01');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (11,'저희 자연맘의 비누는 먹지 말고 피부에 양보해주시길 바랍니다 감사합니다 ^^',to_date('16/04/21','RR/MM/DD'),0,12,'admin01');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (9,'헐 비누를 먹어요??',to_date('16/04/19','RR/MM/DD'),0,12,'maru0903');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (6,'답글 왤케 늦게주세요',to_date('16/04/18','RR/MM/DD'),0,2,'soomin');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (7,'먹어도 되자나여',to_date('16/04/18','RR/MM/DD'),0,9,'soomin');
Insert into NMDB.TB_QNA_RE (QNA_RE_NO,QNA_RE_CONTENT,QNA_RE_WRITE_DAY,QNA_RE_DEL_CHECK,QNA_NO,MEM_ID) values (8,'댓글등록등록',to_date('16/04/18','RR/MM/DD'),1,9,'soomin');
REM INSERTING into NMDB.TB_REVIEW
SET DEFINE OFF;
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (1,'정말정말 좋네요',to_date('16/04/17','RR/MM/DD'),36,'향기가 너무 좋아요~~~~ 스멜굿<br>향기가 너무 좋아요~~~~ 스멜굿<br>향기가 너무 좋아요~~~~ 스멜굿향기가 너무 좋아요~~~~ 스멜굿향기가 너무 좋아요~~~~ 스멜굿향기가 너무 좋아요~~~~ 스멜굿향기가 너무 좋아요~~~~ 스멜굿향기가 너무 좋아요~~~~ 스멜굿<br>향기가 너무 좋아요~~~~ 스멜굿향기가 너무 좋아요~~~~ 스멜굿',0,5,10003,5,'sora');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (2,'어메이징',to_date('16/04/17','RR/MM/DD'),11,'부들부들 해져요 짱좋! ',0,4,10003,5,'soojin');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (3,'배송 빠름',to_date('16/04/17','RR/MM/DD'),85,'현기증 났는데 빨리 왔어요',0,3,10007,5,'soomin');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (4,'짱짱',to_date('16/04/17','RR/MM/DD'),68,'이 비누 정말 짱인듯 또 살래요 두번살래요',0,5,10006,5,'sora');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (5,'뚬치뚬치',to_date('16/04/17','RR/MM/DD'),8,'심장이 바운스바운스 두근대 들킬까봐 겁나',0,1,10005,5,'minhee');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (6,'또 구입할예정',to_date('16/04/17','RR/MM/DD'),9,'가격도 저렴한데 피부도 많이 좋아졌어요<br>자연맘 감사해요<br>',0,3,10006,5,'soomin');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (7,'동생 여드름에 좋다그래서 샀어요',to_date('16/04/17','RR/MM/DD'),17,'동생 여드름에 좋다고해서 구입했어요 <br> 안여돼였는데 이제 안돼에요',0,4,10003,5,'soojin');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (25,'관리자님이 추천해주셔서 사봤는데',to_date('16/04/21','RR/MM/DD'),0,'<img src="http://i.imgur.com/cCm3JdE.jpg" width="100"><div>역시 관리자님이 추천해주시는데는 ㅇㅣ유가 있네요 ^^...</div>',0,5,10012,5,'maru0903');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (23,'동생 줬는데 괜찮대요~',to_date('16/04/19','RR/MM/DD'),0,'비누도 단 냄새 나서 좋다고 하네여ㅋㅋㅋㅋ<div>양갱같아서 먹고 싶어진대여ㅋㅋㅋㅋㅋㅋㅋㅋㅋ</div><div>민감한건 좀 나아지는 거 같다고 합니당</div>',0,4,10006,5,'hanagang');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (19,'냄새가 좀 이상한데 중독 돼요',to_date('16/04/19','RR/MM/DD'),0,'천연 비누라 그런거겠죠?<div>중독되지만 이상해서 별 하나 뺐어요</div><div>비누는 정말 좋아요ㅋㅋㅋ</div>',0,4,10002,5,'maru0903');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (20,'건성도 쓰기에 나쁘지 않은 거 같아요',to_date('16/04/19','RR/MM/DD'),0,'엄마가 악건성인데 나쁘지 않다네요~<div>쓰고나서 당김이 좀 나아졌대요ㅎㅎ</div>',0,5,10003,5,'maru0903');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (21,'헐 넘나 좋은 것',to_date('16/04/19','RR/MM/DD'),0,'기름종이로 얼굴 닦으면 2장 꼭 필요한데<div>이거 쓰고 나서는 1장만 있어도 돼요!!</div><div>더 쓰면 한장도 필요 없을 거 같아요!!!!!! 짱조아~~!!!!!!!!!</div><div>죽을 떄까지 안고 가려구요 ^0^</div>',0,5,10004,5,'hanagang');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (22,'이거는 그냥 무난무난한 거 같아요',to_date('16/04/19','RR/MM/DD'),0,'여드름에 좋다고 리뷰에 있어서 샀는데 저는 효과가 별로 없네요ㅠㅠㅠ<div><br></div><div>여드름에 좋다고 리뷰에 있어서 샀는데 저는 효과가 별로 없네요ㅠㅠㅠ여드름에 좋다고 리뷰에 있어서 샀는데 저는 효과가 별로 없네요ㅠㅠㅠ</div><div>여드름에 좋다고 리뷰에 있어서 샀는데 저는 효과가 별로 없네요ㅠㅠㅠ</div>',0,3,10003,5,'hanagang');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (24,'친구 선물로 샀어요~~~~',to_date('16/04/19','RR/MM/DD'),0,'뽕잎비누라 이름이 좀 이상한데 친구는 좋아하더라구요ㅋㅋㅋ',0,4,10002,5,'hanagang');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (26,'향이 너무 좋아요',to_date('16/04/21','RR/MM/DD'),0,'세정력은 살짝 약한 거 같은데 향이 너무 좋아서 계속 쓰게 돼요~<div>세정력 때문에 별 하나 뺐어요~</div>',0,4,10005,5,'pasley');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (11,'먹어도 되네요',to_date('16/04/18','RR/MM/DD'),0,'마슨 업서요..',0,3,10000,5,'soomin');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (12,'맛 없는데',to_date('16/04/18','RR/MM/DD'),0,'자꾸 먹게 되네요 이 묘한 중독감',0,4,10000,5,'soomin');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (13,'이제 그만 먹고 싶다ㅠㅠㅠ',to_date('16/04/18','RR/MM/DD'),0,'넘나 힘들어요...',0,5,10000,5,'soojin');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (14,'무난무난 한 거 같아요',to_date('16/04/18','RR/MM/DD'),0,'세정력은 나쁘지 않은 거 같은데 씻고나서 개운함이 좀 덜하네요..<div>다들 드시는 거 같길래 좀 먹어봤는데 이거 왜 먹는지 모르겠어요.....ㅠㅠ</div>',0,3,10000,5,'sora');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (15,'엄마가 좋아해요~',to_date('16/04/18','RR/MM/DD'),0,'이거 쓰면 피부가 덜 건조하고 촉촉하대요ㅋㅋ',0,4,10000,5,'sora');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (16,'붉나무는 첨 들어보는데',to_date('16/04/19','RR/MM/DD'),0,'<font size="6"><font color="#cc3399">비누는 참 좋네요~ㅎㅎ</font></font>',0,4,10001,5,'soomin');
Insert into NMDB.TB_REVIEW (REVIEW_NO,RVW_TITLE,RVW_WRITE_DAY,RVW_HITS,RVW_CONTENT,RVW_DEL_CHECK,RVW_SATISFACTION,PRODUCT_NO,BOARD_ID,MEM_ID) values (18,'또 샀어요',to_date('16/04/19','RR/MM/DD'),0,'자꾸 중독되는 붉나무~',0,5,10001,5,'soomin');
REM INSERTING into NMDB.TB_REVIEW_RE
SET DEFINE OFF;
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (1,'구매해주셔서 고맙습니다~^^ 더 좋은 제품으로 보답하는 자연맘이 되겠습니다.',to_date('16/04/17','RR/MM/DD'),0,1,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (2,'구매해주셔서 고맙습니다~^^ 더 좋은 제품으로 보답하는 자연맘이 되겠습니다.',to_date('16/04/17','RR/MM/DD'),0,2,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (3,'구매해주셔서 고맙습니다~^^ 더 좋은 제품으로 보답하는 자연맘이 되겠습니다.',to_date('16/04/17','RR/MM/DD'),0,3,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (4,'저도 고맙네요',to_date('16/04/17','RR/MM/DD'),0,3,'soomin');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (5,'구매해주셔서 고맙습니다~^^ 더 좋은 제품으로 보답하는 자연맘이 되겠습니다.',to_date('16/04/17','RR/MM/DD'),0,4,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (6,'구매해주셔서 고맙습니다~^^ 더 좋은 제품으로 보답하는 자연맘이 되겠습니다.',to_date('16/04/17','RR/MM/DD'),0,5,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (7,'구매해주셔서 고맙습니다~^^ 더 좋은 제품으로 보답하는 자연맘이 되겠습니다.',to_date('16/04/17','RR/MM/DD'),0,6,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (8,'구매해주셔서 고맙습니다~^^ 더 좋은 제품으로 보답하는 자연맘이 되겠습니다.',to_date('16/04/17','RR/MM/DD'),0,7,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (9,'내 동생은 안돼가됨',to_date('16/04/17','RR/MM/DD'),0,7,'soojin');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (29,'뽕잎비누의 냄새는 뽕잎의 천연 냄새 그대로이므로 안심하고 사용하셔도 된답니다 ^^
항상 저희 자연맘을 이용해주셔서 고맙습니다^^',to_date('16/04/21','RR/MM/DD'),0,19,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (30,'항상 저희 자연맘을 이용해주셔서 고맙습니다 ^^ 어머님과 함께 꿀피부 되시길 기원하겠습니다!',to_date('16/04/21','RR/MM/DD'),0,20,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (31,'기름종이를 아끼실 수 있게 되어서 다행입니다 ^^ 항상 저희 자연맘을 이용해주셔서 고맙습니다 ^^~',to_date('16/04/21','RR/MM/DD'),0,21,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (10,'등록 테스트 등록 테슷트',to_date('16/04/17','RR/MM/DD'),1,1,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (12,'말해말해 내게 말해줘야해',to_date('16/04/17','RR/MM/DD'),1,2,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (14,'오ㅐ 등록되는거야ㅠㅠ',to_date('16/04/17','RR/MM/DD'),0,1,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (15,'어이없지 내 오류가 오타 때문이었다니',to_date('16/04/17','RR/MM/DD'),0,4,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (16,'암어 본 헤이러',to_date('16/04/17','RR/MM/DD'),1,4,'admin02');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (19,'그만드세요 고객님 체해요ㅠㅠㅠ',to_date('16/04/19','RR/MM/DD'),0,12,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (20,'아마씨 비누는 먹는게 아니랍니다 고갱님 ^^!',to_date('16/04/19','RR/MM/DD'),0,13,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (21,'아마씨 비누는 먹지 마시고 피부에 양보하세요~',to_date('16/04/19','RR/MM/DD'),0,14,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (22,'팝업창 화이팅이예요 고객님!!',to_date('16/04/19','RR/MM/DD'),1,15,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (23,'항상 저희 자연맘을 이용해주셔서 고맙습니다~ ^^',to_date('16/04/19','RR/MM/DD'),0,16,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (24,'붉나무 비누 쓰시고 예쁘고 깨끗한 피부 얻으시길 바랍니다~ ^^',to_date('16/04/19','RR/MM/DD'),0,18,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (25,'체한 적은 없는데 토한 적은 있어요',to_date('16/04/19','RR/MM/DD'),0,12,'soomin');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (26,'ㅎㅎㅎ',to_date('16/04/19','RR/MM/DD'),1,12,'soomin');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (27,'항상 저희 제품을 이용해주셔서 고맙습니다 ^^',to_date('16/04/19','RR/MM/DD'),0,15,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (28,'항상 저희 비누를 이용해주셔서 고맙습니다 ^^',to_date('16/04/19','RR/MM/DD'),1,19,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (32,'항상 저희 제품을 이용해주셔서 고맙습니다 고객님 트러블 피부에는 강황비누를 추천드려요 ^^',to_date('16/04/22','RR/MM/DD'),0,22,'admin01');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (17,'로즈마리 비누 몰래 사셨나봐요 ^^',to_date('16/04/17','RR/MM/DD'),0,5,'admin02');
Insert into NMDB.TB_REVIEW_RE (REVIEW_RE_NO,RVW_RE_CONTENT,RVW_RE_WRITE_DAY,RVW_RE_DEL_CHECK,RVW_NO,MEM_ID) values (18,'헉 먹지마세요!',to_date('16/04/19','RR/MM/DD'),0,11,'admin01');
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP63
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP63" ON "NMDB"."TB_NOTICE" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP33
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP33" ON "NMDB"."TB_EVENT" ("BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY16
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY16" ON "NMDB"."TB_NOTICE" ("NOTICE_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY21
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY21" ON "NMDB"."TB_MEM_LEVEL_N_BOARD" ("MEM_LEVEL_CD", "BOARD_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP51
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP51" ON "NMDB"."TB_ORDER" ("CREDIT_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY5
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY5" ON "NMDB"."TB_CREDIT" ("CREDIT_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP27
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP27" ON "NMDB"."TB_REVIEW" ("PRODUCT_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY18
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY18" ON "NMDB"."TB_REVIEW" ("REVIEW_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP37
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP37" ON "NMDB"."TB_EVENT_RE" ("EVT_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP60
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP60" ON "NMDB"."TB_REVIEW" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY4
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY4" ON "NMDB"."TB_PROCESS" ("PROCESS_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY3
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY3" ON "NMDB"."TB_CATEGORY" ("CATEGORY_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP32
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP32" ON "NMDB"."TB_QNA" ("BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP41
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP41" ON "NMDB"."TB_NOTICE_RE" ("NOTICE_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY6
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY6" ON "NMDB"."TB_DELIVERY_COM" ("DELIVERY_COM_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY11
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY11" ON "NMDB"."TB_PRODUCT_N_ORDER" ("PRODUCT_NO", "ORDER_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY24
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY24" ON "NMDB"."TB_NOTICE_RE" ("NOTICE_RE_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP56
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP56" ON "NMDB"."TB_ORDER" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY14
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY14" ON "NMDB"."TB_BOARD" ("BOARD_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP59
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP59" ON "NMDB"."TB_EVENT" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP66
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP66" ON "NMDB"."TB_QNA" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP50
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP50" ON "NMDB"."TB_PRODUCT_N_ORDER" ("PROCESS_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP58
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP58" ON "NMDB"."TB_EVENT_RE" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP49
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP49" ON "NMDB"."TB_PRODUCT" ("CATEGORY_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP31
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP31" ON "NMDB"."TB_REVIEW" ("BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP39
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP39" ON "NMDB"."TB_QNA_RE" ("QNA_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY13
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY13" ON "NMDB"."TB_INTEREST" ("PRODUCT_NO", "MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY12
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY12" ON "NMDB"."TB_CART" ("PRODUCT_NO", "MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP62
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP62" ON "NMDB"."TB_MEMBER" ("MEM_LEVEL_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP34
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP34" ON "NMDB"."TB_FAQ" ("BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP57
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP57" ON "NMDB"."TB_REVIEW_RE" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY15
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY15" ON "NMDB"."TB_FAQ" ("FAQ_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP53
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP53" ON "NMDB"."TB_ORDER" ("DELIVERY_COM_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY22
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY22" ON "NMDB"."TB_EVENT_RE" ("EVENT_RE_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP65
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP65" ON "NMDB"."TB_QNA_RE" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY25
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY25" ON "NMDB"."TB_REVIEW_RE" ("REVIEW_RE_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY23
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY23" ON "NMDB"."TB_QNA_RE" ("QNA_RE_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP61
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP61" ON "NMDB"."TB_FAQ" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY19
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY19" ON "NMDB"."TB_QNA" ("QNA_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY20
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY20" ON "NMDB"."TB_MEM_LEVEL" ("MEM_LEVEL_CD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP64
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP64" ON "NMDB"."TB_NOTICE_RE" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY8
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY8" ON "NMDB"."TB_ORDER" ("ORDER_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP35
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP35" ON "NMDB"."TB_NOTICE" ("BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY1
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY1" ON "NMDB"."TB_MEMBER" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY17
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY17" ON "NMDB"."TB_EVENT" ("EVENT_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KEY7
--------------------------------------------------------

  CREATE UNIQUE INDEX "NMDB"."KEY7" ON "NMDB"."TB_PRODUCT" ("PRODUCT_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP24
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP24" ON "NMDB"."TB_QNA" ("QNA_REF") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IX_RELATIONSHIP43
--------------------------------------------------------

  CREATE INDEX "NMDB"."IX_RELATIONSHIP43" ON "NMDB"."TB_REVIEW_RE" ("RVW_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table TB_EVENT_RE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_EVENT_RE" ADD CONSTRAINT "KEY22" PRIMARY KEY ("EVENT_RE_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_EVENT_RE" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT_RE" MODIFY ("EVT_NO" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT_RE" MODIFY ("EVT_RE_DEL_CHECK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT_RE" MODIFY ("EVT_RE_WRITE_DAY" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT_RE" MODIFY ("EVT_RE_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT_RE" MODIFY ("EVENT_RE_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_DELIVERY_COM
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_DELIVERY_COM" ADD CONSTRAINT "KEY6" PRIMARY KEY ("DELIVERY_COM_CD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_DELIVERY_COM" MODIFY ("DELIVERY_COM_NM" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_DELIVERY_COM" MODIFY ("DELIVERY_COM_CD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_MEM_LEVEL
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_MEM_LEVEL" ADD CONSTRAINT "KEY20" PRIMARY KEY ("MEM_LEVEL_CD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_MEM_LEVEL" MODIFY ("MEM_LEVEL_NM" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEM_LEVEL" MODIFY ("MEM_LEVEL_CD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_REVIEW_RE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_REVIEW_RE" ADD CONSTRAINT "KEY25" PRIMARY KEY ("REVIEW_RE_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_REVIEW_RE" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW_RE" MODIFY ("RVW_NO" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW_RE" MODIFY ("RVW_RE_DEL_CHECK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW_RE" MODIFY ("RVW_RE_WRITE_DAY" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW_RE" MODIFY ("RVW_RE_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW_RE" MODIFY ("REVIEW_RE_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_NOTICE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_NOTICE" ADD CONSTRAINT "KEY16" PRIMARY KEY ("NOTICE_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_NOTICE" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE" MODIFY ("BOARD_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE" MODIFY ("NTC_DEL_CHECK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE" MODIFY ("NTC_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE" MODIFY ("NTC_HITS" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE" MODIFY ("NTC_WRITE_DAY" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE" MODIFY ("NTC_TITLE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE" MODIFY ("NOTICE_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_FAQ
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_FAQ" ADD CONSTRAINT "KEY15" PRIMARY KEY ("FAQ_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_FAQ" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_FAQ" MODIFY ("BOARD_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_FAQ" MODIFY ("FAQ_DEL_CHECK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_FAQ" MODIFY ("FAQ_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_FAQ" MODIFY ("FAQ_TITLE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_FAQ" MODIFY ("FAQ_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_BOARD
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_BOARD" ADD CONSTRAINT "KEY14" PRIMARY KEY ("BOARD_CD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_BOARD" MODIFY ("BOARD_NM" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_BOARD" MODIFY ("BOARD_CD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_MEMBER
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_MEMBER" ADD CONSTRAINT "KEY1" PRIMARY KEY ("MEM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_LEVEL_CD" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("DROP_OUT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_GENDER" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_BIRTH" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_EMAIL" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_ADDR_DETAIL" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_ADDR_POST" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_PHONE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_NAME" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_PW" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEMBER" MODIFY ("MEM_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_ORDER
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_ORDER" ADD CONSTRAINT "KEY8" PRIMARY KEY ("ORDER_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("CREDIT_CD" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("RCV_ADDR_DETAIL" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("RCV_ADDR_POST" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("RCV_PHONE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("RCV_NAME" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("CREDIT_EXP" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("CREDIT_NUM" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("CHARGE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("ORDER_DATE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_ORDER" MODIFY ("ORDER_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_CART
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_CART" ADD CONSTRAINT "KEY12" PRIMARY KEY ("PRODUCT_NO", "MEM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_CART" MODIFY ("BUY_NUM" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_CART" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_CART" MODIFY ("PRODUCT_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_CATEGORY
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_CATEGORY" ADD CONSTRAINT "KEY3" PRIMARY KEY ("CATEGORY_CD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_CATEGORY" MODIFY ("CATEGORY_NM" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_CATEGORY" MODIFY ("CATEGORY_CD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_QNA
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_QNA" ADD CONSTRAINT "KEY19" PRIMARY KEY ("QNA_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("BOARD_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("QNA_REF" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("QNA_POS" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("QNA_DEL_CHECK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("QNA_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("QNA_HITS" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("QNA_WRITE_DAY" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("QNA_TITLE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA" MODIFY ("QNA_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_PROCESS
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_PROCESS" ADD CONSTRAINT "KEY4" PRIMARY KEY ("PROCESS_CD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_PROCESS" MODIFY ("PROCESS_NM" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PROCESS" MODIFY ("PROCESS_CD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_EVENT
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_EVENT" ADD CONSTRAINT "KEY17" PRIMARY KEY ("EVENT_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_EVENT" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT" MODIFY ("BOARD_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT" MODIFY ("EVT_DEL_CHECK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT" MODIFY ("EVT_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT" MODIFY ("EVT_HITS" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT" MODIFY ("EVT_WRITE_DAY" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT" MODIFY ("EVT_TITLE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_EVENT" MODIFY ("EVENT_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_PRODUCT
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("REPRESENT_IMG" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("SALE_STATE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("DISPLAY_STATE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("STOCK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("COST_PRICE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("SELLING_PRICE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("PRODUCT_NAME" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("PRODUCT_NO" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" ADD CONSTRAINT "KEY7" PRIMARY KEY ("PRODUCT_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("CATEGORY_CD" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("DELETED_STATE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("SUMMARY_EX" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT" MODIFY ("DETAIL_IMG" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_NOTICE_RE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_NOTICE_RE" ADD CONSTRAINT "KEY24" PRIMARY KEY ("NOTICE_RE_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_NOTICE_RE" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE_RE" MODIFY ("NOTICE_NO" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE_RE" MODIFY ("NTC_RE_DEL_CHECK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE_RE" MODIFY ("NTC_RE_WRITE_DAY" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE_RE" MODIFY ("NTC_RE_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_NOTICE_RE" MODIFY ("NOTICE_RE_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_PRODUCT_N_ORDER
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_PRODUCT_N_ORDER" ADD CONSTRAINT "KEY11" PRIMARY KEY ("PRODUCT_NO", "ORDER_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_PRODUCT_N_ORDER" MODIFY ("PROCESS_CD" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT_N_ORDER" MODIFY ("BUY_NUM" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT_N_ORDER" MODIFY ("ORDER_NO" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_PRODUCT_N_ORDER" MODIFY ("PRODUCT_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_CREDIT
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_CREDIT" ADD CONSTRAINT "KEY5" PRIMARY KEY ("CREDIT_CD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_CREDIT" MODIFY ("CREDIT_NM" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_CREDIT" MODIFY ("CREDIT_CD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_REVIEW
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_REVIEW" ADD CONSTRAINT "KEY18" PRIMARY KEY ("REVIEW_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("BOARD_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("PRODUCT_NO" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("RVW_SATISFACTION" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("RVW_DEL_CHECK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("RVW_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("RVW_HITS" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("RVW_WRITE_DAY" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("RVW_TITLE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_REVIEW" MODIFY ("REVIEW_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_INTEREST
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_INTEREST" ADD CONSTRAINT "KEY13" PRIMARY KEY ("PRODUCT_NO", "MEM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_INTEREST" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_INTEREST" MODIFY ("PRODUCT_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_QNA_RE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_QNA_RE" ADD CONSTRAINT "KEY23" PRIMARY KEY ("QNA_RE_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_QNA_RE" MODIFY ("MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA_RE" MODIFY ("QNA_NO" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA_RE" MODIFY ("QNA_RE_DEL_CHECK" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA_RE" MODIFY ("QNA_RE_WRITE_DAY" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA_RE" MODIFY ("QNA_RE_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_QNA_RE" MODIFY ("QNA_RE_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TB_MEM_LEVEL_N_BOARD
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" ADD CONSTRAINT "KEY21" PRIMARY KEY ("MEM_LEVEL_CD", "BOARD_CD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" MODIFY ("BOARD_DELETE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" MODIFY ("BOARD_MODIFY" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" MODIFY ("BOARD_WRITE" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" MODIFY ("BOARD_READ" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" MODIFY ("BOARD_CD" NOT NULL ENABLE);
  ALTER TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" MODIFY ("MEM_LEVEL_CD" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table TB_CART
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_CART" ADD CONSTRAINT "RELATIONSHIP14" FOREIGN KEY ("PRODUCT_NO")
	  REFERENCES "NMDB"."TB_PRODUCT" ("PRODUCT_NO") ENABLE;
  ALTER TABLE "NMDB"."TB_CART" ADD CONSTRAINT "RELATIONSHIP70" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_EVENT
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_EVENT" ADD CONSTRAINT "RELATIONSHIP33" FOREIGN KEY ("BOARD_ID")
	  REFERENCES "NMDB"."TB_BOARD" ("BOARD_CD") ENABLE;
  ALTER TABLE "NMDB"."TB_EVENT" ADD CONSTRAINT "RELATIONSHIP59" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_EVENT_RE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_EVENT_RE" ADD CONSTRAINT "RELATIONSHIP37" FOREIGN KEY ("EVT_NO")
	  REFERENCES "NMDB"."TB_EVENT" ("EVENT_NO") ENABLE;
  ALTER TABLE "NMDB"."TB_EVENT_RE" ADD CONSTRAINT "RELATIONSHIP58" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_FAQ
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_FAQ" ADD CONSTRAINT "RELATIONSHIP34" FOREIGN KEY ("BOARD_ID")
	  REFERENCES "NMDB"."TB_BOARD" ("BOARD_CD") ENABLE;
  ALTER TABLE "NMDB"."TB_FAQ" ADD CONSTRAINT "RELATIONSHIP61" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_INTEREST
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_INTEREST" ADD CONSTRAINT "RELATIONSHIP12" FOREIGN KEY ("PRODUCT_NO")
	  REFERENCES "NMDB"."TB_PRODUCT" ("PRODUCT_NO") ENABLE;
  ALTER TABLE "NMDB"."TB_INTEREST" ADD CONSTRAINT "RELATIONSHIP69" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_MEMBER
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_MEMBER" ADD CONSTRAINT "RELATIONSHIP62" FOREIGN KEY ("MEM_LEVEL_CD")
	  REFERENCES "NMDB"."TB_MEM_LEVEL" ("MEM_LEVEL_CD") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_MEM_LEVEL_N_BOARD
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" ADD CONSTRAINT "RELATIONSHIP67" FOREIGN KEY ("MEM_LEVEL_CD")
	  REFERENCES "NMDB"."TB_MEM_LEVEL" ("MEM_LEVEL_CD") ENABLE;
  ALTER TABLE "NMDB"."TB_MEM_LEVEL_N_BOARD" ADD CONSTRAINT "RELATIONSHIP68" FOREIGN KEY ("BOARD_CD")
	  REFERENCES "NMDB"."TB_BOARD" ("BOARD_CD") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_NOTICE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_NOTICE" ADD CONSTRAINT "RELATIONSHIP35" FOREIGN KEY ("BOARD_ID")
	  REFERENCES "NMDB"."TB_BOARD" ("BOARD_CD") ENABLE;
  ALTER TABLE "NMDB"."TB_NOTICE" ADD CONSTRAINT "RELATIONSHIP63" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_NOTICE_RE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_NOTICE_RE" ADD CONSTRAINT "RELATIONSHIP41" FOREIGN KEY ("NOTICE_NO")
	  REFERENCES "NMDB"."TB_NOTICE" ("NOTICE_NO") ENABLE;
  ALTER TABLE "NMDB"."TB_NOTICE_RE" ADD CONSTRAINT "RELATIONSHIP64" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_ORDER
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_ORDER" ADD CONSTRAINT "RELATIONSHIP51" FOREIGN KEY ("CREDIT_CD")
	  REFERENCES "NMDB"."TB_CREDIT" ("CREDIT_CD") ENABLE;
  ALTER TABLE "NMDB"."TB_ORDER" ADD CONSTRAINT "RELATIONSHIP53" FOREIGN KEY ("DELIVERY_COM_CD")
	  REFERENCES "NMDB"."TB_DELIVERY_COM" ("DELIVERY_COM_CD") ENABLE;
  ALTER TABLE "NMDB"."TB_ORDER" ADD CONSTRAINT "RELATIONSHIP56" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_PRODUCT
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_PRODUCT" ADD CONSTRAINT "RELATIONSHIP49" FOREIGN KEY ("CATEGORY_CD")
	  REFERENCES "NMDB"."TB_CATEGORY" ("CATEGORY_CD") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_PRODUCT_N_ORDER
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_PRODUCT_N_ORDER" ADD CONSTRAINT "RELATIONSHIP10" FOREIGN KEY ("ORDER_NO")
	  REFERENCES "NMDB"."TB_ORDER" ("ORDER_NO") ENABLE;
  ALTER TABLE "NMDB"."TB_PRODUCT_N_ORDER" ADD CONSTRAINT "RELATIONSHIP50" FOREIGN KEY ("PROCESS_CD")
	  REFERENCES "NMDB"."TB_PROCESS" ("PROCESS_CD") ENABLE;
  ALTER TABLE "NMDB"."TB_PRODUCT_N_ORDER" ADD CONSTRAINT "RELATIONSHIP9" FOREIGN KEY ("PRODUCT_NO")
	  REFERENCES "NMDB"."TB_PRODUCT" ("PRODUCT_NO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_QNA
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_QNA" ADD CONSTRAINT "RELATIONSHIP24" FOREIGN KEY ("QNA_REF")
	  REFERENCES "NMDB"."TB_QNA" ("QNA_NO") ENABLE;
  ALTER TABLE "NMDB"."TB_QNA" ADD CONSTRAINT "RELATIONSHIP32" FOREIGN KEY ("BOARD_ID")
	  REFERENCES "NMDB"."TB_BOARD" ("BOARD_CD") ENABLE;
  ALTER TABLE "NMDB"."TB_QNA" ADD CONSTRAINT "RELATIONSHIP66" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_QNA_RE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_QNA_RE" ADD CONSTRAINT "RELATIONSHIP39" FOREIGN KEY ("QNA_NO")
	  REFERENCES "NMDB"."TB_QNA" ("QNA_NO") ENABLE;
  ALTER TABLE "NMDB"."TB_QNA_RE" ADD CONSTRAINT "RELATIONSHIP65" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_REVIEW
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_REVIEW" ADD CONSTRAINT "RELATIONSHIP27" FOREIGN KEY ("PRODUCT_NO")
	  REFERENCES "NMDB"."TB_PRODUCT" ("PRODUCT_NO") ENABLE;
  ALTER TABLE "NMDB"."TB_REVIEW" ADD CONSTRAINT "RELATIONSHIP31" FOREIGN KEY ("BOARD_ID")
	  REFERENCES "NMDB"."TB_BOARD" ("BOARD_CD") ENABLE;
  ALTER TABLE "NMDB"."TB_REVIEW" ADD CONSTRAINT "RELATIONSHIP60" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_REVIEW_RE
--------------------------------------------------------

  ALTER TABLE "NMDB"."TB_REVIEW_RE" ADD CONSTRAINT "RELATIONSHIP43" FOREIGN KEY ("RVW_NO")
	  REFERENCES "NMDB"."TB_REVIEW" ("REVIEW_NO") ENABLE;
  ALTER TABLE "NMDB"."TB_REVIEW_RE" ADD CONSTRAINT "RELATIONSHIP57" FOREIGN KEY ("MEM_ID")
	  REFERENCES "NMDB"."TB_MEMBER" ("MEM_ID") ENABLE;
