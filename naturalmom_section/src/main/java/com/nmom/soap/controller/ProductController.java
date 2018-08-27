package com.nmom.soap.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nmom.soap.S;
import com.nmom.soap.data.model.board.review.Review_ReVo;
import com.nmom.soap.data.model.board.review.VReview_FrontVo;
import com.nmom.soap.data.model.category.CategoryVo;
import com.nmom.soap.data.model.product.ProductVo;
import com.nmom.soap.data.model.product.VProduct_DeletedVo;
import com.nmom.soap.data.model.product.VProduct_ManageVo;
import com.nmom.soap.svc.board.review.IReviewSvc;
import com.nmom.soap.svc.board.review.IReview_ReSvc;
import com.nmom.soap.svc.board.review.IVReview_FrontSvc;
import com.nmom.soap.svc.category.ICategorySvc;
import com.nmom.soap.svc.product.IProductSvc;
import com.nmom.soap.svc.product.IVProduct_DeletedSvc;
import com.nmom.soap.svc.product.IVProduct_ManageSvc;

@Controller
public class ProductController 
{
   IProductSvc productSvc;
   IVProduct_DeletedSvc product_deletedSvc;
   IVProduct_ManageSvc product_manageSvc;
   ICategorySvc categorySvc;
   IReviewSvc reviewSvc;
   IReview_ReSvc review_reSvc;
   IVReview_FrontSvc review_frontSvc;
   
   public void setProductSvc(IProductSvc productSvc) 
   {
      this.productSvc = productSvc;
   }
   
   public void setProduct_deletedSvc(IVProduct_DeletedSvc product_deletedSvc) 
   {
      this.product_deletedSvc = product_deletedSvc;
   }
   
   public void setProduct_manageSvc(IVProduct_ManageSvc product_manageSvc) 
   {
      this.product_manageSvc = product_manageSvc;
   }

   public void setCategorySvc(ICategorySvc categorySvc) {
      this.categorySvc = categorySvc;
   }
   
   public void setReviewSvc(IReviewSvc reviewSvc)
   {
      this.reviewSvc = reviewSvc;
   }
   
   public void setReview_reSvc(IReview_ReSvc review_reSvc) 
   {
      this.review_reSvc = review_reSvc;
   }
   
   public void setReview_frontSvc(IVReview_FrontSvc review_frontSvc) 
   {
      this.review_frontSvc = review_frontSvc;
   }
   
   // 상품관리 페이지
   @RequestMapping(value ="/admin/product.nm", method=RequestMethod.GET)
   public ModelAndView product_manageList(HttpServletRequest request, HttpSession session)
   {      
      // 세션에서 아이디와 관리자인지 여부를 얻어옴
      Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
      Map<String, Object> map = new HashMap<String, Object>();
      
      if (isAdmin!= null && isAdmin.booleanValue())
      {      
         List<VProduct_ManageVo> list = product_manageSvc.getAllProduct_by_product_no(S.ASC);
         map.put("p_list", list);
         return new ModelAndView("admin/product/a_product", map);
      }
      else
      {
    	  map.put("err_msg", "관리자로 로그인 바랍니다.");
    	  return new ModelAndView("login/login", map);
      }
   }
   
   
   // 삭제된 상품관리
   @RequestMapping(value="/admin/product.nm", method=RequestMethod.GET, params="page=deleted")
   public ModelAndView product_deletedList(HttpServletRequest request, HttpSession session)
   {
      // 세션에서 아이디와 관리자인지 여부를 얻어옴
      Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
      Map<String, Object> map = new HashMap<String, Object>();
      
      if (isAdmin!= null && isAdmin.booleanValue())
      {
         List<VProduct_DeletedVo> list = product_deletedSvc.getAllDeletedProduct_by_product_no(S.ASC);  
         map.put("p_list", list);
         return new ModelAndView("admin/product/a_product", map);
      }
      else
      {
    	  map.put("err_msg", "관리자로 로그인 바랍니다.");
    	  return new ModelAndView("login/login", map);
      }
   }
   
