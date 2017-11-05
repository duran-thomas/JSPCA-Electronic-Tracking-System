package Classes;

public class Date {
	
	public int day;
	public int month;
	public int year;
	public int hour;
	public int minute;
	
	public Date(){
		day = 0;
		month = 0;
		year = 0;
		hour = 0;
		minute = 0;
	}
	
	public Date(int dd, int mm, int yy, int hr, int min){
		day = dd;
		month = mm;
		year = yy;
		hour = hr;
		minute = min;
	}
	
	public Date(Date obj){
		this.day = obj.day;
		this.month = obj.month;
		this.year = obj.year;
		this.hour = obj.hour;
		this.minute = obj.minute;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	
}
