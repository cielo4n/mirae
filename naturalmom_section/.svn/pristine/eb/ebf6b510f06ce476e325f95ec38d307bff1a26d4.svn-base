package com.nmom.soap.svc.board.review;

import java.util.List;

import com.nmom.soap.S;
import com.nmom.soap.data.dao.board.review.IReview_ReDao;
import com.nmom.soap.data.model.board.review.ReviewVo;
import com.nmom.soap.data.model.board.review.Review_ReVo;

public class Review_ReSvcImpl implements IReview_ReSvc 
{
	IReview_ReDao review_reDao;

	public void setReview_reDao(IReview_ReDao review_reDao) 
	{
		this.review_reDao = review_reDao;
	}
	
	@Override
	public List<Review_ReVo> getAllRe(int review_no) 
	{
		return review_reDao.getAllRe(review_no);
	}

	@Override
	public int addRe(Review_ReVo re) 
	{
		int result = review_reDao.addRe(re);
		
		if (result == 1)
			return S.PROCESS_SUCCESS;
		if (result == 0)
			return S.PROCESS_NO_RESULT;
		else
			return S.PROCESS_ERROR;
	}

	@Override
	public int editRe(Review_ReVo re) 
	{
		int result = review_reDao.editRe(re);
		
		if (result == 1)
			return S.PROCESS_SUCCESS;
		if (result == 0)
			return S.PROCESS_NO_RESULT;
		else
			return S.PROCESS_ERROR;
	}

	@Override
	public int removeRe(int review_re_no) 
	{
		int result = review_reDao.removeRe(review_re_no);
		
		if (result == 1)
			return S.PROCESS_SUCCESS;
		if (result == 0)
			return S.PROCESS_NO_RESULT;
		else
			return S.PROCESS_ERROR;
	}

	@Override
	public int getRvwNoOfRe(int review_re_no)
	{
		return review_reDao.getRvwNoOfRe(review_re_no);
	}

	@Override
	public Review_ReVo getOneReply(int review_re_no)
	{
		return review_reDao.getOneReply(review_re_no);
	}
	
}
