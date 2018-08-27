package com.nmom.soap.svc.member;

import com.nmom.soap.data.dao.member.IBoardAccessDao;
import com.nmom.soap.data.model.member.BoardAccessVo;

public class BoardAccessSvcImpl implements IBoardAccessSvc {
	
	IBoardAccessDao boardAccessDao;
	
	// DI
	public void setBoardAccessDao(IBoardAccessDao boardAccessDao) {
		this.boardAccessDao = boardAccessDao;
	}
	
	
	// Override Method
	@Override
	public BoardAccessVo getAdminAccess(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardAccessVo getMemberAccess(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardAccessVo getBlacklistAccess(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardAccessVo getNonmemberAccess(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardAccessVo getAccessNotice(int mem_level_cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardAccessVo getAccessEvent(int mem_level_cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardAccessVo getAccessQnA(int mem_level_cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardAccessVo getAccessFaQ(int mem_level_cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardAccessVo getAccessReview(int mem_level_cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardAccessVo getAccess(int board_no, String mem_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
