drop view "NMDB"."V_PRODUCT_DELETED";
drop view "NMDB"."V_PRODUCT_MANAGE";
drop view "NMDB"."V_RANK_SELLS";
drop view "NMDB"."V_REVIEW_ADMIN";
drop view "NMDB"."V_REVIEW_FRONT";


-- 삭제된 상품 관리
  CREATE OR REPLACE FORCE VIEW "NMDB"."V_PRODUCT_DELETED" ("PRODUCT_NO", "CATEGORY_NM", "PRODUCT_NAME", "REPRESENT_IMG", "SELLING_PRICE", "COST_PRICE", "STOCK", "ALL_SELLS") AS 
  SELECT p.product_no, c.category_nm, p.product_name, p.represent_img, p.selling_price,
p.cost_price, p.stock, 
NVL((SELECT SUM(o.buy_num) FROM tb_product_n_order o WHERE o.product_no = 
p.product_no AND o.process_cd = 21
GROUP BY o.product_no), 0) AS all_sells
FROM tb_product p, tb_category c
WHERE p.category_cd = c.category_cd AND p.deleted_state = 1;



-- 상품 관리
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



-- 판매순 랭킹
  CREATE OR REPLACE FORCE VIEW "NMDB"."V_RANK_SELLS" ("ALL_SELLS", "PRODUCT_NAME") AS 
  SELECT NVL((SELECT SUM(o.buy_num) FROM tb_product_n_order o WHERE o.product_no = 
p.product_no AND o.process_cd = 21
GROUP BY o.product_no), 0) AS all_sells, p.product_name
FROM tb_product p
WHERE p.deleted_state = 0
ORDER BY all_sells DESC, product_name;



-- 관리자모드 상품 후기 게시판
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



-- 사용자 모드 상품 후기 게시판
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