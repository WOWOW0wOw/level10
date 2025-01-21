package _13다형성게임_실습;

import java.util.Random;
import java.util.ArrayList;

public class UnitManager {

	ArrayList<Player> p_list = new ArrayList<>();
	ArrayList<Unit> m_list = new ArrayList<>();
	String path = "_13다형성게임_실습."; // 패키지명 + .
	String mons[] = { "UnitWolf", "UnitBat", "UnitOrc" };
	Random ran = new Random();

	UnitManager() {
		p_list.add(new Player("전사", 1000, 45));
		p_list.add(new Player("마법사", 800, 60));
		p_list.add(new Player("힐러", 500, 70));
	}
	
	void monsterRandomSet(int size) {
		
	}
}
