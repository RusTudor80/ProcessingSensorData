package activities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

public class Task3 {
	private int a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;

	public Task3() {
		a1 = a2 = a3 = a4 = a5 = a6 = a7 = a8 = a9 = a10 = 0;
	}

	public HashMap<String, Integer> count(List<MonitoredData> list) {
		PrintStream o;
		try {
			o = new PrintStream(new File("TASK_3.txt"));
			System.setOut(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		HashMap<String, Integer> map3 = new HashMap<String, Integer>();
		
		list.forEach(b -> {
			String str = b.getActivity();
			
			if(str.substring(0, Math.min(str.length(), 7)).equals("Leaving"))
	    			  { ++a1;  }
	    	if(str.substring(0, Math.min(str.length(), 9)).equals("Toileting"))
	    	     { ++a2;  }
	    	     if(str.substring(0, Math.min(str.length(), 9)).equals("Showering"))
	    	     { ++a3;  }
	    	     if(str.substring(0, Math.min(str.length(), 8)).equals("Sleeping"))
	    	     { ++a4;  }
	    	     if(str.substring(0, Math.min(str.length(), 9)).equals("Breakfast"))
	    	     { ++a5;  }
	    	     if(str.substring(0, Math.min(str.length(), 5)).equals("Lunch"))
	    	     { ++a6;  }
	    	     if(str.substring(0, Math.min(str.length(), 6)).equals("Dinner"))
	    	     { ++a7;  }
	    	     if(str.substring(0, Math.min(str.length(), 5)).equals("Snack"))
	    	     { ++a8;  }
	    	     if(str.substring(0, Math.min(str.length(), 13)).equals("Spare_Time/TV"))
	    	     { ++a9; ; }
	    	     if(str.substring(0, Math.min(str.length(), 8)).equals("Grooming"))
	    	     { ++a10;  }
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
		
		map3.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
		
		return map3;
	}
}
