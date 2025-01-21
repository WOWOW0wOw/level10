package _06다형성실습;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

/*
 * 
 // damage() 메소드를 가진 
// Interface Damageable 를 정의하고
// 최하위 유닛들 (모든) 에게 Damageable 상속 
// main에서 각각의 유닛들을 손상시킨 후 -> repair() 돌려보기
 * 
 * 
 */

interface Repairable {
}

interface Damageable {
	void attackOpUnit(Damageable unit, int power);
}

abstract class Unit implements Damageable {
	protected final int MAX_HP;
	protected int hp; // 체력
	protected int damage; // 공력력
	protected String name; // 이름
	private static int cnt = 0; // 총 유닛의 갯수
	protected boolean dead; // 살았는지 죽었는지 확인

	public Unit(int hp, int damage) {
		MAX_HP = hp;
		this.hp = MAX_HP;
		this.damage = damage;
		cnt+=1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Unit(int hp, int damage, String name) {
		MAX_HP = hp;
		this.hp = MAX_HP;
		this.name = name;
		this.damage = damage;
		initMsg();
		cnt+=1;
	}

	private void initMsg() {
		System.out.println("[생성 ]" + this);

	}

	public static int getCnt() {
		return cnt;
	}


	@Override
	public void attackOpUnit(Damageable unit, int power) {

		Unit opUnit = (Unit) unit;
		if (opUnit.dead)
			return;

		opUnit.hp -= power;
		String msg = String.format("[ %s가 %s -%d 데미지 공격 ] ", this, opUnit, power);
		System.out.println(msg);

		if (opUnit.hp <= 0) {
			opUnit.dead = true;
			cnt -= 1;
		}

	}

	@Override
	public String toString() {
		return String.format(" %s [%d / %d ]", name, hp, MAX_HP);
	}

}

abstract class GroundUnit extends Unit {

	public GroundUnit(int hp, int damage) {
		super(hp, damage);
	}

	public GroundUnit(int hp, int damage, String name) {
		super(hp, damage, name);
	}

}

abstract class AirUnit extends Unit {

	public AirUnit(int hp, int damage) {
		super(hp, damage);
	}

	public AirUnit(int hp, int damage, String name) {
		super(hp, damage, name);
	}

}

class Tank extends GroundUnit implements Repairable {

	public Tank() {
		super(250, 15, "Tank");
		// name ="Tank";

	}

}

class Soldier extends GroundUnit {

	public Soldier() {
		super(120, 5, "soldier");
		// name = "soldier";

	}

}

class Aircraft extends AirUnit implements Repairable {

	public Aircraft() {
		super(150, 12, "aircraft");
		// name="aircraft";
	}

}

class DropShip extends AirUnit implements Repairable {

	public DropShip() {
		super(200, 14, "dropShip");
		// name="dropShip";
	}

}

class SCV extends GroundUnit implements Repairable {

	public SCV() {
		super(130, 13, "svc");
		// name="svc";
	}

	void repairUnit(Repairable repairable) {
		Unit unit = (Unit) repairable; // 다형성

		while (unit.hp != unit.MAX_HP) {
			unit.hp++;
		}
		System.out.println(unit + " 수리 완료!!");

	}

}

public class _02스타크레프트 {
	public static void main(String[] args) {

		// Unit unit = new Unit();
		// 10개 유닛 만들어서

//		Tank tank = new Tank();
//		SCV scv = new SCV();
//		tank.attackOpUnit(scv, 10);

		Random rd = new Random();

		String[] units = { "Tank", "SCV", "DropShip", "Soldier", "Aircraft" };

		String packageName = _02스타크레프트.class.getPackageName() + "."; // 풀경로 : 패키지이름 부터 시작한다

		ArrayList<Unit> list = new ArrayList<Unit>();
		int size = 10;
		int cnt = 0;
		while (cnt != size) {

			try {
				Class<?> clazz = Class.forName(packageName + units[ rd.nextInt(units.length)]);

				Object obj = clazz.getDeclaredConstructor().newInstance(); // new Tank();

				Unit unit = (Unit) obj;
				unit.setName(unit.getName() + (cnt+1));
				System.out.println(unit);
				list.add(unit);
			
				cnt+=1;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		// 서로 랜덤하게 공격하다가
		// 한명 살아남을때까지 반복!
		
		Unit winner = null;
		while(true) {
			if(Unit.getCnt() <=1) break;
			
			int rdIdx1 = rd.nextInt(size);
			int rdIdx2 = rd.nextInt(size);
			if(rdIdx1 == rdIdx2) continue;
			
			if(list.get(rdIdx1).dead || list.get(rdIdx2).dead ) {
				continue;
			}
			
			list.get(rdIdx1).attackOpUnit(list.get(rdIdx2) , rd.nextInt(10)+10);
			if(list.get(rdIdx2).dead) {
				winner = list.get(rdIdx1);
				continue;
			}
			list.get(rdIdx2).attackOpUnit( list.get(rdIdx1), rd.nextInt(10)+10 );
			
			if(list.get(rdIdx1).dead) {
				winner = list.get(rdIdx2);
				continue;
			}
			System.out.println("------------");
		}
		
		
		System.out.println("================");
		System.out.println(" 최후의 승자 = " + winner);

	}
}
