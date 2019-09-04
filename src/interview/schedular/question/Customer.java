package interview.schedular.question;

import java.util.Random;

public class Customer {
	private int id;
	private int taskMinSec;
	private int taskMaxSec;
	
	public Customer(int id, int minsec, int maxsec) {
		this.id=id;
		this.taskMaxSec=maxsec;
		this.taskMinSec=minsec;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaskMinSec() {
		return taskMinSec;
	}

	public void setTaskMinSec(int taskMinSec) {
		this.taskMinSec = taskMinSec;
	}

	public int getTaskMaxSec() {
		return taskMaxSec;
	}

	public void setTaskMaxSec(int taskMaxSec) {
		this.taskMaxSec = taskMaxSec;
	}
	
	@Override
    public int hashCode() 
    { 
		return id;
    }
	
	@Override
    public boolean equals(Object o) { 
		
		if (!(o instanceof Customer)) { 
            return false; 
        } 
		if(this.id==(((Customer)o).getId()))
			return true;
		else 
			return false;
	}
	
	public Integer getTaskDuration() {
		Random random = new Random();
		return (this.taskMinSec+(random.nextInt(100)*(this.getTaskMaxSec()-this.getTaskMinSec()))/100);
	}

}
