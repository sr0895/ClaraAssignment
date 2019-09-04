package interview.schedular.question;

import java.util.ArrayList;

public class Executor {

	public static void main(String[] args) {
		//Stubs create task and customer
		ArrayList<Customer> custlist=new ArrayList(3);
		ArrayList<Task> tasklist=new ArrayList(6);
		//Customer stub
		Customer cust=new Customer(1,100,200);
		custlist.add(cust);
		cust=new Customer(2,400,500);
		custlist.add(cust);
		cust=new Customer(3,600,800);
		custlist.add(cust);
		
		try {
		//Task Stub
		Task tasktemp=new Task(4,1);
		Thread.sleep(50);
		tasklist.add(tasktemp);
		tasktemp=new Task(5,1);
		Thread.sleep(50);
		tasklist.add(tasktemp);
		tasktemp=new Task(6,2);
		Thread.sleep(50);
		tasklist.add(tasktemp);
		tasktemp=new Task(7,2);
		Thread.sleep(50);
		tasklist.add(tasktemp);
		tasktemp=new Task(8,3);
		Thread.sleep(50);
		tasklist.add(tasktemp);
		tasktemp=new Task(9,3);
		Thread.sleep(50);
		tasklist.add(tasktemp);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Fifo implementaion
		System.out.println("**************FIFO Algorithm**************");
		Schedular fifo=new Schedular(custlist,tasklist);
		fifo.executeTask();
		
		
		//RoundRobin
		System.out.println("**************RoundRobin Algorithm**************");
		SchedularRoundRobin roundrobin=new SchedularRoundRobin(custlist,tasklist);
		
		roundrobin.executeTask();
	}

}
