package _12콜랙션멤버;

public class ActionUpdate implements Action{

	@Override
	public void excute() {
		while (true) {
			System.out.println("==== [ 회원수정 ] ==== ");
			// 추가하는 dao 연결
			String id = Utils.getStringVelue("아이디 입력 >> ");
			int idx = MemberDAO.getInstance().ischeckID(id);
			if(idx != -1) {
				String pw = Utils.getStringVelue("비밀번호 입력 >> ");
				if(MemberDAO.getInstance().ischeckPW(pw)) {
					MemberDAO.getInstance().updataMemberData(idx);
				}
			}else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}
	}

}
