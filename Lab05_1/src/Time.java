import java.util.Calendar;

public class Time {
	
	Calendar calendar = Calendar.getInstance();
	int year, mon, day, hour, min, sec;
	
	public Time() {
		this.year = calendar.get(Calendar.YEAR);
		this.mon = calendar.get(Calendar.MONTH);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.min = calendar.get(Calendar.MINUTE);
		this.sec = calendar.get(Calendar.SECOND);
	};
	
	public void setTime(Clock clock) {
		clock.setClock(calendar.getTime() + "입니다.");
	}
	
	public void setTime(Clock clock, String str) {
		clock.setClock(str + year + "년" +(mon+1) +"월" + day + "일" + hour + "시" + min + "분"
						+ sec + "초 입니다.");
	}
}