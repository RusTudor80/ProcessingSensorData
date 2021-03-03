package activities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

public class Task5 {
	private LocalTime a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
	private long h, m, s;

	public Task5() {
			a1 = LocalTime.of(0, 0, 0);
			a2 = LocalTime.of(0, 0, 0);
			a3 = LocalTime.of(0, 0, 0);
			a4 = LocalTime.of(0, 0, 0);
			a5 = LocalTime.of(0, 0, 0);
			a6 = LocalTime.of(0, 0, 0);
			a7 = LocalTime.of(0, 0, 0);
			a8 = LocalTime.of(0, 0, 0);
			a9 = LocalTime.of(0, 0, 0);
			a10 = LocalTime.of(0, 0, 0);
	}

	public HashMap<String, LocalTime> time(List<MonitoredData> list) {
		PrintStream o;
		try {
			o = new PrintStream(new File("TASK_5.txt"));
			System.setOut(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		HashMap<String, LocalTime> map5 = new HashMap<String, LocalTime>();

		list.forEach(b -> {
			String activity = b.getActivity();
		
			String start_time = b.getStart_time();
            String[] start_format =  start_time.split(" ");
            String[] start_unit = start_format[1].split(":");
            
            LocalTime start_component = LocalTime.of(Integer.parseInt(start_unit[0]), Integer.parseInt(start_unit[1]), Integer.parseInt(start_unit[2]));

            String end_time = b.getEnd_time();
            String[] end_format = end_time.split(" ");
            String[] end_unit = end_format[1].split(":");
            
            LocalTime end_component = LocalTime.of(Integer.parseInt(end_unit[0]), Integer.parseInt(end_unit[1]), Integer.parseInt(end_unit[2]));
            
            h = Math.abs(ChronoUnit.HOURS.between(end_component, start_component));
            m =  Math.abs(ChronoUnit.MINUTES.between(end_component, start_component));
            s =  Math.abs(ChronoUnit.SECONDS.between(end_component, start_component));
            

			if (activity.equals("Leaving")) {
				//System.out.println("leaving " +h +  " " + m + " " + s + "	a1 : " + a1.format("hh:MM:dd"));
				a1 = a1.plusSeconds(s);
				a1 = a1.plusMinutes(m);
				a1 = a1.plusHours(h);
			}
			if (activity.equals("Toileting")) {
				a2 = a2.plusSeconds(s);
				a2 = a2.plusMinutes(m);
				a2 = a2.plusHours(h);
			}
			if (activity.equals("Showering")) {
				a3 = a3.plusSeconds(s);
				a3 = a3.plusMinutes(m);
				a3 = a3.plusHours(h);
			}
			if (activity.equals("Sleeping")) {
				a4 = a4.plusSeconds(s);
				a4 = a4.plusMinutes(m);
				a4 = a4.plusHours(h);
			}
			if (activity.equals("Breakfast")) {
				a5 = a5.plusSeconds(s);
				a5 = a5.plusMinutes(m);
				a5 = a5.plusHours(h);
			}
			if (activity.equals("Lunch")) {
				a6 = a6.plusSeconds(s);
				a6 = a6.plusMinutes(m);
				a6 = a6.plusHours(h);
			}
			if (activity.equals("Dinner")) {
				a7 = a7.plusSeconds(s);
				a7 = a7.plusMinutes(m);
				a7 = a7.plusHours(h);
			}
			if (activity.equals("Snack")) {
				a8 = a8.plusSeconds(s);
				a8 = a8.plusMinutes(m);
				a8 = a8.plusHours(h);
			}
			if (activity.equals("Spare_Time/TV")) {
				a9 = a9.plusSeconds(s);
				a9 = a9.plusMinutes(m);
				a9 = a9.plusHours(h);
				;
			}
			if (activity.equals("Grooming")) {
				a10 = a10.plusSeconds(s);
				a10 = a10.plusMinutes(m);
				a10 = a10.plusHours(h);
			}
		});
		
		map5.put("Leaving", a1);
		map5.put("Toileting", a2);
		map5.put("Showering", a3);
		map5.put("Sleeping", a4);
		map5.put("Breakfast", a5);
		map5.put("Lunch", a6);
		map5.put("Dinner", a7);
		map5.put("Snack", a8);
		map5.put("Spare_Time/TV", a9);
		map5.put("Grooming", a10);

		map5.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " : " + entry.getValue().getHour() + ":" + entry.getValue().getMinute() + ":" + entry.getValue().getSecond());
		});

		return map5;
	}
}
