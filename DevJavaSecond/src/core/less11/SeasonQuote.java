package core.less11;

import java.util.HashMap;
import java.util.Map;

import core.less7.Season;

public class SeasonQuote {
	
	private final Map<Season, String> map = new HashMap<>();

	public SeasonQuote() {
		map.put(Season.WINTER, "Winter is cold");
		map.put(Season.SUMMER, "Summer is hot");
		map.put(Season.AUTUMN, "Autumn is rainy");
		map.put(Season.SPRING, "Spring is shiny");
	}

	public String getQuote(Season season){
		return map.get(season);
//		switch (season){
//		case WINTER : {
//			return "Winter is cold";
//		}
//		case SUMMER : {
//			return "Summer is hot";
//		}
//		case AUTUMN : {
//			return "Autumn is rainy";
//		}
//		case SPRING : {
//			return "Spring is shiny";
//		}
//		default : {
//			return null;
//		}
//		}
	}
}
