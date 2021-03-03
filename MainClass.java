package activities;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class MainClass {
	private static Task1 r;
	private static Task2 t2;
	private static Task3 t3;
	private static Task4 t4;
	private static Task5 t5;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> map3 = new HashMap<String, Integer>();
		HashMap<Integer, HashMap<String, Integer>> map4 = new HashMap<Integer, HashMap<String, Integer>>();
		HashMap<String, LocalTime> map5 = new HashMap<String, LocalTime>();
		List<String> list1 = new ArrayList<String>();
	
		r = new Task1();
		r.read();
		List<MonitoredData> list = r.getData();
		
		FileWriter display1 = new FileWriter("TASK_1.txt");
		for (MonitoredData temp : list) {
			display1.append(temp.toString());
		}
		display1.close();
		
		t2 = new Task2();
		t2.count(list);
	
		t3 = new Task3();
		map3 = t3.count(list);
	
		t4 = new Task4();
		map4 = t4.count(list);
		
		t5 = new Task5();
		map5 = t5.time(list);
	}

}