   // 상품관리 & 상품삭제 페이지에서 상태 변경
   @RequestMapping(value ="/admin/product.nm", method=RequestMethod.GET, params="page=process")
   public ModelAndView product_changeState(HttpServletRequest request, HttpSession session,
         @RequestParam(value="item", required=false) String item, @RequestParam(value="order", required=false) int order,
         @RequestParam(value="no", required=false) int[] no)
   {
      // 세션에서 아이디와 관리자인지 여부를 얻어옴
      Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
      
      if (isAdmin!= null && isAdmin.booleanValue())
      {
         for (int i = 0; i < no.length; i++)
         {
            if (item.equals("dis"))
            {
               int r = productSvc.editDisplayState(no[i], order);
               if(r == S.PROCESS_ERROR)
               {
                  // 에러 페이지 이동
                  System.out.println("에러 발생");
                  return new ModelAndView("redirect:/admin/product.nm?rslt=error", null);
               }
            }
            else if (item.equals("sal"))
            {
               int r = productSvc.editSaleState(no[i], order);
               if(r == S.PROCESS_ERROR)
               {
                  // 에러 페이지 이동
                  System.out.println("에러 발생");
                  return new ModelAndView("redirect:/admin/product.nm?rslt=error", null);
               }
            }
            else if (item.equals("del"))
            {
               int r = productSvc.editDeletedState(no[i], order);
                  
               if(r == S.PROCESS_ERROR)
               {
                  // 에러 페이지 이동
                  System.out.println("에러 발생");
                  return new ModelAndView("redirect:/admin/product.nm?rslt=error", null);
               }
            }
            else
            {
            	// 에러 페이지 이동
                System.out.println("에러 발생");
                return new ModelAndView("redirect:/admin/product.nm?rslt=error", null);
            }
         }
         
         if(item.equals("del")&& order == S.STATE_FALSE)
            return new ModelAndView("redirect:/admin/product.nm?page=deleted", null);
         else
            return new ModelAndView("redirect:/admin/product.nm", null);  
      }
      else
      {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 map.put("err_msg", "관리자로 로그인 바랍니다.");
         return new ModelAndView("login/login", map);
      }
   }

   // 상품 등록 페이지 준비
   @RequestMapping(value ="/admin/product.nm", method=RequestMethod.GET, params="page=register")
   public ModelAndView product_prepareRegister (HttpServletRequest request, HttpSession session)
   {
      // 세션에서 아이디와 관리자인지 여부를 얻어옴
      Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
      Map<String, Object> map = new HashMap<String, Object>();
      
      if (isAdmin!= null && isAdmin.booleanValue())
      {
         List<CategoryVo> c_list = categorySvc.getAllCategory();
                  
         map.put("c_list", c_list);
         return new ModelAndView("admin/product/a_product", map);
      }
      else
      {
    	 map.put("err_msg", "관리자로 로그인 바랍니다.");
         return new ModelAndView("redirect:/login.nm", null);
      }
   }
   
