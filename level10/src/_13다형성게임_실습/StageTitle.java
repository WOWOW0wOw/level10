package _13다형성게임_실습;

public class StageTitle extends Stage{
	
	@Override
	public boolean update() {
		System.out.println("===== GAME TITLE =====");
		System.out.println("아무런 버튼을 눌러주세요.");
		String input = GameManager.sc.nextLine();
		GameManager.nextStage = "LOBBY";
		return false;
	}
	
	@Override
	public void init() {

	}
}
