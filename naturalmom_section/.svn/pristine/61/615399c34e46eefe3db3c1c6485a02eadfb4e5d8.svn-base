package com.nmom.soap.svc.order;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.S;
import com.nmom.soap.data.dao.order.IVOrderListDao;
import com.nmom.soap.data.model.board.notice.VNoticeVo;
import com.nmom.soap.data.model.order.VOrderListVo;

public class VOrderListSvcImpl implements IVOrderListSvc {

	private IVOrderListDao vOrderListDao;
	
	@Override
	public List<VOrderListVo> getAllOreder(String mem_id) {

		List<VOrderListVo> list = this.vOrderListDao.getAllOreder(mem_id);
		return (list != null && list.size() > 0) ? list : null; 
	}

	@Override
	public int getAllCount(String mem_id) {
		return this.vOrderListDao.getAllCount(mem_id);
	}

	@Override
	public VOrderListVo getOneOrder(int order_no) throws DataAccessException {
		return this.vOrderListDao.getOneOrder(order_no);
	}
	
	public void setVOrderListDao(IVOrderListDao vOrderListDao) {
		this.vOrderListDao = vOrderListDao;
	}


}
