package _13다형성게임_실습;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage{
	UnitManager um = new UnitManager();
	ArrayList<Player> pList = null;
	ArrayList<Unit> monList = null;
	Random ran = new Random();
	int mDie = 0;
	int pDie = 0;

	@Override
	public boolean update() {
		System.out.println("======[BATTLE]======");
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < pList.size(); i++) {
			pList.get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
		return false;
	}

	@Override
	public void init() {
		um.m_list.clear();
		um.monsterRandomSet(4);
		pList = null;
		pList = um.p_list;
		monList = null;
		monList = um.m_list;
		mDie = monList.size();
		pDie = pList.size();
	}

}
