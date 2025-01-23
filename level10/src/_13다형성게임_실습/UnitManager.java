package _13다형성게임_실습;

import java.util.Random;
import java.util.ArrayList;

public class UnitManager {

	ArrayList<Player> p_list = new ArrayList<>();
	ArrayList<Unit> m_list = new ArrayList<>();
//	String path = "_13다형성게임_실습."; // 패키지명 + .
	String mons[] = { "UnitWolf", "UnitBat", "UnitOrc" };
	Random rd = new Random();

	UnitManager() {
		p_list.add(new Player("전사", 1000, 45));
		p_list.add(new Player("마법사", 800, 60));
		p_list.add(new Player("힐러", 500, 70));
	}
	
	ArrayList<Unit> monsterRandomSet(int size) {
		for(int i = 0; i < size; i++) {
			int idx = rd.nextInt(mons.length);
			int hp = rd.nextInt(100)+100;
			int pw = rd.nextInt(10)+10;
			if(idx == 0) {
				m_list.add(new UnitWolf());
				m_list.get(i).setMaxhp(hp);
				m_list.get(i).setCurhp(hp);
				m_list.get(i).setPower(pw);
			}else if(idx == 1) {
				m_list.add(new UnitBat());
				m_list.get(i).setMaxhp(hp);
				m_list.get(i).setCurhp(hp);
				m_list.get(i).setPower(pw);
			}else if(idx == 2) {
				m_list.add(new UnitOrc());
				m_list.get(i).setMaxhp(hp);
				m_list.get(i).setCurhp(hp);
				m_list.get(i).setPower(pw);
			}
		}
		return m_list;
	}
}
