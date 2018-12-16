package kr.ac.hansung.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
//ㄴ DataSource : JdbcTemplate를 받아서 의존성 주입으로 주입을 시킴 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
// @Component 해주면 OfferDAO를 bean으로 등록하겠다는 것임. id는 offerDAO
// 어떤 패키지를 스캔하는지 명시하는 작업이 필요하다.
// <context:component-scan base-package="kr.ac.hansung.csemal"></context:component-scan>
// 해줘야 됨.
public class OfferDAO {
	private JdbcTemplate jdbcTemplate;
	
	// beans.xml에 <property name="dataSource" ref="dataSource"></property>
	// 를 제거해줘도 됨 --> @Autowired 사용하면. 주입시켜줬기 때문
	
	// anotation 기능 활성화 해야 됨.
	@Autowired
	public void setDataSource(DataSource dataSource) { // dataSource 가 자동으로 주입됨., anotation 기능 활성화 해야됨.
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from subject";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	
	//query and return multiple object
	//모든 수강된 이수과목 다 가져오기
		public List<Offer> getOffers() {
			String sqlStatment = "select * from subject"; // ?는 placeholder
			return jdbcTemplate.query(sqlStatment,  
					new RowMapper<Offer>(){ // 인터페이스를 익명클래스로 구현함.
						@Override
						public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
							Offer offer = new Offer();
							offer.setYear(rs.getInt("year"));
							offer.setSemester(rs.getInt("semester"));
							offer.setPoint(rs.getInt("point"));
							return offer;
						}
					}
				);
		}
		
		// 1. 년도, 학기에 맞는 이수과목만 가져오기   : 2를 위한 것.
		public List<Offer> getOffers2(int year, int semester) {
			String sqlStatement = "select * from subject where year=? and semester=? ";
			List<Offer> offer = jdbcTemplate.query(sqlStatement, new Object[]{year, semester}, new OfferMapper());
			return offer;
		}
		
		
		//2. 2019년도 등록된 과목 조회 
		public List<Offer> registeroffer() {
			String sqlStatement = "select * from subject where year=2019";
			return jdbcTemplate.query(sqlStatement, new OfferMapper());
		}
		
		public  List<Offer> getCounts(){
			String sqlStatement = "select year, semester, sum(point) from subject group by year, semester";
			List<Offer> offers=jdbcTemplate.query(sqlStatement,new RowMapper<Offer>(){
				@Override
				public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
					Offer offer=new Offer();
					offer.setYear(rs.getInt("year"));
					offer.setSemester(rs.getInt("semester"));
					offer.setPoint(rs.getInt("sum(point)"));
					
					return offer;
				}
			} );
			return offers;
		}
		
		
		public boolean update(Offer offer) {
			int id = offer.getId();
			int year = offer.getYear();
			int semester = offer.getSemester();
			String code = offer.getCode();
			String name = offer.getName();
			String classify = offer.getClassify();
			int point = offer.getPoint();
			
			String sqlStatement = "update subject set year=?,semester=?, code=?, name=?, classify=?,point=? where id=?";
			
			return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, classify, point}, id) == 1);
		}
		
		public boolean insert(Offer offer) {
			int year = offer.getYear();
			int semester = offer.getSemester();
			String code = offer.getCode();
			String name = offer.getName();
			String classify = offer.getClassify();
			int point = offer.getPoint();
			
			String sqlStatement = "insert into subject (year, semester, code, name, classify, point) values (?,?,?,?,?,?)";
			
			return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, classify, point})==1);
		}
		
		public boolean delete(int id) {
			String sqlStatement = "delete from subject where id=?";
			return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
		}

		
		
		
	
}
