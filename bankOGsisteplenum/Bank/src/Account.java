package src;

import java.sql.Timestamp;

public class Account {
	private long balance = 10000;
	private Timestamp time;
	
	Account(Timestamp t){
		time = t;
	}
	
	public synchronized void insertion(long money){
		balance += money;
	}
	
	public long getBalance(){
		return balance;
	}
	
	public synchronized boolean withdrawal(long money, Timestamp t){
		//System.out.println(time.getTime() +  "  <   " + t.getTime() );
		if(time.after(t)){
			System.out.println("Too late bro");
			return false;
		}
		time = t;
		notifyAll();
		balance -= money;
		return true;
	}
}
