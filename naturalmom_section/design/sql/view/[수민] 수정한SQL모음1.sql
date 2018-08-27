
-- 잘못된 글 삭제번호 수정 (글이 삭제시 답변도 삭제됨)
UPDATE TB_QNA SET QNA_DEL_CHECK=1 WHERE qna_no=8;
UPDATE TB_QNA SET QNA_POS = 2, QNA_REF = 4 WHERE qna_no=6;
UPDATE TB_QNA SET QNA_POS = 2, QNA_REF = 1 WHERE qna_no=8;

-- qna 뷰 만듦
CREATE OR REPLACE VIEW v_qna_qnare
AS
SELECT q.qna_no, qna_title, qna_write_day, qna_hits, qna_content, qna_pw, qna_pos, qna_ref, q.mem_id, 
NVL((SELECT COUNT(qna_re_no) FROM tb_qna_re r WHERE r.qna_no=q.qna_no AND r.qna_re_del_check=0), 0) as qna_re_count 
FROM tb_qna q LEFT OUTER JOIN tb_qna_re r
ON (q.qna_no = r.qna_no)
WHERE qna_del_check=0
GROUP BY q.qna_no, qna_title, qna_write_day, qna_hits, qna_content, qna_pw, qna_pos, qna_ref, q.mem_id
ORDER BY qna_ref ASC, qna_pos DESC;

DROP VIEW V_INTEREST;
DROP VIEW V_CART;

CREATE VIEW V_INTEREST_PRODUCT
AS
SELECT i.product_no, product_name, selling_price, sale_state, represent_img, i.mem_id
FROM tb_product p JOIN tb_interest i
ON (p.product_no = i.product_no);

CREATE View V_CART_PRODUCT
AS
SELECT c.product_no, product_name, selling_price, sale_state, represent_img, c.buy_num, c.mem_id
FROM tb_product p JOIN tb_cart c 
ON (p.product_no=c.product_no);