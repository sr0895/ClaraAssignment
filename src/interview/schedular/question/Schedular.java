package interview.schedular.question;
import java.util.*;

public class Schedular {
	
	private static final Integer MAX_TASKS_PROCESSING = 100;
	private static Schedular schedularfifo=null;
	private Map<Integer,Customer> custMap=new HashMap();
	private TreeSet<Task> processinglist=new TreeSet();
	private ArrayList<Task> todolist=new ArrayList();
	

	
	public Schedular(ArrayList<Customer> custlist,ArrayList<Task> taskli) {
		addCustToMap(custlist);
		addTaskToProcessingList(taskli);
		
	}
	
	
	//Adding customer to the map
	private void addCustToMap(ArrayList<Customer> custlist) {
		for(int i=0;i<custlist.size();i++) {
			if(custMap.containsKey((custlist.get(i)).getId()))
				System.out.println("Customer already present in the map");
			else {
				custMap.put((custlist.get(i)).getId(),(custlist.get(i)));
			}
		}
		
	}
	
	private void addTaskToProcessingList(ArrayList<Task> todo) {
		for(int i=0;i<todo.size();i++) {
			processinglist.add(todo.get(i));
		}
		
	}
	public void addTaskTodolist(Task task) {
		todolist.add(task);
	}
	
	
	public void executeTask() {
		Integer task_interval;
		Task temp;
//		for(int i=0;i<processinglist.size();i++) {
		while(!processinglist.isEmpty()){
				temp=processinglist.first();
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
			//todo exxcute the task
		}
		
	}
	
	
	
	
	
	

}
