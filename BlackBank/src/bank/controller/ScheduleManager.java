package bank.controller;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class ScheduleManager {

	private Scheduler sched = null;
	// 스케쥴러 객체 생성
	public void start() {
		try {
			SchedulerFactory schedFact = new StdSchedulerFactory();
			sched = schedFact.getScheduler();
			sched.start();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void boundJobList() {
		try {			
			JobDetail oneJob = new JobDetail("group1", "jobName", Dao.class);
			CronTrigger oneTrgr = new CronTrigger("trgrGroup", "trgrName");
			
			//oneTrgr.setCronExpression("00 00 00 1 1-12 SUN-SAT");//초 분 시 일 월 요일 년도

			oneTrgr.setCronExpression("00 20 4 ? * *");
			sched.scheduleJob(oneJob, oneTrgr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
