package highway;

public enum Place {
	
	SEOUL("서울", 0),
	SUWON("수원", 40),
	DAEGEON("대전", 160),
	DAEGUE("대구", 290),
	BUSAN("부산", 390);
	
	
	public int getDistance(Place end) {
		return Math.abs(location - end.location);
	}
	
	Place(String name, int location) {
		this.koreaName = name;
		this.location = location;
	}
	
	public static Place getByName(String name) {
		for(Place place :Place.values()) {
			if(place.koreaName.equals(name)) {
				return place;
			}
		}
		return null;
	}
	public String getName() {
		return koreaName;
	}
	String koreaName;
	int location;
}
