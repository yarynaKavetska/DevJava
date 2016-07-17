package less8;

import static less8.Season.*;

public enum Month {

	JANUARY(WINTER, 31), FEBRUARY(WINTER, 28),
	MARCH(SPRING, 31), APRIL(SPRING, 30),
	MAY(SPRING, 31), JUNE(SUMMER, 30),
	JULY(SUMMER, 31), AUGUST(SUMMER, 31),
	SEPTEMBER(AUTUMN, 30), OCTOBER(AUTUMN, 31),
	NOVEMBER(AUTUMN, 30), DECEMBER(WINTER, 31);
	
	private final int days;
	
	private final Season season;
	
	private Month(Season season, int days){
		this.season = season;
		this.days = days;
	}

	public int getDays() {
		return days;
	}
	
	public Season getSeason() {
		return season;
	}
	
	public String toString(){
		return name() + "[days="+days+", season="+season+"]";
	}
}
