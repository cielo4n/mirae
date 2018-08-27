DROP VIEW v_order_list;

DROP VIEW v_order_manager;

DROP VIEW v_notice;

DROP VIEW v_orderer;

--<<주문-회원>>--
---주문조회(뷰 생성)
CREATE OR REPLACE VIEW v_order_list AS SELECT o.order_no, o.order_date, p.represent_img, p.product_name, 
po.buy_num, o.charge, pr.process_nm, m.mem_id
FROM tb_order o, tb_member m, tb_product p, tb_product_n_order po, tb_process pr
WHERE o.order_no = po.order_no AND o.mem_id = m.mem_id AND p.product_no = po.product_no 
AND pr.process_cd = po.process_cd;

--<<주문-관리자>>--
---주문관리(뷰 생성)
CREATE OR REPLACE VIEW v_order_manager AS SELECT o.order_date, o.order_no, m.mem_name, p.product_name, 
po.buy_num, o.charge, o.delivery_msg, o.tracking_num, pr.process_nm
FROM tb_order o, tb_member m, tb_product p, tb_product_n_order po, tb_process pr
WHERE o.order_no = po.order_no AND o.mem_id = m.mem_id AND p.product_no = po.product_no 
AND pr.process_cd = po.process_cd;


--공지사항 뷰
CREATE OR REPLACE VIEW v_notice AS
SELECT n.notice_no,  ntc_title, 
NVL((SELECT COUNT(notice_re_no) FROM tb_notice_re r WHERE r.notice_no=n.notice_no AND r.ntc_re_del_check=0), 0) AS ntc_re_no, 
ntc_content, ntc_write_day, ntc_hits, n.mem_id
FROM tb_notice n LEFT OUTER JOIN tb_notice_re r
ON (n.notice_no = r.notice_no)
WHERE ntc_del_check=0
GROUP BY n.notice_no,  ntc_title,  ntc_write_day, ntc_content, ntc_hits,  n.mem_id
ORDER BY notice_no DESC;

--주문자 정보
CREATE OR REPLACE VIEW v_orderer AS
SELECT m.mem_id as id, m.mem_name as name, m.mem_phone as phone, m.mem_email as email, m.mem_addr_post as addr_post, m.mem_addr_detail 
as addr_detail FROM tb_member m;


-- 추가된 sql문
ALTER TABLE NMDB.tb_order MODIFY DELIVERY_COM_CD NULL;
UPDATE "NMDB"."TB_PROCESS" SET PROCESS_NM = '환불요청 ' WHERE process_cd = 31;