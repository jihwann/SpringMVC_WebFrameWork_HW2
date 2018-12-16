package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor // 인자가 업는 생성자 만들어주기
@ToString
public class Offer {
	
	private int id;
	private int year;
	private int semester;
	private String code;
	private String name;
	private String classify;
	private int point;
	
}