   // 상품 등록하는 페이지
   @RequestMapping(value ="/admin/product_reg_proc.nm", method=RequestMethod.POST)
   public ModelAndView product_register(HttpServletRequest request, HttpSession session,
         @RequestParam (value="represent_img") MultipartFile represent_img,
         @RequestParam (value="detail_img") MultipartFile detail_img,
         @RequestParam Map<String, String> pro_param) throws IllegalStateException, IOException
   {
      // 세션에서 아이디와 관리자인지 여부를 얻어옴
      Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
      Map<String, Object> map = new HashMap<String, Object>();
      
      if (isAdmin!= null && isAdmin.booleanValue())
      {
         //***************************************** ******************************* 업로드 파일 처리 부분
         // 이미지 업로드 경로 지정
         String root_path = request.getSession().getServletContext().getRealPath("/");  
          String attach_path = "/resources/product_images/";
          // 이미지 파일 이름 가져옴
          String re_imgName = represent_img.getOriginalFilename();
          String de_imgName = detail_img.getOriginalFilename();
          
          File re_img = new File(root_path + attach_path + re_imgName);
          File de_img = new File(root_path + attach_path + de_imgName);
          
          represent_img.transferTo(re_img);
          detail_img.transferTo(de_img);
          
   //       // 예외 없이 정상 물리 파일 저장이 완료 되었다면?
   //       long realFilesize1 = re_img.length();
   //       String realFileName1 = re_img.getName();
   //       String realFilePath1 = re_img.getAbsolutePath();
   //       System.out.println("FILE NAME: " + realFileName1);
   //       System.out.println("FILE PATH: " + realFilePath1);
   //       System.out.println("FILE SIZE: " + realFilesize1);
   //       
   //       long realFilesize2 = de_img.length();
   //       String realFileName2 = de_img.getName();
   //       String realFilePath2 = de_img.getAbsolutePath();
   //       System.out.println("FILE NAME: " + realFileName2);
   //       System.out.println("FILE PATH: " + realFilePath2);
   //       System.out.println("FILE SIZE: " + realFilesize2);
        //***************************************** ******************************* 업로드 파일 처리 부분
          
          // 파일 등록 부분
          int category_cd = 0;
          int selling_price = 0;
          int cost_price = 0;
          int stock = 0;
          int display_state = 0;
          int sale_state = 0;
          int weight = 0;
   
          try
          { 
             category_cd = Integer.parseInt(pro_param.get("category_cd"));
             selling_price = Integer.parseInt(pro_param.get("selling_price"));
             cost_price = Integer.parseInt(pro_param.get("cost_price"));
             stock = Integer.parseInt(pro_param.get("stock"));
             display_state = Integer.parseInt(pro_param.get("display_state"));
             sale_state = Integer.parseInt(pro_param.get("sale_state"));
             weight = Integer.parseInt(pro_param.get("weight"));
          }
          catch(NumberFormatException e)
          {
             // 에러 페이지 이동
   //          e.printStackTrace();
          }
          
          // 등록할 상품 만들기
          ProductVo new_product = new ProductVo();
          new_product.setProduct_name(pro_param.get("product_name"));
          new_product.setSelling_price(selling_price);
          new_product.setCost_price(cost_price);
          new_product.setStock(stock);
          new_product.setDisplay_state(display_state);
          new_product.setSale_state(sale_state);
          new_product.setRepresent_img(re_img.getName());
          new_product.setDetail_img(de_img.getName());
          new_product.setSummary_ex(pro_param.get("summary_ex"));
          new_product.setDetail_ex(pro_param.get("detail_ex"));
          new_product.setWeight(weight);
          new_product.setCategory_cd(category_cd);
          
          int result = productSvc.addProduct(new_product);
          
          // 상품 등록 성공
          if (result == S.PROCESS_SUCCESS)
          {
             // 상품 등록 성공 페이지로 이동
             return new ModelAndView("redirect:/admin/product.nm?page=manage&rslt=true", null);
          }
          else   // 실패
          {
             // 에러 메세지
             return new ModelAndView("redirect:/admin/product.nm?page=register&rslt=false", null);
          }
      }
      else
      {
    	 map.put("err_msg", "관리자로 로그인 바랍니다.");
         return new ModelAndView("redirect:/login.nm", map);
      }
   }
   
   // 상품 수정 페이지 준비
   @RequestMapping(value ="/admin/product.nm", method=RequestMethod.GET, params="page=modify")
   public ModelAndView product_prepareModify (HttpServletRequest request, HttpSession session,
         @RequestParam(value="no", required=false) int product_no)
   {
      // 세션에서 아이디와 관리자인지 여부를 얻어옴
      Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
      Map<String, Object> map = new HashMap<String, Object>();
      
      if (isAdmin!= null && isAdmin.booleanValue())
      {
         List<CategoryVo> c_list = categorySvc.getAllCategory();
         ProductVo old_product = productSvc.getOneProduct(product_no);
                  
         map.put("c_list", c_list);
         map.put("productVo", old_product);
         return new ModelAndView("admin/product/a_product", map);
      }
      else
      {
    	  map.put("err_msg", "관리자로 로그인 바랍니다.");
          return new ModelAndView("redirect:/login.nm", map);
      }
   }
   
