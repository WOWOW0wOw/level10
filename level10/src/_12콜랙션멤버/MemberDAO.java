package _12콜랙션멤버;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MemberDAO {

	private MemberDAO() {
	};

	private static MemberDAO instance; // main 시작할 때 자동으로 만든다

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	private ArrayList<Member> memberList = new ArrayList<>();
	
	public void loadFileToList() {
		memberList.clear();
		String data = Utils.loadMemberDataFile();
		String[] datas = data.split("\n");
		for(int i = 0; i < datas.length; i++) {
			String[] temp = datas[i].split("/");
			memberList.add(new Member(temp[0], temp[1], temp[2]));
		}
	}
	
	public Set<String> ascendingID() {
		Set<String> list = new TreeSet<>();
		for (int i = 0; i < memberList.size(); i++) {
			list.add(memberList.get(i).getId());
		}
		return list;
	}
	
	public void saveMemberList() {
		String data = "";
		Set<String> list = ascendingID();
		for(String s : list) {
			for(Member m : memberList) {
				if(s.equals(m.getId())) {
					data += m.getId() + "/" + m.getPw() + "/" + m.getName() + "\n";
				}
			}
		}
		Utils.saveMemberDataFile(data);
	}
	
	public void updataMemberData(int idx) {
		memberList.get(idx).setName(Utils.getStringVelue("수정할 이름 입력 >> "));
	}

	public int ischeckID(String id) {
		int idx = 0;
		Set<String> list = new HashSet<>();
		for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getId().equals(id)) {
				return i;
			}
			list.add(memberList.get(i).getId());
		}
		return -1;
	}

	public boolean ischeckPW(String pw) {
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}

	public void addMember(String id, String pw, String name) {
		memberList.add(new Member(id, pw, name));
	}

	public void printMember() {
		Set<String> list = new TreeSet<>();
		for (int i = 0; i < memberList.size(); i++) {
			list.add(memberList.get(i).getName());
		}
		for(String l : list) {
			for(Member m : memberList) {
				if(l.equals(m.getName())) {
					System.out.println(m);
				}
			}
		}
	}

	public boolean deleteMemberData(String id) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

}
