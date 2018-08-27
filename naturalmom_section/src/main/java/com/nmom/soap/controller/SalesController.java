package com.nmom.soap.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nmom.soap.S;
import com.nmom.soap.data.model.sales.SaleStatementVo;
import com.nmom.soap.data.model.sales.VRank_SellsVo;
import com.nmom.soap.data.model.sales.stat.AgeGroupStat;
import com.nmom.soap.data.model.sales.stat.AgeGroupStatList;
import com.nmom.soap.data.model.sales.stat.AgeGroupVo;
import com.nmom.soap.data.model.sales.stat.GenderGroupStat;
import com.nmom.soap.data.model.sales.stat.GenderGroupStatList;
import com.nmom.soap.data.model.sales.stat.GenderGroupVo;
import com.nmom.soap.data.model.sales.stat.VRank_SellsStat;
import com.nmom.soap.data.model.sales.stat.VRank_SellsStatList;
import com.nmom.soap.svc.sales.ISaleStatementSvc;
import com.nmom.soap.svc.sales.IVRank_SellsSvc;

@Controller
public class SalesController 
{
	private IVRank_SellsSvc rank_sellsSvc;
	private ISaleStatementSvc saleStatementSvc;
	
	public void setRank_sellsSvc(IVRank_SellsSvc rank_sellsSvc) 
	{
		this.rank_sellsSvc = rank_sellsSvc;
	}

	public void setSaleStatementSvc(ISaleStatementSvc saleStatementSvc) 
	{
		this.saleStatementSvc = saleStatementSvc;
	}
	
	// 총 누적 판매량 차트
	@RequestMapping(value="/admin/sales_charts.nm", method=RequestMethod.GET)
	@ResponseBody
	public VRank_SellsStatList reportSellsStat()
	{
		List<VRank_SellsVo> rank_list = rank_sellsSvc.getAllRank(true);
		List<VRank_SellsStat> rStat_list = new ArrayList<VRank_SellsStat>();
		
		for (VRank_SellsVo rs : rank_list)
		{
			VRank_SellsStat rss = new VRank_SellsStat(rs.getProduct_name(), rs.getAll_sells());
			rStat_list.add(rss);
		}
		
		return new VRank_SellsStatList(rStat_list, "총 누적판매량");
	}
	
	// 연령별 회원 수 차트
	@RequestMapping(value="/admin/age_charts.nm", method=RequestMethod.GET)
	@ResponseBody
	public AgeGroupStatList reportAgeGroupStat()
	{
		List<AgeGroupVo> age_list = rank_sellsSvc.getStatAgeGroup();
		List<AgeGroupStat> aStat_list = new ArrayList<AgeGroupStat>();
		
		for (AgeGroupVo age : age_list)
		{
			AgeGroupStat ags = new AgeGroupStat(age.getRatio(), age.getAmount(), age.getAge_group()+"대", null);
			aStat_list.add(ags);
		}
		
		return new AgeGroupStatList(aStat_list, "연령별 분포도");
	}
	
