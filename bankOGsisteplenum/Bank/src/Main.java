package src;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.sql.Timestamp;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Date d = new Date();
		Account a = new Account(new Timestamp(d.getTime()));
		CountDownLatch c = new CountDownLatch(10);
		Bill[] b = new Bill[5];
		
		for(int i = 0; i < 5; i++){
			d = new Date();
			Thread.sleep(1000);
			b[i] = new Bill(a, new Timestamp(d.getTime()), c, i);
		}
		
		for(int i = 0; i < 5; i++){
			b[i].start();
		}
		c.await();
	}

}
