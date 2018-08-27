package com.nmom.soap.svc.sales;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.dao.sales.ISaleStatementDao;
import com.nmom.soap.data.model.sales.SaleStatementVo;

public class SaleStatementSvcImpl implements ISaleStatementSvc {

	private ISaleStatementDao saleStatementDao;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public SaleStatementVo getSaleStatement() {
		return this.saleStatementDao.getSaleStatement();
	}

	@Override
	public SaleStatementVo getSaleStatement(Calendar today) {
		System.out.println(sdf.format(today.getTime()));
		return this.saleStatementDao.getSaleStatement(
				sdf.format(today.getTime()));
	}

	@Override
	public SaleStatementVo getSaleStatement(Calendar start, Calendar end) {
		System.out.println(sdf.format(start.getTime())+sdf.format(end.getTime()));
		return this.saleStatementDao.getSaleStatement(
				sdf.format(start.getTime()), 
				sdf.format(end.getTime()));
	}

	
	public void setSaleStatementDao(ISaleStatementDao saleStatementDao) {
		this.saleStatementDao = saleStatementDao;
	}
}
