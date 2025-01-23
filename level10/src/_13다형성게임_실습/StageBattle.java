package _13다형성게임_실습;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage {
	UnitManager um = new UnitManager();
	ArrayList<Player> pList = um.p_list;
	ArrayList<Unit> monList = um.m_list;
	Random rd = new Random();
	int mDie = 0;
	int pDie = 0;

	void printUnit() {
		System.out.println("======[BATTLE]======");
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < pList.size(); i++) {
			pList.get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}

	public void isdie() {
		mDie = 0;
		pDie = 0;
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getCurhp() <= 0) {
				pDie++;
			}
		}
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).getCurhp() <= 0) {
				mDie++;
			}
		}
	}

	public boolean update() {
		int pidx = 0;
		int midx = 0;
		while (true) {
			if (pidx < pList.size()) {
				printUnit();
				playerFightMonster(pidx++);
			} else {
				monsterFightPlayer(midx++);
				if (midx > monList.size()-1) {
					pidx = 0;
					midx = 0;
				}
			}
			isdie();
			if(pDie == pList.size()) {
				GameManager.nextStage = "";
				return false;
			}
			if (mDie == monList.size()) {
				GameManager.nextStage = "LOBBY";
				return false;
			}
		}
	}

	@Override
	public void init() {
		um.m_list.clear();
		monList = um.monsterRandomSet(4);
	}

	void playerFightMonster(int idx) {
		if (pList.get(idx).getCurhp() <= 0) {
			return;
		} else {
			System.out.println("======[메뉴 선택]=====");
			System.out.println("[" + pList.get(idx).getName() + "] [1.어택] [2.스킬]");
			int sel = GameManager.sc.nextInt();
			if (sel == 1) {
				int idx2;
				while (true) {
					idx2 = rd.nextInt(monList.size());
					if (monList.get(idx2).getCurhp() > 0) {
						break;
					}
				}
				pList.get(idx).fight(monList.get(idx2));
			} else if (sel == 2) {

			}
		}
	}

	void monsterFightPlayer(int idx) {
		if (monList.get(idx).getCurhp() <= 0) {
			return;
		} else {
			int idx2;
			while (true) {
				idx2 = rd.nextInt(pList.size());
				if (pList.get(idx2).getCurhp() > 0) {
					break;
				}
			}
			monList.get(idx).fight(pList.get(idx2));
		}
	}

}
