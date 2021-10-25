
public class Distance {
	private String name;
	private double lat;
	private double lng;
	
	public static String getDistance(Distance a, Distance b) {
		double res = Math.sqrt(Math.pow(a.lat-b.lat, 2.0) + Math.pow(a.lng-b.lng, 2.0));
		return Double.toString(res);
	}
	
	public Distance(String name, double lat, double lng) {
		this.name = name;
		this.lat = lat;
		this.lng = lng;
	}
	
	public String writeDistance() {
		return "Country : " + name + "\r\n" + "latitude = " + lat + "\r\n" + 
				"longitude = " + lng + "\r\n" + "-------------------";
	}
}
