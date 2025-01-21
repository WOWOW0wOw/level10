package _13다형성게임_실습;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	Random rd = new Random();
	static Scanner sc = new Scanner(System.in);
	static String nextStage = "";
	String curStage = "MAIN";
	Map<String, Stage> stageList = new HashMap<String, Stage>();

	GameManager() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		nextStage = "TITLE";
	}

	public boolean changeStage() {
		System.out.println("현재 스테이지 : " + curStage);
		System.out.println("다음 스테이지 : " + nextStage);

		curStage = nextStage;

		stageList.get(curStage).init();

		boolean run = true;
		while (run) {
			run = stageList.get(curStage).update();
		}
		if (nextStage.equals("")) {
			return false;
		}
		return true;
	}
}
