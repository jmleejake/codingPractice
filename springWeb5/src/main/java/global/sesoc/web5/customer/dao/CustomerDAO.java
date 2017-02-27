package global.sesoc.web5.customer.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web5.customer.vo.CustomerVO;

/**
 * 회원관련 DB처리
 * @author kita
 *
 */
@Repository
public class CustomerDAO {
	@Autowired
	SqlSession sqlSession;
	
	Logger log = LoggerFactory.getLogger(CustomerDAO.class);
	
	public int insertCustomer(CustomerVO vo) {
		log.debug("insertCustomer :: \n{}", vo);
		ICustomerMapper mapper = sqlSession.getMapper(ICustomerMapper.class);
		return mapper.insertCustomer(vo);
	}
	
	public CustomerVO selectCustomer(String custid) {
		log.debug("selectCustomer :: {}", custid);
		ICustomerMapper mapper = sqlSession.getMapper(ICustomerMapper.class);
		return mapper.selectCustomer(custid);
	}
	
	public int updateCustomer(CustomerVO vo) {
		log.debug("updateCustomer :: \n{}", vo);
		ICustomerMapper mapper = sqlSession.getMapper(ICustomerMapper.class);
		return mapper.updateCustomer(vo);
	}
}
