package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

@Component
@Aspect
public class ProfilingAspect {
	StopWatch stopWatch1 = new StopWatch();
	StopWatch stopWatch2 = new StopWatch();
	StopWatch stopWatch3 = new StopWatch();

	@Before(value = "execution (* place*(..))")
	public void beforeAdviceMethod(JoinPoint jp) {
		stopWatch1.start();
	}

	@After(value = "execution (* place*(..))")
	public void afterAdviceMethod(JoinPoint jp) throws Exception {
		Thread.sleep(1000);
		stopWatch1.stop();
		TaskInfo taskInfo = stopWatch1.getLastTaskInfo();
		System.out.println("Time taken for executing placeOrder() method: " + taskInfo.getTimeMillis() + " ms");
	}

	@Before(value = "execution (* cancel*(..))")
	public void beforeAdviceMethod2(JoinPoint jp) {
		stopWatch2.start();
	}

	@After(value = "execution (* cancel*(..))")
	public void afterAdviceMethod2(JoinPoint jp) throws Exception {
		Thread.sleep(2000);
		stopWatch2.stop();
		TaskInfo taskInfo = stopWatch2.getLastTaskInfo();
		System.out.println("Time taken for executing cancelOrder() method: " + taskInfo.getTimeMillis() + " ms");
	}

	@Before(value = "execution (* aop.Order.get*(..))")
	public void beforeAdviceMethod3(JoinPoint jp) {
		stopWatch3.start();
	}

	@After(value = "execution (* aop.Order.get*(..))")
	public void afterAdviceMethod3(JoinPoint jp) throws Exception {
		Thread.sleep(3000);
		stopWatch3.stop();
		TaskInfo taskInfo = stopWatch3.getLastTaskInfo();
		System.out.println("Time taken for executing getOrderStatus() method: " + taskInfo.getTimeMillis() + " ms");
	}
}
