package highway;

import java.time.LocalDate;

public class DateTime extends Date{
	private int hour, minute;
	private long epochMinutes;
	
	public DateTime(int yy, int mm, int dd, int h, int m) {
		super(yy, mm, dd);
		LocalDate currentDate = LocalDate.of(yy, mm, dd);
	    LocalDate baseDate = LocalDate.of(2023, 5, 12); // 기준일

	    if (currentDate.isBefore(baseDate)) {
	        throw new IllegalArgumentException("유효하지 않은 날짜입니다.");
	    }

	    if (isValid(yy, mm, dd, h, m)) {
	        hour = h;
	        minute = m;
	        epochMinutes = (getEpochDay() * 24 + hour) * 60 + minute;
	    } else {
	        throw new IllegalArgumentException("유효하지 않은 시간입니다.");
	    }
	}

	public DateTime(DateTime dt) {
		this(dt.getYear(), dt.getMonth(), dt.getDay(), dt.getHour(), dt.getMinute());
	}

	public int getHour() { return hour; }
	public int getMinute() { return minute; }
	public long getEpochMinutes() { return epochMinutes; }
	public DateTime getDatetime(DateTime dt)
	{
		return dt;
	}

	public void setDateTime(DateTime dt) {
		setDate(dt);
		hour = dt.getHour();
		minute = dt.getMinute();
		epochMinutes = dt.getEpochMinutes();
	}

	public long elapsedTime(DateTime dt) {
		long minutes = epochMinutes - dt.getEpochMinutes();
		return (minutes >= 0) ? minutes : -minutes;
	}

	public static boolean isValid(int yy, int mm, int dd, int h, int m) {
		if (h < 0 || h >= 24) return false;
		if (m < 0 || m >= 60) return false;
		return isValid(yy, mm, dd);
	}

	public static boolean isValid(DateTime dt) {
		return isValid(dt.getYear(), dt.getMonth(), dt.getDay(), dt.getHour(), dt.getMinute());
	}

	@Override
	public String toString() {
		return String.format("%d-%d-%d %d:%d", getYear(), getMonth(), getDay(), hour, minute);
	}

	public int compareTo(DateTime dt) {
		return (int)(epochMinutes - dt.getEpochMinutes());
	}

}