   // 상품 수정하는 페이지
      @RequestMapping(value ="/admin/product_modi_proc.nm", method=RequestMethod.POST)
      public ModelAndView product_modify(HttpServletRequest request, HttpSession session,
            @RequestParam (value="re_img", required=false) MultipartFile represent_img,
            @RequestParam (value="de_img", required=false) MultipartFile detail_img,
            @RequestParam Map<String, String> pro_param) throws IllegalStateException, IOException
      {
         // 세션에서 아이디와 관리자인지 여부를 얻어옴
         Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
         
         if (isAdmin!= null && isAdmin.booleanValue())
         {      
            ProductVo old_product = productSvc.getOneProduct(Integer.parseInt(pro_param.get("product_no")));
            
            //***************************************** ******************************* 업로드 파일 처리 부분
            
            // 이미지 업로드 경로 지정
            String root_path = request.getSession().getServletContext().getRealPath("/");  
            String attach_path = "resources/product_images/";
             
            File re_img = null;
            File de_img = null;
   
             // 이미지 파일 이름 가져옴
             if (represent_img != null && !represent_img.isEmpty())
             {
                represent_img.getName();
                String re_imgName = represent_img.getOriginalFilename();
                re_img = new File(root_path + attach_path + re_imgName);
                represent_img.transferTo(re_img);
                old_product.setRepresent_img(re_img.getName());
             }
             
             if (detail_img != null && !detail_img.isEmpty())
             {
                detail_img.getName();
                String de_imgName = detail_img.getOriginalFilename();
                de_img = new File(root_path + attach_path + de_imgName);
                detail_img.transferTo(de_img);
                old_product.setDetail_img(de_img.getName());
             }
                                         
   //          // 예외 없이 정상 물리 파일 저장이 완료 되었다면?
   //          long realFilesize1 = re_img.length();
   //          String realFileName1 = re_img.getName();
   //          String realFilePath1 = re_img.getAbsolutePath();
   //          System.out.println("FILE NAME: " + realFileName1);
   //          System.out.println("FILE PATH: " + realFilePath1);
   //          System.out.println("FILE SIZE: " + realFilesize1);
   //          
   //          long realFilesize2 = de_img.length();
   //          String realFileName2 = de_img.getName();
   //          String realFilePath2 = de_img.getAbsolutePath();
   //          System.out.println("FILE NAME: " + realFileName2);
   //          System.out.println("FILE PATH: " + realFilePath2);
   //          System.out.println("FILE SIZE: " + realFilesize2);
           //***************************************** ******************************* 업로드 파일 처리 부분
                   
             // 파일 수정 부분
             int category_cd = 0;
             int selling_price = 0;
             int cost_price = 0;
             int stock = 0;
             int display_state = 0;
             int sale_state = 0;
             int weight = 0;
   
             try
             { 
                category_cd = Integer.parseInt(pro_param.get("category_cd"));
                selling_price = Integer.parseInt(pro_param.get("selling_price"));
                cost_price = Integer.parseInt(pro_param.get("cost_price"));
                stock = Integer.parseInt(pro_param.get("stock"));
                display_state = Integer.parseInt(pro_param.get("display_state"));
                sale_state = Integer.parseInt(pro_param.get("sale_state"));
                weight = Integer.parseInt(pro_param.get("weight"));
             }
             catch(NumberFormatException e)
             {
                // 에러 페이지 이동
   //             e.printStackTrace();
             }
             
             old_product.setProduct_name(pro_param.get("product_name"));
             old_product.setSelling_price(selling_price);
             old_product.setCost_price(cost_price);
             old_product.setStock(stock);
             old_product.setDisplay_state(display_state);
             old_product.setSale_state(sale_state);
             old_product.setSummary_ex(pro_param.get("summary_ex"));
             old_product.setDetail_ex(pro_param.get("detail_ex"));
             old_product.setWeight(weight);
             old_product.setCategory_cd(category_cd);
             
             int result = productSvc.editOneProduct(old_product);
             
             // 상품 등록 성공
             if (result == S.PROCESS_SUCCESS)
             {
                // 상품 등록 성공 페이지로 이동
                return new ModelAndView("redirect:/admin/product.nm?page=manage&rslt=m_true", null);
             }
             else   // 실패
             {
                // 에러 메세지
                return new ModelAndView("redirect:/admin/product.nm?page=manage&rslt=m_false", null);
             }
         }
         else
         {
	       	 Map<String, Object> map = new HashMap<String, Object>();
	       	 map.put("err_msg", "관리자로 로그인 바랍니다.");
	         return new ModelAndView("login/login", map);
         }
      }
   
