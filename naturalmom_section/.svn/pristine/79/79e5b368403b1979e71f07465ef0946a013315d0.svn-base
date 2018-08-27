package com.nmom.soap.svc.board.review;

import com.nmom.soap.S;
import com.nmom.soap.data.dao.board.review.IReviewDao;
import com.nmom.soap.data.model.board.review.ReviewVo;

public class ReviewSvcImpl implements IReviewSvc 
{
	IReviewDao reviewDao;
	
	public void setReviewDao(IReviewDao reviewDao)
	{
		this.reviewDao = reviewDao;
	}

	@Override
	public ReviewVo getOneReview(int review_no)
	{
		return reviewDao.getOneReview(review_no);
	}

	@Override
	public int addReview(ReviewVo review)
	{
		int result = reviewDao.addReview(review);

		if (result == 1)
			return S.PROCESS_SUCCESS;
		if (result == 0)
			return S.PROCESS_NO_RESULT;
		else
			return S.PROCESS_ERROR;
	}

	@Override
	public int editReview(ReviewVo review) 
	{
		int result = reviewDao.editReview(review);

		if (result == 1)
			return S.PROCESS_SUCCESS;
		if (result == 0)
			return S.PROCESS_NO_RESULT;
		else
			return S.PROCESS_ERROR;
	}

	@Override
	public int removeReview(int review_no) 
	{
		int result = reviewDao.removeReview(review_no);

		if (result == 1)
			return S.PROCESS_SUCCESS;
		if (result == 0)
			return S.PROCESS_NO_RESULT;
		else
			return S.PROCESS_ERROR;
	}

	@Override
	public int updateReviewCount(ReviewVo review) 
	{
		int result = reviewDao.updateCountReview(review);
		
		if (result == 1)
		{
			review.setRvw_hits(review.getRvw_hits() + 1);
			return S.PROCESS_SUCCESS;
		}
		if (result == 0)
			return S.PROCESS_NO_RESULT;
		else
			return S.PROCESS_ERROR;
	}

}
