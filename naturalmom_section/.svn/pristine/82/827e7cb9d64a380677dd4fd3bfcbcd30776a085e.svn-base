package com.nmom.soap.svc.board.review;

import java.util.List;

import com.nmom.soap.S;
import com.nmom.soap.data.dao.board.review.IVReview_AdminDao;
import com.nmom.soap.data.model.board.review.VReview_AdminVo;

public class VReview_AdminSvcImpl implements IVReview_AdminSvc 
{
	IVReview_AdminDao review_adminDao;
	
	public void setReview_adminDao(IVReview_AdminDao review_adminDao) 
	{
		this.review_adminDao = review_adminDao;
	}

	@Override
	public List<VReview_AdminVo> getAllList(int page)
	{
		return review_adminDao.getAllList(((page - 1) * S.PAGE_LIMIT) + 1, page * S.PAGE_LIMIT);
	}

	@Override
	public VReview_AdminVo getOneReview(int review_no) 
	{
		return review_adminDao.getOneReview(review_no);
	}
	
	@Override
	public VReview_AdminVo getOneReviewByR_num(int r_num) 
	{
		return review_adminDao.getOneReviewByR_num(r_num);
	}

	@Override
	public List<VReview_AdminVo> getReviews_by_title(String search, int page) 
	{
		return review_adminDao.getReviews_by_title(search, ((page - 1) * S.PAGE_LIMIT) + 1, page * S.PAGE_LIMIT);
	}

	@Override
	public List<VReview_AdminVo> getReviews_by_content(String search, int page) 
	{
		return review_adminDao.getReviews_by_content(search, ((page - 1) * S.PAGE_LIMIT) + 1, page * S.PAGE_LIMIT);
	}

	@Override
	public List<VReview_AdminVo> getReviews_by_id(String search, int page) 
	{
		return review_adminDao.getReviews_by_id(search, ((page - 1) * S.PAGE_LIMIT) + 1, page * S.PAGE_LIMIT);
	}

	@Override
	public List<VReview_AdminVo> getReviews_by_title_n_content(String search, int page) 
	{
		return review_adminDao.getReviews_by_title_n_content(search, ((page - 1) * S.PAGE_LIMIT) + 1, page * S.PAGE_LIMIT);
	}

	@Override
	public int getCountAllReviews() 
	{
		return review_adminDao.getCountAllReivews();
	}

	@Override
	public int getCountReviewsByTitle(String search) 
	{
		return review_adminDao.getCountReviewsByTitle(search);
	}

	@Override
	public int getCountReviewsByContent(String search) 
	{
		return review_adminDao.getCountReviewsByContent(search);
	}

	@Override
	public int getCountReviewsById(String search) 
	{
		return review_adminDao.getCountReviewsById(search);
	}

	@Override
	public int getCountReviewsByTitleNContent(String search) 
	{
		return review_adminDao.getCountReviewsByTitleNContent(search);
	}
}
