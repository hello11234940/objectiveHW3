package highway;

import java.time.LocalDate;

public class Date {
	public int year;
	public int month;
	public int day;
	protected long epochDay;
	private static final LocalDate BASE_DATE = LocalDate.of(2023, 5, 12);

	
    public Date(int yy, int mm, int dd) {
        if (isValid(yy, mm, dd)) {
            year = yy;
            month = mm;
            day = dd;

            LocalDate date = LocalDate.of(year, month, day);
            epochDay = date.toEpochDay() - BASE_DATE.toEpochDay();
        } else {
            // 유효하지 않은 날짜에 대한 예외 처리
            throw new IllegalArgumentException("유효하지 않은 날짜입니다.");
        }
    }
    public static int daysInMonth(int month, int year) {
        if (month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                return 29; // Leap year
            } else {
                return 28; // Non-leap year
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30; // Months with 30 days
        } else {
            return 31; // Months with 31 days
        }
    }
	public Date(Date d) {
		this(d.getYear(), d.getMonth(), d.getDay());
	}

	public int getYear() { return year; }
	public int getMonth() { return month; }
	public int getDay() { return day; }
	public long getEpochDay() { return epochDay; }

	public void setDate(Date d) {
		year = d.getYear();
		month = d.getMonth();
		day = d.getDay();
		epochDay = d.getEpochDay();
	}

	public long elapsedDay(Date d) {
		long day = epochDay - d.getEpochDay();
		return (day >= 0) ? day : -day;
	}

	public static boolean isLeapYear(int y) {
		return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
	}

	public static boolean isValid(int yy, int mm, int dd) {
		if (yy < 1) return false;
		if (mm < 1 || mm > 12) return false;
		if (dd < 1) return false;
		int lastDay = 31;
		switch (mm) {
			case 2:
				lastDay = isLeapYear(yy) ? 29 : 28;
				break;

			case 4: case 6: case 9: case 11:
				lastDay = 30;
				break;
		}
		if (dd > lastDay) return false;		
		return true;
	}

	public static boolean isValid(Date d) {
		return isValid(d.getYear(), d.getMonth(), d.getDay());
	}

	@Override
	public String toString() {
		return String.format("%d년  %d월  %d일 ", year, month, day);
	}


}
