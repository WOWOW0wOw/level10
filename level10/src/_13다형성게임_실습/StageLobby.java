package _13다형성게임_실습;

public class StageLobby extends Stage{

	@Override
	public boolean update() {
		System.out.println("===== GAME LOBBY =====");
		System.out.println("[1. 전투] [2. 종료]");
		int sel = GameManager.sc.nextInt();
		if(sel == 1) {
			GameManager.nextStage = "BATTLE";
			return false;
		}else {
			GameManager.nextStage = "";
			return true;
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
