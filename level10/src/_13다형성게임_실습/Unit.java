package _13다형성게임_실습;

public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "노말";
	
	Unit() {};
	
	Unit(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	};
	
	public void printData() {
		
	}
	

}