   //*********************************************************************//
   //TODO  안녕
      
   @RequestMapping(value ="/index.nm", method=RequestMethod.GET)
   public ModelAndView product_index_menu(HttpServletRequest req){
      
      String category_name = "모든상품";
      
      Map<String,Object> map = new HashMap<String,Object>();
      
      try{
         List<ProductVo> product_list = productSvc.getAllProduct();
         
         if(product_list != null && product_list.size() != 0)
            map.put("product_list", product_list);
         
      } catch(Exception e){
         e.printStackTrace();
      }
      map.put("category_name", category_name);
      
      return new ModelAndView("index", map);
   }
   
   @RequestMapping(value ="/product/list.nm", method=RequestMethod.GET)
   public ModelAndView product_category_menu(HttpServletRequest req,
         @RequestParam (value="cate", required=false) String cate){

      int category_code;
      String category_name = "분류없음";
      
      Map<String,Object> map = new HashMap<String,Object>();
      
      try{
         if(cate!=null){
            category_code = Integer.parseInt(cate);
            category_name = categorySvc.getCategoryNameByCd(category_code);
         
            List<ProductVo> product_list = productSvc.getProductByCategoryCd(category_code);
            if(product_list != null && product_list.size() != 0)
               map.put("product_list", product_list);
         }
      } catch(Exception e){
         e.printStackTrace();
      }
      map.put("category_name", category_name);
      
      return new ModelAndView("product/product_menu", map);
   }
   
   @RequestMapping(value="product/detail.nm", method=RequestMethod.GET)
   public ModelAndView product_description(HttpServletRequest req, HttpSession session,
         @RequestParam (value="pdno") String pdno,
         @RequestParam(value="page", defaultValue="1") int page)
   {
      
      int product_no;

      Map<String,Object> map = new HashMap<String,Object>();
      
      try{
         if(pdno!=null){
            product_no = Integer.parseInt(pdno);
            
            ProductVo product_vo = productSvc.getOneProduct(product_no);

            if(product_vo != null)
               map.put("pvo", product_vo);
            
            // 리뷰 글 가져오는 부분      
            String id = (String)session.getAttribute(S.SESSION_LOGIN);
            Boolean isAdmin = (Boolean)session.getAttribute(S.SESSION_ADMIN);
            int all_reviews = review_frontSvc.getCountReviews(product_no);
            int all_pages = (int)(Math.ceil((double)all_reviews / S.PAGE_LIMIT));
            List<VReview_FrontVo> rvw_list = review_frontSvc.getAllList(product_no, page);
            List<List<Review_ReVo>> rvws_re_list = new ArrayList<List<Review_ReVo>>();
            for(VReview_FrontVo rvw : rvw_list)
            {
               int review_no = rvw.getReview_no();
               rvws_re_list.add(review_reSvc.getAllRe(review_no));
            }

            map.put("id", id);
            map.put("isAdmin", isAdmin);
            map.put("rvw_list", rvw_list);
            map.put("re_list", rvws_re_list);
            map.put("rp", new Integer(page));
            map.put("all_pages", all_pages);
            // 리뷰 가져오는 부분 끝
         }
      } catch(Exception e){
         e.printStackTrace();
      }
      
      return new ModelAndView("product/product_detail", map);
   }
   
   // 상품 검색하는 부분
   // /product/search.nm
   @RequestMapping(value="product/search.nm", method=RequestMethod.GET)
   public ModelAndView product_description(HttpServletRequest req, HttpSession session,
         @RequestParam (value="kw", required=false) String kw)
   {
	   Map<String,Object> map = new HashMap<String,Object>();

      try{ 
         List<ProductVo> product_list = productSvc.searchProduct(kw);
         
         if(product_list != null && product_list.size() != 0)
            map.put("product_list", product_list);
         	map.put("kw", kw);
	     } catch(Exception e){
	        e.printStackTrace();
	     }
	     
	     return new ModelAndView("product/product_menu", map);
   }
}