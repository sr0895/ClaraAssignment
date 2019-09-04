package interview.schedular.question;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SchedularRoundRobin {
	private static final Integer MAX_TASKS_PROCESSING = 100;
	private Map<Integer,Customer> custMap=new HashMap();
	private Map<Integer,TreeSet<Task>> taskmap=new HashMap();
	private ArrayList<Task> processinglist=new ArrayList();
	private ArrayList<Task> todolist=new ArrayList();
	private ArrayList<Integer> custId= new ArrayList();
	
	private void addCustToMap(ArrayList<Customer> custlist) {
		for(int i=0;i<custlist.size();i++) {
			if(custMap.containsKey((custlist.get(i)).getId()))
				System.out.println("Customer already present in the map");
			else {
				custMap.put((custlist.get(i)).getId(),(custlist.get(i)));
				custId.add((custlist.get(i)).getId());
			}
		}
		
	}
	
	public SchedularRoundRobin(ArrayList<Customer> custlist,ArrayList<Task> task) {
		addCustToMap(custlist);
		addToTaskMap(task);
		addTaskToProcessingList();
	}
	
	
	
	private void addTaskToProcessingList() {
		
		while(!taskmap.isEmpty()) {
			for(int i=0;i<custId.size();i++) {
				Integer task_interval;
				Integer cust_id=custId.get(i);
				if(taskmap.containsKey(cust_id)) {
					if(taskmap.get(cust_id).isEmpty()) {
						taskmap.remove(cust_id);
					}else {
						TreeSet ts=taskmap.get(cust_id);
						Task temp=taskmap.get(cust_id).first();
						ts.remove(temp);
						taskmap.put(cust_id, ts);
						processinglist.add(temp);
						
					}
				}
			}
		}
		
	}
	
	private void addToTaskMap(ArrayList<Task> todo) {
		TreeSet<Task> temp;
		Integer Cust_id;
		Task curr_task;
		for(int i=0;i<todo.size();i++) {
			curr_task=todo.get(i);
			Cust_id=curr_task.getCustId();
			if(taskmap.containsKey(Cust_id)) {
				temp=taskmap.get(Cust_id);
				temp.add(curr_task);
				taskmap.put(Cust_id, temp);
			}else {
				temp=new TreeSet();
				temp.add(curr_task);
				taskmap.put(Cust_id, temp);
			}
			
		}
		
	}
	
	
	public void addTaskTodolist(Task task) {
		todolist.add(task);
	}
	
	public void executeTask() {
		Integer task_interval;
		Task temp;
		//int i=0;
		//for(int i=0;i<processinglist.size();i++) {
		while(!processinglist.isEmpty()){
				temp=processinglist.get(0);
				task_interval=(custMap.get(temp.getCustId())).getTaskDuration();
				System.out.println("Started Task Excution with id "+temp.getId()+ " for customer with id "+temp.getCustId());
				try {
					Thread.sleep(task_interval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Complted Task Excution with id "+temp.getId()+ " for customer with id "+temp.getCustId());
				processinglist.remove(temp);
				temp.setInsertedTime(new Date());
				addTaskTodolist(temp);
				//i++;
			
		}
		
	}
	
	
	
	

}
