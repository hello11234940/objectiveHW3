package highway;

import java.time.LocalDate;

public class DateTime extends Date implements Comparable<DateTime>{
	public int hour;
	public int minute;
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

	public boolean isAfter(DateTime previousTime) {
	    if (this.year > previousTime.year) {
	        return true;
	    } else if (this.year == previousTime.year) {
	        if (this.month > previousTime.month) {
	            return true;
	        } else if (this.month == previousTime.month) {
	            if (this.day > previousTime.day) {
	                return true;
	            } else if (this.day == previousTime.day) {
	                if (this.hour > previousTime.hour) {
	                    return true;
	                } else if (this.hour == previousTime.hour) {
	                    return this.minute > previousTime.minute;
	                }
	            }
	        }
	    }
	    return false;
	}
	 public void addHours(int hours) {
	        this.hour += hours;

	        // If the added hours exceed 24, adjust the day and hour values accordingly
	        while(this.hour >= 24) {
	            this.hour -= 24;
	            this.day++;
	            // If the added days exceed the days in the current month, adjust the month and day values accordingly
	            // Note: This is a simplified version that assumes 30 days in a month
	            if(this.day > 30) {
	                this.day -= 30;
	                this.month++;

	                if(this.month > 12) {
	                    this.month -= 12;
	                    this.year++;
	                }
	            }
	        }
	    }
	 public void addMinutes(int minutesToAdd) {
		    int totalMinutes = this.minute + minutesToAdd;


		    this.hour += totalMinutes / 60;

		    this.minute = totalMinutes % 60;


		    if(this.hour >= 24) {
		        this.day += this.hour / 24;
		        this.hour = this.hour % 24;
		    }


		    if(this.day > 30) {
		        this.month += this.day / 30;
		        this.day = this.day % 30;
		    }

		    // Add years for every 12 months
		    if(this.month > 12) {
		        this.year += this.month / 12;
		        this.month = this.month % 12;
		    }
		}
}
