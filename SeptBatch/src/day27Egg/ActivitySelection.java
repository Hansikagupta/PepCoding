package day27Egg;

import java.util.Arrays;

public class ActivitySelection  {
	
	
	private static class Activity implements Comparable<Activity> {
		int start;
		int end;

		Activity(int a, int b) {
			start = a;
			end = b;
		}

	

		@Override
		public int compareTo(Activity o) {
			return this.end - o.end;
		}
		
		

	}

	public static void main(String[] args) {
		int[] start = {3, 0, 1, 8, 5 ,5 };
		int[] end = {4, 6, 2, 9, 9, 7};
		activitySelection(start, end);

	}

	public static int activitySelection(int[] start, int[] end) {
		Activity[] activities = new Activity[end.length];
		for (int i = 0; i < end.length; i++) {
			activities[i] = new Activity(start[i], end[i]);
		}
		Arrays.sort(activities);
		int last = 0, count = 1;
		for(int i = 1; i < activities.length; i++) {
			if(activities[i].start > activities[last].end) {
				last = i;
				count++;
			}
		}
		System.out.println(count);
		return count;
	}

}
