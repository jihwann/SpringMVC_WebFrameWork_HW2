package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

// HomeController와 OfferController 모두 @Controller anotation이 있기 때문에, 2개의 bean을 등록함.
@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;
	
	// 모두 조회 
//	@RequestMapping("/oldsemester")
//	public String showOffers(Model model) {
//		List<Offer> offers = offerService.getCurrent();
//		model.addAttribute("subject", offers);
//		
//		return "oldsemester";
//	}
	
	// 학기별 학점 조회 --> 과거 && 현재
	@RequestMapping("/oldsemester")
	public String getCount(Model model) {
		List<Offer> offers = offerService.getCounts();
		model.addAttribute("subject", offers);
		return "oldsemester";
	}
	
	
	// 링크 들어가면 세부 항목 보여주기
		@RequestMapping("/detail")
		public String showdetail(Model model, Integer year, Integer semester) {
			List<Offer> offer = offerService.getCurrent2(year, semester);
			model.addAttribute("year",year);
			model.addAttribute("semester",semester);
			model.addAttribute("subject", offer);
			return "detail";
		}
	
	
	// 수강신청
	@RequestMapping("/createoffer")
	public String createoffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}
	// 수강신청 -> 수행
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		
		if(result.hasErrors()) { // 에러가 없으면 db에 저장해라
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}
		
		//System.out.println(offer);
		
		offerService.insert(offer); // db에 저장하는 동작
		return "home";
	}
	
	
	//수강신청 조회 메뉴
		@RequestMapping("/offers")
		public String showthisclass(Model model) {
			List<Offer> registeroffer = offerService.registeroffer();
			model.addAttribute("subject", registeroffer);
			return "offers";
		}
		
		
	
}
