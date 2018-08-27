# 천연비누 쇼핑몰

## 구조
- 환경 : java 1.7, jsp, spring mvc, oracle 11g, tomcat 7.x
- 소스 패키지 구조 : 

	com.nmom.soap
				.controller
				.data
					.dao
					.impl
					.model
				.svc

- 페이지 템플릿 구조 : 

	views/
		admin/
		board/
		company
		join/
		login/
		mypage/
		order/
		product/
		_default_footer.jsp
		_default_header.jsp
		_default_menu.jsp
	
	
- context path => 'soap'
- URL 구분자 : '*.nm'

_____________________________________________________________


## URL 스키마 + 주요기능
`아래 나오는 것들은 context path 하위의 URL을 의마한다.`


* 상품

	- 전체 비누 보기
	/index.nm
	
	- 카테고리별 목록보기	
	/product/list.nm?cate=xx
	
	- 상품 상세보기
	/product/detail.nm?pdno=xx
	
	- 검색상품 목록보기
	/product/search.nm?keyword=xx

* 장바구니

	- 장바구니 보기
	/cart.nm
	
	- 장바구니 상품 추가
	/cart/add_proc.nm
	
	- 장바구니 상품 개수 수정
	/cart/edit_proc.nm
	
	- 장바구니 상품 삭제
	/cart/del_proc.nm

	- 장바구니 -> 관심상품 
	/cart/to_interest 장바구니에서 삭제
	/interest/from_cart 관심상품에 등록
	
	- 관심상품 -> 장바구니
	/interest/to_cart 관심상품에서 삭제
	/cart/from_interest 장바구니에 등록
	
* 관심상품
	
	- 관심상품 보기
	/interest.nm
	
	- 관심상품 추가
	/interest/add_proc.nm
	
	- 관심상품 삭제
	/interest/del_proc.nm
	

* 자주하는 질문 (FAQ)

	/board/faq
	
	- 글 리스트(페이지네이션)
	/board/faq/list.nm
	/board/faq/pp/list.nm
	
	- 글보기
	/board/faq/read.nm
	- 글 검색
	/board/faq/search.nm

	--------------------------------
		
	- 글쓰기
	/board/faq/add_form.nm
	/board/faq/add_proc.nm
	
	- 글 편집
	/board/faq/edit_form.nm
	/board/faq/edit_proc.nm
	
	- 글 삭제
	/board/faq/del_proc.nm
	
	
* 질문과 답변 (QNA)

	/board/qna
	
	- 글 리스트(페이지네이션)
	/board/qna/list.nm
	/board/qna/pp/list.nm
	
	- 글보기
	/board/qna/read.nm

	- 글 검색
	/board/qna/search.nm

	- 비밀글확인
	/board/qna/secret.nm

	----------------------------	
	
	- 글쓰기
	/board/qna/add_form.nm
	/board/qna/add_proc.nm
	
	- 글 편집
	/board/qna/edit_form.nm
	/board/qna/edit_proc.nm
	
	- 글 삭제
	/board/qna/del_proc.nm
		
	- 답변 등록
	/board/qna/add_answer.nm
		
	- 댓글 등록
	/board/qna/read/add_reply_proc.nm
	
	- 댓글 삭제
	/board/qna/read/del_reply_proc.nm

