package _12콜랙션멤버;

public class ActionDelete implements Action {

	@Override
	public void excute() {

		while (true) {
			System.out.println("==== [ 회원삭제 ] ==== ");
			// 추가하는 dao 연결
			String id = Utils.getStringVelue("아이디 입력 >> ");

			if (MemberDAO.getInstance().deleteMemberData(id)) {
				break;
			}
		}
		System.out.println("삭제 완료");
	}

}
