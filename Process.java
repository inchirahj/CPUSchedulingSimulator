
public class Process
{
  private int id;
	private int arrivalTime;
	private int completionTime;
	private int runningTime;
  private int firstRun;

  public Process(int id, int at, int rt)
  {
    this.id = id;
    this.arrivalTime = at;
    this.runningTime = rt;
  }

  public int getId(){
    return this.id;
  }

  public void setId(int id){
    this.id = id;
  }
	
	public int getArrivalTime(){
		return this.arrivalTime; 
	}

  public void setArrivalTime(int at){
    arrivalTime = at;
  }
	
	public int getRunningTime(){
		return this.runningTime;
	}

  public void setRunningTime(int rt){
		runningTime = rt;
	}
	
	public int getCompletionTime(){
		return this.completionTime; 
	}
	
	public void setCompletionTime(int ct){
		completionTime = ct;
	}

  public int getFirstRun(){
		return this.firstRun; 
	}
	
	public void setFirstRun(int fr){
		firstRun = fr;
	}
	
}