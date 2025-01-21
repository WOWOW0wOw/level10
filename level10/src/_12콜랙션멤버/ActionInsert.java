package _12콜랙션멤버;

// mvc : model view controller 

// controller 기능 - 페이지 연결 
// 페이지 (view :Action 객체들) : 사용자 값 받아오고 값 전달 
// DAO : 여러개의 맴버들의 기능 
// VO(model) : Member

public class ActionInsert implements Action {


	@Override
	public void excute() {

		while (true) {
			System.out.println("==== [ 회원가입 ] ==== ");

			// 추가하는 dao 연결
			String id = Utils.getStringVelue("아이디 입력 >> ");
			String pw = Utils.getStringVelue("비밀번호 입력 >> ");
			String name = Utils.getStringVelue("이름 입력 >> ");
			
			if(MemberDAO.getInstance().ischeckID(id) == -1) {
				MemberDAO.getInstance().addMember(id, pw, name);
				break;
			}
		}
		System.out.println("회원 가입 완료");
	}

}
