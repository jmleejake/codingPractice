package global.sesoc.web5.customer.dao;

import global.sesoc.web5.customer.vo.CustomerVO;

public interface ICustomerMapper {
	public int insertCustomer(CustomerVO vo);
	public CustomerVO selectCustomer(String custid);
	public int updateCustomer(CustomerVO vo);
}
