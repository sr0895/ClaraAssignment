package interview.schedular.question;

import java.util.Date;

public class Task implements Comparable<Task> {
	private int id;
	private Integer custId;
	private Date insertedTime;
	
	//Constructor
	public Task(int taskId, int custId) {
		this.id=taskId;
		this.custId=custId;
		insertedTime=new Date();
	}
	
	//Setters and getters
	public Date getInsertedTime() {
		return insertedTime;
	}
	public void setInsertedTime(Date insertedTime) {
		this.insertedTime = insertedTime;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
    public int hashCode() 
    { 
		return id;
    }
	
	@Override
    public boolean equals(Object o) { 
		
		if (!(o instanceof Task)) { 
            return false; 
        } 
		if(this.id==((Task)o).id)
			return true;
		else 
			return false;
	}

	@Override
	public int compareTo(Task obj) {
		
		return this.insertedTime.compareTo(((Task)obj).getInsertedTime());
	}

}
