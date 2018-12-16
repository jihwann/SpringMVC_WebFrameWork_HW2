package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;

@Service
public class OfferService {

	@Autowired
	private OfferDAO offerDao;

	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}

	// 링크 따라가면 해당 연도와 학기에 대한 수강 내역 다 가져옴
	public List<Offer> getCurrent2(int year, int semester) {
		List<Offer> offer = offerDao.getOffers2(year, semester);
		return offer;
	}

	public void insert(Offer offer) {
		offerDao.insert(offer);

	}
	
	//2.총 이수 학점
	public List<Offer> getCounts() {
		List<Offer> offer = offerDao.getCounts();
		return offer;
	}

	// 수강 신청된 과목 반환
	public List<Offer> registeroffer() {
		return offerDao.registeroffer();
	}
	
	
}
