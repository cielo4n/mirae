package com.nmom.soap.svc.board.faq;

import java.util.List;

import com.nmom.soap.data.dao.board.faq.IFaqDao;
import com.nmom.soap.data.model.board.faq.FaqVo;

public class FaqSvcImpl implements IFaqSvc{
	
	IFaqDao faqDao;
	
	public void setFaqDao(IFaqDao faqDao) {
		this.faqDao = faqDao;
	}

	@Override
	public FaqVo getOneFaq(int faq_no) {
		return faqDao.getOneFaq(faq_no);
	}

	@Override
	public List<FaqVo> getAllFaq(int start, int end) {
		return faqDao.getAllFaq(start, end);
	}

	@Override
	public List<FaqVo> searchFaqTitle(String keyword, int start, int end) {
		return faqDao.searchFaqTitle(keyword, start, end);
	}

	@Override
	public List<FaqVo> searchFaqContent(String keyword, int start, int end) {
		return faqDao.searchFaqContent(keyword, start, end);
	}

	@Override
	public List<FaqVo> searchFaqTitleNContent(String keyword, int start, int end) {
		return faqDao.searchFaqTitleNContent(keyword, start, end);
	}

	@Override
	public int addFaq(FaqVo faq) {
		return faqDao.addFaq(faq);
	}

	@Override
	public int addFaq(String faq_title, String faq_content, String mem_id) {
		return faqDao.addFaq(faq_title, faq_content, mem_id);
	}

	@Override
	public int editFaq(FaqVo faq) {
		return faqDao.editFaq(faq);
	}

	@Override
	public int editFaq(String faq_title, String faq_content, int faq_no) {
		return faqDao.editFaq(faq_title, faq_content, faq_no);
	}

	@Override
	public int removeFaq(FaqVo faq) {
		return faqDao.removeFaq(faq);
	}

	@Override
	public int removeFaq(int faq_no) {
		return faqDao.removeFaq(faq_no);
	}

	@Override
	public int getFaqCount() {
		return faqDao.getFaqCount();
	}

	@Override
	public int getSearchFaqTitleCount(String keyword) {
		return faqDao.getSearchFaqTitleCount(keyword);
	}

	@Override
	public int getSearchFaqContentCount(String keyword) {
		return faqDao.getSearchFaqContentCount(keyword);
	}

	@Override
	public int getSearchFaqTitleNContentCount(String keyword) {
		return faqDao.getSearchFaqTitleNContentCount(keyword);
	}

}
