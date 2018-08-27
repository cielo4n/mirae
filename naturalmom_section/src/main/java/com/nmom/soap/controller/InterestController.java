package com.nmom.soap.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nmom.soap.data.model.interest.VInterestProductVo;
import com.nmom.soap.svc.interest.IInterestSvc;
import com.nmom.soap.svc.interest.IVInterestProductSvc;

@Controller
public class InterestController {
	IInterestSvc interestSvc;
	IVInterestProductSvc vInterestProductSvc;
	
	public void setInterestSvc(IInterestSvc interestSvc) {
		this.interestSvc = interestSvc;
	}
	public void setVInterestProductSvc(IVInterestProductSvc vInterestProductSvc) {
		this.vInterestProductSvc = vInterestProductSvc;
	}

	@RequestMapping(value ="/interest.nm", method=RequestMethod.GET)
	public ModelAndView menu_interest(HttpServletRequest req, HttpSession ses)
	{
		String loggedin = (String)ses.getAttribute("loggedin");
		
		List<VInterestProductVo> interest_list = this.vInterestProductSvc.getInterestByMemId(loggedin);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", "interest");
		
		if(interest_list!=null && interest_list.size()!=0){
			map.put("interest_list", interest_list);
		}
		
		ModelAndView mav = new ModelAndView("mypage/mypage", map);
		return mav;
	}
	
	@RequestMapping(value ="/mypage.nm", method=RequestMethod.GET)
	public ModelAndView menu_mypage(HttpServletRequest req, HttpSession ses){
		
		String loggedin = (String)ses.getAttribute("loggedin");
		
		List<VInterestProductVo> interest_list = this.vInterestProductSvc.getInterestByMemId(loggedin);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", "interest");
		
		if(interest_list!=null && interest_list.size()!=0){
			map.put("interest_list", interest_list);
		}
		
		ModelAndView mav = new ModelAndView("mypage/mypage", map);
		return mav;
	}
	
	// 관심상품 추가 /interest/add_proc.nm
	@RequestMapping(value ="/interest/add_proc.nm", method=RequestMethod.GET)
	public ModelAndView addInterest(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="i_pn") String i_pn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(i_pn !=null){
			try{
				String loggedin = (String)ses.getAttribute("loggedin");
				int product_no = Integer.parseInt(i_pn);
			
				//중복된 경우 관심상품 추가 불가능하다고 알려줌
				if(interestSvc.duplicationInterestProduct(product_no, loggedin)){ 
					map.put("pdno", i_pn);
					map.put("add_i", "dup");
					return new ModelAndView("redirect:/product/detail.nm", map);
				}
				else { //중복아니면 관심상품 추가
					int r = interestSvc.addInterestProduct(product_no, loggedin);

					if(r==1){
						map.put("pdno", i_pn);
						map.put("add_i", "ok");
						return new ModelAndView("redirect:/product/detail.nm", map);
					} else {
						System.out.println("관심상품 추가 에러");
					}
				}
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("관심상품 추가에서 잘못된 관심상품 정보가져옴");
			}
			
		} else {
			System.out.println("관심상품 추가에서 정보를 받아오지 못함");
		}
		return new ModelAndView("redirect:/index.nm", map);
	}
	
	// 관심상품 삭제 /interest/del_proc.nm
	@RequestMapping(value ="/interest/del_proc.nm", method=RequestMethod.GET)
	public String deleteInterest(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="no") int no[])
	{
		String loggedin = (String)ses.getAttribute("loggedin");

		if(no !=null){
			try{
				for(int i=0; i<no.length; i++){
					int r = interestSvc.removeInterestProduct(no[i], loggedin);
					if(r != 1){
						System.out.println("관심상품 삭제 에러");
						return "redirect:/index.nm";
					}
				}
				return "redirect:/interest.nm";
				
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("관심상품 삭제에서 잘못된 관심상품 정보가져옴");
			}
		} else {
			System.out.println("관심상품 삭제에서 정보를 받아오지 못함");
		}
		return "redirect:/index.nm";
	}
	
	
	//- 관심상품 -> 장바구니
	// /interest/to_cart 관심상품에서 삭제
	// /cart/from_interest 장바구니에 등록
	@RequestMapping(value ="/interest/to_cart.nm", method=RequestMethod.GET)
	public ModelAndView delInterestForMoveCart(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="no") int no[])
	{	
		Map<String,Object> map = new HashMap<String,Object>();

		//관심상품 삭제 부분
		String loggedin = (String)ses.getAttribute("loggedin");
		if(no !=null){
			try{
				for(int i=0; i<no.length; i++){
					int r = interestSvc.removeInterestProduct(no[i], loggedin);
					if(r != 1){
						System.out.println("관심상품 삭제 에러(관심상품 -> 장바구니)");
						return new ModelAndView("redirect:/index.nm");
					} 
				} //end for
				
				//관심상품 삭제 성공
				//장바구니에 등록할 부분
				map.put("no", no);
				return new ModelAndView("redirect:/cart/from_interest.nm", map);
				
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("관심상품 -> 장바구니에서 잘못된 관심상품 정보가져옴");
			}
		} else {
			System.out.println("관심상품 -> 장바구니에서 정보를 받아오지 못함");
		}
		return new ModelAndView("redirect:/index.nm");
	}
	

	// - 장바구니 -> 관심상품 
	// /cart/to_interest 장바구니에서 삭제
	// /interest/from_cart 관심상품에 등록
	@RequestMapping(value ="/interest/from_cart", method=RequestMethod.GET)
	public ModelAndView addInterestFromCart(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="no") int no[])
	{	
		Map<String,Object> map = new HashMap<String,Object>();

		//관심상품 등록 부분
		String loggedin = (String)ses.getAttribute("loggedin");
		if(no !=null){
			try{
				for(int i=0; i<no.length; i++){
					if(interestSvc.duplicationInterestProduct(no[i], loggedin) == false){
						int r = interestSvc.addInterestProduct(no[i], loggedin);

						if(r != 1){
							System.out.println("관심상품 등록 에러(장바구니 -> 관심상품)");
						}
					}
				} //end for
				
				//관심상품 등록 성공
				return new ModelAndView("redirect:/interest.nm");
				
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("장바구니 -> 관심상품에서 잘못된 관심상품 정보가져옴");
			}
		} else {
			System.out.println("장바구니 -> 관심상품에서 정보를 받아오지 못함");
		}
		return new ModelAndView("redirect:/index.nm");
	}
	
}