package greedy;

import java.util.Arrays;

class Activity implements Comparable<Activity> {
	public Activity(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	int start;
	int end;

	public int compareTo(Activity o) {
		if (this.end > o.end)
			return 1;
		if (this.end < o.end)
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return " {" + start + "," + end + "} ";
	}
}

public class ActivitySelection {

	public static void main(String[] args) {
		Activity list[] = new Activity[6];
		list[0] = new Activity(1, 2);
		list[1] = new Activity(3, 4);
		list[2] = new Activity(0, 6);
		list[3] = new Activity(5, 7);
		list[4] = new Activity(8, 9);
		list[5] = new Activity(9, 9);

		selectActivities(list);

	}

	static void selectActivities(Activity list[]) {
		Arrays.sort(list);
		Activity start = list[0];
		System.out.print(start);

		for (int i = 1; i < list.length; i++) {
			if (list[i].start > start.end) {
				start = list[i];
				System.out.print(start);
			}
		}
	}

}
