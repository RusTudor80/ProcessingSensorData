package activities;

public class MonitoredData {
    private String start_time;
    private String end_time;
    private String activity;
    
    public MonitoredData() {
    	super();
    	this.start_time = "";
		this.end_time = "";
		this.activity = "";
    }

    public MonitoredData(String start_time, String end_time, String activity) {
    	super();
		this.start_time = start_time;
		this.end_time = end_time;
		this.activity = activity;
	}
    
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
    public String toString()
    {
        return "Start time: " + this.getStart_time() + " End time: " + this.getEnd_time() + " Activity: " + getActivity() + "\n";
    }
}