	// 성별 회원 수 차트
	@RequestMapping(value="/admin/gender_charts.nm", method=RequestMethod.GET)
	@ResponseBody
	public GenderGroupStatList reportGenderGroupStat()
	{
		List<GenderGroupVo> gender_list = rank_sellsSvc.getStatGenderGroup();
		List<GenderGroupStat> gStat_list = new ArrayList<GenderGroupStat>();
		
		for (GenderGroupVo gen : gender_list)
		{
			GenderGroupStat ggs = new GenderGroupStat(gen.getRatio(), gen.getAmount(), 
					(gen.getMem_gender() == 1 ? "남" : "여"), null);
			gStat_list.add(ggs);
		}
		
		return new GenderGroupStatList(gStat_list, "성별당 회원 분포도");
	}
	
	
	@RequestMapping(value="/admin/sales.nm", method=RequestMethod.GET, params="page=analysis")
	public ModelAndView sales_analysis(HttpServletRequest reqeust, HttpSession session)
	{
		// 세션에서 아이디와 관리자인지 여부를 얻어옴
	    Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
		Map<String, Object> map = new HashMap<String,Object>();
		
		if (isAdmin!= null && isAdmin.booleanValue())
		{
			List<VRank_SellsVo> rank_list = rank_sellsSvc.getAllRank(true);
			map.put("rank_list", rank_list);
			return new ModelAndView("admin/sales/a_sales", map);
		}
		else
		{
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
	}
	
	@RequestMapping(value="/admin/sales.nm", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView sales_table(HttpServletRequest reqeust, 
			HttpSession session,
			@RequestParam(value="t", required=false) Object day, //Date
			@RequestParam(value="p", required=false) Object prev, //String
			@RequestParam(value="s", required=false) Object start, //Date
			@RequestParam(value="e", required=false) Object end, //Date
			@RequestParam(value="a", required=false) Object all //Date
			)
	{
		// 세션에서 아이디와 관리자인지 여부를 얻어옴
	    Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
		Map<String, Object> map = new HashMap<String,Object>();
		
		if (isAdmin!= null && isAdmin.booleanValue())
		{
			
			if(all != null){
				SaleStatementVo sale = this.saleStatementSvc.getSaleStatement();
				map.put("sale", sale);
				return new ModelAndView("admin/sales/a_sales", map);
			}
			
			//당일
			else if(day != null && prev == null){
				Date inputdate = new Date((String)day);
				Calendar today = Calendar.getInstance();
				today.setTime(inputdate);
				SaleStatementVo sale = this.saleStatementSvc.getSaleStatement(today);
				map.put("sale", sale);
				return new ModelAndView("admin/sales/a_sales", map);
				
			}
			//일주일전, 한달 전 등등
			else if(day != null && prev != null){
				String kind = (String)prev;
				Date input = new Date((String)day);
				switch (kind) {
				case "week":
					
					Calendar endW = Calendar.getInstance();
					endW.setTime(input);
					Calendar startW = Calendar.getInstance();
					startW.setTime(input);
					startW.add(Calendar.DAY_OF_WEEK, -7);
					SaleStatementVo sale1 = this.saleStatementSvc.getSaleStatement(startW, endW);
					map.put("sale", sale1);
					return new ModelAndView("admin/sales/a_sales", map);

				case "month1":
					Calendar endM1 = Calendar.getInstance();
					endM1.setTime(input);
					Calendar startM1 = Calendar.getInstance();
					startM1.setTime(input);
					startM1.add(Calendar.MONTH, -1);
					SaleStatementVo sale2 = this.saleStatementSvc.getSaleStatement(startM1, endM1);
					map.put("sale", sale2);
					return new ModelAndView("admin/sales/a_sales", map);
					
				case "month3":
					Calendar endM3 = Calendar.getInstance();
					endM3.setTime(input);
					Calendar startM3 = Calendar.getInstance();
					startM3.setTime(input);
					startM3.add(Calendar.MONTH, -3);
					SaleStatementVo sale3 = this.saleStatementSvc.getSaleStatement(startM3, endM3);
					map.put("sale", sale3);
					return new ModelAndView("admin/sales/a_sales", map);
					
					
				case "month6":
					Calendar endM6 = Calendar.getInstance();
					endM6.setTime(input);
					Calendar startM6 = Calendar.getInstance();
					startM6.setTime(input);
					startM6.add(Calendar.MONTH, -6);
					SaleStatementVo sale6 = this.saleStatementSvc.getSaleStatement(startM6, endM6);
					map.put("sale", sale6);
					return new ModelAndView("admin/sales/a_sales", map);
				}
			}
			//기간
			else if(start != null && end != null){
//				Date s = new Date((String)start);
//				Date e = new Date((String)end);
				System.out.println((String)start+(String)end);
				String sd[] = ((String)start).split("-");
				String ed[] = ((String)end).split("-");
				Date s = new Date();
				Date e = new Date();
				
				s.setYear(Integer.parseInt(sd[0])-1900);
				e.setYear(Integer.parseInt(ed[0])-1900);
				
				s.setMonth(Integer.parseInt(sd[1])-1);
				e.setMonth(Integer.parseInt(ed[1])-1);
				
				s.setDate(Integer.parseInt(sd[2]));
				e.setDate(Integer.parseInt(ed[2]));
				System.out.println(s.toLocaleString()+e.toLocaleString());
				
				Calendar sta = Calendar.getInstance();
				sta.setTime(s);
				Calendar en = Calendar.getInstance();
				en.setTime(e);
				SaleStatementVo sale7 = this.saleStatementSvc.getSaleStatement(sta, en);
				map.put("sale", sale7);
				return new ModelAndView("admin/sales/a_sales", map);
			}
			//전체
			else if(day == null){
				SaleStatementVo sale = this.saleStatementSvc.getSaleStatement();
				map.put("sale", sale);
				return new ModelAndView("admin/sales/a_sales", map);
			}
			SaleStatementVo sale = this.saleStatementSvc.getSaleStatement();
			map.put("sale", sale);
			return new ModelAndView("admin/sales/a_sales", map);
		}
		
		else
		{
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
	}
}
