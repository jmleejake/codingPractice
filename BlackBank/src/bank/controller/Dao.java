package bank.controller;

import java.sql.SQLException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import bank.model.account.AccountDao;
import bank.model.product.ProductDao;

public class Dao implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// 주기적으로 자동 수행되는 작업 호출		
		try {			
			AccountDao.setModifyAccOr();		// 보통예금 금리적용
			AccountDao.setModifyAccSa();		// 저축예금 금리적용
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}
}
