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

import com.nmom.soap.data.model.cart.CartVo;
import com.nmom.soap.data.model.cart.VCartProductVo;
import com.nmom.soap.svc.cart.ICartSvc;
import com.nmom.soap.svc.cart.IVCartProductSvc;

@Controller
public class CartController {
	
	ICartSvc cartSvc;
	IVCartProductSvc vCartProductSvc;
	
	public void setCartSvc(ICartSvc cartSvc) {
		this.cartSvc = cartSvc;
	}
	public void setVCartProductSvc(IVCartProductSvc vCartProductSvc) {
		this.vCartProductSvc = vCartProductSvc;
	}
	
	@RequestMapping(value ="/cart.nm", method=RequestMethod.GET)
	public ModelAndView menu_cart(HttpServletRequest req, HttpSession ses)
	{
		//목록 보여주는 부분
		String loggedin = (String)ses.getAttribute("loggedin");
		List<VCartProductVo> cart_list = this.vCartProductSvc.getCartByMemId(loggedin);
		Map<String,Object> map = new HashMap<String,Object>();
		if(cart_list!=null && cart_list.size()!=0){
			map.put("cart_list", cart_list);
		}
		
		ModelAndView mav = new ModelAndView("/order/cart", map);
		return mav;
	}
	
	
	// 장바구니 상품 추가 /cart/add_proc.nm
	@RequestMapping(value ="/cart/add_proc.nm", method=RequestMethod.GET)
	public ModelAndView addCart(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="c_pn") String c_pn,
			@RequestParam(value="c_bn") String c_bn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(c_pn !=null && c_bn!=null){
			try{
				String loggedin = (String)ses.getAttribute("loggedin");
				int product_no = Integer.parseInt(c_pn);
				int buy_num = Integer.parseInt(c_bn);
			
				//중복된 경우 수량 수정
				if(cartSvc.duplicationCartProduct(product_no, loggedin)){ 
					
					//현재 개수 가져와서 갱신함
					int old_buy_num = cartSvc.getBuyNum(product_no, loggedin);
					int r = cartSvc.editCartProduct(product_no, loggedin, old_buy_num + buy_num);
					if(r == 1){
						map.put("pdno", c_pn);
						map.put("add_c", "ok");
						return new ModelAndView("redirect:/product/detail.nm", map);
						
					} else {
						System.out.println("장바구니 추가부분에서 갱신 에러");
					}
				} else { //중복아니면 새로 추가
					int r = cartSvc.addCartProduct(new CartVo(product_no, loggedin, buy_num));
					
					if(r==1){
						map.put("pdno", c_pn);
						map.put("add_c", "ok");
						return new ModelAndView("redirect:/product/detail.nm", map);
					} else {
						System.out.println("장바구니 추가 에러");
					}
				}
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("장바구니 추가에서 잘못된 장바구니 정보가져옴");
			}
			
		} else {
			System.out.println("장바구니 추가에서 정보를 받아오지 못함");
		}
		return new ModelAndView("redirect:/index.nm", map);
	}
	
	// 장바구니 상품 개수 수정 /cart/edit_proc.nm
	@RequestMapping(value ="/cart/edit_proc.nm", method=RequestMethod.GET)
	public ModelAndView editCart(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="c_pn") String c_pn,
			@RequestParam(value="c_bn") String c_bn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(c_pn !=null && c_bn!=null){
			try{
				String loggedin = (String)ses.getAttribute("loggedin");
				int product_no = Integer.parseInt(c_pn);
				int buy_num = Integer.parseInt(c_bn);
				
				int r = cartSvc.editCartProduct(product_no, loggedin, buy_num);
				if(r==1){
					return new ModelAndView("redirect:/cart.nm", map);
				} else {
					System.out.println("장바구니 수정 에러");
				}
				
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("장바구니 수정에서 잘못된 장바구니 정보가져옴");
			}
		} else {
			System.out.println("장바구니 수정에서 정보를 받아오지 못함");
		}
		return new ModelAndView("redirect:/index.nm", map);
	}
	
	// 장바구니 상품 삭제 /cart/del_proc.nm
	@RequestMapping(value ="/cart/del_proc.nm", method=RequestMethod.GET)
	public String editCart(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="no") int no[])
	{
		Map<String,Object> map = new HashMap<String,Object>();
		String loggedin = (String)ses.getAttribute("loggedin");

		if(no !=null){
			try{
				for(int i=0; i<no.length; i++){
					int r = cartSvc.removeCartProduct(no[i], loggedin);
					if(r != 1){
						System.out.println("장바구니 삭제 에러");
						return "redirect:/index.nm";
					}
				}
				return "redirect:/cart.nm";
				
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("장바구니 삭제에서 잘못된 장바구니 정보가져옴");
			}
		} else {
			System.out.println("장바구니 삭제에서 정보를 받아오지 못함");
		}
		return "redirect:/index.nm";
	}
	
	// - 장바구니 -> 관심상품 
	// /cart/to_interest 장바구니에서 삭제
	// /interest/from_cart 관심상품에 등록
	@RequestMapping(value ="/cart/to_interest.nm", method=RequestMethod.GET)
	public ModelAndView delCartForMoveInterest(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="no") int no[]){
		
		//장바구니에서 상품 삭제하는 부분
		Map<String,Object> map = new HashMap<String,Object>();
		String loggedin = (String)ses.getAttribute("loggedin");
		
		if(no!=null){
			
			try{
				for(int i=0; i<no.length; i++){
					int r = cartSvc.removeCartProduct(no[i], loggedin);
					if(r != 1){
						System.out.println("장바구니 삭제 에러(장바구니 -> 관심상품)");
						return new ModelAndView("redirect:/index.nm");
					}
				} //end for
				
				//장바구니 상품 삭제 성공
				//관심상품에서 상품 등록하는 부분으로 보냄
				map.put("no", no);
				return new ModelAndView("redirect:/interest/from_cart.nm", map);
			
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("장바구니 -> 관심상품에서 잘못된 장바구니 정보가져옴");
			}
			
		} else {
			System.out.println("장바구니 -> 관심상품에서 정보를 받아오지 못함");
		}
		return new ModelAndView("redirect:/index.nm");
	}	

	
	//- 관심상품 -> 장바구니
	// /interest/to_cart 관심상품에서 삭제
	// /cart/from_interest 장바구니에 등록
	@RequestMapping(value ="/cart/from_interest.nm", method=RequestMethod.GET)
	public String addCartFromInterest(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="no") int no[]){
		//장바구니에 상품 추가하는 부분
		Map<String,Object> map = new HashMap<String,Object>();
		String loggedin = (String)ses.getAttribute("loggedin");
		
		if(no !=null){
			try{
				for(int i=0; i<no.length; i++){
					if(cartSvc.duplicationCartProduct(no[i], loggedin) == false){
						int r = cartSvc.addCartProduct(new CartVo(no[i], loggedin, 1));

						if(r != 1){
							System.out.println("장바구니 추가 에러(관심상품 -> 장바구니)");
						}
					}
				} //end for
				
				//장바구니 추가 성공
				return "redirect:/cart.nm";
				
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("관심상품 -> 장바구니에서 잘못된 장바구니 정보가져옴");
			}
		} else {
			System.out.println("관심상품 -> 장바구니에서 정보를 받아오지 못함");
		}
		return "redirect:/index.nm";
	}
	
}
