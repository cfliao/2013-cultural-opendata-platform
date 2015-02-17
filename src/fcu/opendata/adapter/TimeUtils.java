package fcu.opendata.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {

	private static SimpleDateFormat sdf1 = null;
	private static SimpleDateFormat sdf2 = null;

	static {
		sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
		sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

	public static Date fromDateString(String pattern) throws ParseException {

		return sdf2.parse(pattern);

	}

	public static Date fromDateTimeString(String pattern) throws ParseException {

		return sdf1.parse(pattern);

	}
}
