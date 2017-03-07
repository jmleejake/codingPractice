package bank.controller;

import java.sql.SQLException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import bank.model.account.AccountDao;
import bank.model.product.ProductDao;

public class Dao implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// �ֱ������� �ڵ� ����Ǵ� �۾� ȣ��		
		try {			
			AccountDao.setModifyAccOr();		// ���뿹�� �ݸ�����
			AccountDao.setModifyAccSa();		// ���࿹�� �ݸ�����
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}
}
