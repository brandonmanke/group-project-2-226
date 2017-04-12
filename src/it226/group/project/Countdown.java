package it226.group.project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown {

	public Countdown() {
		super();
	}

	Timer timer;
	Calendar calendar;

	ArrayList<Alarm> listOfAlarms = AlarmWriter.getList();

	public void runAlarm() {
		timer = new Timer();
		Alarm alarm;

		for (int i = 0; i < listOfAlarms.size(); i++) {

			alarm = listOfAlarms.get(i);

			calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-"));
			if (alarm.getTime() - calendar.getTimeInMillis() > 0) {

				System.out.println("alarm was set");
				timer.schedule(new TimerTask() {

					@Override
					public void run() {
						System.out.println("alarm fired");

					}

				}, alarm.getTime() - calendar.getTimeInMillis());
			} else {
				listOfAlarms.remove(i);
				System.out.println("removed alarm");
			}
		}

	}

}
