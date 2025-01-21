package _13다형성게임_실습;

public class _MainGame {

	public static void main(String[] args) {
		GameManager gm = new GameManager();
		boolean run = true;
		while (true) {
			run = gm.changeStage();
			if (run == false) {
				break;
			}
		}
		System.out.println("게임오버");

	}

}
