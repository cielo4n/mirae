package com.nmom.soap.svc.board.event;

import java.util.List;

import com.nmom.soap.data.dao.board.event.IEvent_reDao;
import com.nmom.soap.data.model.board.event.Event_reVo;

public class Event_reSvcImpl implements IEvent_reSvc {
	
	IEvent_reDao eventReDao;
	
	// DI
	public void setEventReDao(IEvent_reDao eventReDao) {
		this.eventReDao = eventReDao;
	}
	
	

	// Override Method
	@Override
	public List<Event_reVo> getEventRe(int event_no) {
		return eventReDao.getEventRe(event_no);
	}
	
	@Override
	public Event_reVo getOneRe(int event_re_no) {
		return eventReDao.getOneRe(event_re_no);
	}

	@Override
	public int addRe(Event_reVo re) {
		return eventReDao.addRe(re);
	}

	@Override
	public int removeRe(int event_re_no) {
		return eventReDao.removeRe(event_re_no);
	}

}
