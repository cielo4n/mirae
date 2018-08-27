CREATE OR REPLACE VIEW "NMDB"."V_CART_PRODUCT" ("PRODUCT_NO", "PRODUCT_NAME", "SELLING_PRICE", "SALE_STATE", "REPRESENT_IMG", "STOCK", "BUY_NUM", "MEM_ID") AS 
SELECT c.product_no, product_name, selling_price, sale_state, represent_img, stock, c.buy_num, c.mem_id
FROM tb_product p JOIN tb_cart c 
ON (p.product_no=c.product_no) WHERE p.DISPLAY_STATE=1 AND p.DELETED_STATE=0;

CREATE OR REPLACE VIEW "NMDB"."V_INTEREST_PRODUCT" ("PRODUCT_NO", "PRODUCT_NAME", "SELLING_PRICE", "SALE_STATE", "REPRESENT_IMG", "STOCK", "MEM_ID") AS 
SELECT i.product_no, product_name, selling_price, sale_state, represent_img, stock, i.mem_id
FROM tb_product p JOIN tb_interest i
ON (p.product_no = i.product_no) WHERE p.DISPLAY_STATE=1 AND p.DELETED_STATE=0;

