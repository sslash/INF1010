package src;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Bill extends Thread{
	Account acc;
	Timestamp time;
	Random r;
	CountDownLatch c;
	int nr;
	
	Bill(Account acc, Timestamp t, CountDownLatch c, int nr){
		this.acc = acc;
		time = t;
		r = new Random();
		this.c = c;
		this.nr = nr;
	}
	
	public void run() {
		long withdraw = (long) r.nextInt(1000);
		try {
			Thread.sleep(r.nextInt(1000) + 500);
		} catch (InterruptedException e) {}
		boolean worked = false;
		while(!worked){
			System.out.print(nr + "tries to withdraw");
			worked = acc.withdrawal(withdraw, time);
			if(!worked)
				getNewTimestamp();
		}
		System.out.println(withdraw);
		c.countDown();
	}

	public void getNewTimestamp(){
		Date d = new Date();
		time = new Timestamp(d.getTime());	
	}
}
