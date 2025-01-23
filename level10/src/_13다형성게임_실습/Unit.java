package _13다형성게임_실습;

public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "노말";
	
	
	
	public int getCurhp() {
		return curhp;
	}

	public void setCurhp(int curhp) {
		this.curhp = curhp;
	}

	public int getPower() {
		return power;
	}

	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Unit() {
	};

	Unit(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	};

	void init(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	};
	
	public void fight(Unit unit) {
		System.out.println("[" + getName() + "]가 [" + unit.getName() + "] 에게 " + getPower() + "의 데미지를 입혔습니다");
		unit.setCurhp(unit.getCurhp() - getPower());
		if(unit.getCurhp() <= 0) {
			unit.setCurhp(0);
			System.out.println("[" + unit.getName() + "]가 죽었습니다.");
		}
	}
	
	public void printData() {
		System.out.println("[" + name + "] [" + curhp + "/" + maxhp + "] [" + power + "]");
	}
	

}
