package activities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
	private int distinctDays;
	private int ok;

	public void count(List<MonitoredData> list) {
		PrintStream o;
		try {
			o = new PrintStream(new File("TASK_2.txt"));
			System.setOut(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List<String> l = new ArrayList<String>();
		list.forEach(b -> {
			String str = b.getStart_time();
			String s = str.substring(0, Math.min(str.length(), 10));
			ok = 0;
			l.forEach(a -> {
				if (a.equals(s)) {
					ok++;
				}
			});
			if (ok == 0) {
				this.distinctDays++;
				l.add(s);
			}
		});
		System.out.println(this.distinctDays);
		System.out.println();
	}

	public int getDistinctDays() {
		return this.distinctDays;
	}
}
