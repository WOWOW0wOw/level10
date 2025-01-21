package _12콜랙션멤버;

public class ActionPrint implements Action{

	
	@Override
	public void excute() {
		MemberDAO.getInstance().printMember();
	}

}
