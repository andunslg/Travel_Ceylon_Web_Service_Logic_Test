package web_service_logic;

public class Road {

	public City from;
	public City to;
	public int distnce;
	
	public Road(City from,City to,int dis){
		this.from=from;
		this.to=to;
		distnce=dis;
	}
}
