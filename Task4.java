package activities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task4 {
	private int a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
	private int ok;
	private int noDay, temp;

	public Task4() {
		a1 = a2 = a3 = a4 = a5 = a6 = a7 = a8 = a9 = a10 = noDay = 0;
	}

	public HashMap<Integer, HashMap<String, Integer>> count(List<MonitoredData> list) {
		PrintStream o;
		try {
			o = new PrintStream(new File("TASK_4.txt"));
			System.setOut(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		HashMap<Integer, HashMap<String, Integer>> map4 = new HashMap<Integer, HashMap<String, Integer>>();
		List<String> l = new ArrayList<String>();

		list.forEach(b -> {
			String str = b.getStart_time();
			String day = str.substring(0, Math.min(str.length(), 10));
			ok= 0;
			

			l.forEach(a -> {
				if (a.equals(day)) {
					ok++;
					
					
				}
			});
			
			HashMap<String, Integer> map3;
			if (ok == 0) {
				l.add(day);
				++noDay;
			
				a1 = a2 = a3 = a4 = a5 = a6 = a7 = a8 = a9 = a10 = 0;
				map3 = new HashMap<String, Integer>();
				
				list.forEach(a -> {
					String str1 = a.getStart_time();
					String day1 = str1.substring(0, Math.min(str.length(), 10));
					String activity =a.getActivity();
					
					if (day1.equals(day)) {
						if (activity.equals("Leaving")) {
							++a1;
						}
						if (activity.equals("Toileting")) {
							++a2;
						}
						if (activity.equals("Showering")) {
							++a3;
						}
						if (activity.equals("Sleeping")) {
							++a4;
						}
						if (activity.equals("Breakfast")) {
							++a5;
						}
						if (activity.equals("Lunch")) {
							++a6;
						}
						if (activity.equals("Dinner")) {
							++a7;
						}
						if (activity.equals("Snack")) {
							++a8;
						}
						if (activity.equals("Spare_Time/TV")) {
							++a9;
							;
						}
						if (activity.equals("Grooming")) {
							++a10;
							}
							
					}
				});
		
				map3.put("Leaving", a1);
				map3.put("Toileting", a2);
				map3.put("Showering", a3);
				map3.put("Sleeping", a4);
				map3.put("Breakfast", a5);
				map3.put("Lunch", a6);
				map3.put("Dinner", a7);
				map3.put("Snack", a8);
				map3.put("Spare_Time/TV", a9);
				map3.put("Grooming", a10);
				

				map4.put(noDay, map3);
			}
		});
temp = 0;
		map4.entrySet().forEach(entry -> {
			System.out.print(entry.getKey() + " : " + l.get(temp++) + " : {");
			
			entry.getValue().entrySet().forEach(x -> {
				System.out.print(x.getKey() + " : " + x.getValue() + "	");
			});
			System.out.println(" } ");
		});

		return map4;
	}
}
