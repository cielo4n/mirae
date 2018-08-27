CREATE OR REPLACE View V_CART_PRODUCT
AS
SELECT c.product_no, product_name, selling_price, sale_state, represent_img, stock, c.buy_num, c.mem_id
FROM tb_product p JOIN tb_cart c 
ON (p.product_no=c.product_no);

CREATE OR REPLACE VIEW V_INTEREST_PRODUCT
AS
SELECT i.product_no, product_name, selling_price, sale_state, represent_img, stock, i.mem_id
FROM tb_product p JOIN tb_interest i
ON (p.product_no = i.product_no);