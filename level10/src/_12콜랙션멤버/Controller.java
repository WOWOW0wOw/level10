package _12콜랙션멤버;

import java.util.HashMap;
import java.util.Map;

public class Controller {

	private Map<Menu, Action> mapList;

	public Controller() {
		mapList = new HashMap<Menu, Action>();

		mapList.put(Menu.INSERT, new ActionInsert());
		mapList.put(Menu.DELETE, new ActionDelete());
		mapList.put(Menu.UPDATE, new ActionUpdate());
		mapList.put(Menu.PRINT, new ActionPrint());
		mapList.put(Menu.SAVE, new ActionSave());
		mapList.put(Menu.LOAD, new ActionLoad());

	}

	public Action getAction(Menu key) {
		return mapList.get(key);
	}

	public void run() {
		while (true) {
			System.out.println("========== 메뉴 ==========");
			System.out.println("1) 추가"); // id 중복제거
			System.out.println("2) 삭제"); // id 로 삭제
			System.out.println("3) 수정"); // id 검색 -> 비번 검색 -> 비번 맞으면 이름 수정
			System.out.println("4) 출력"); // 이름순 으로 출력
			System.out.println("5) 저장"); // member.txt => id 순으로 저장
			System.out.println("6) 로드"); // member.txt 로드
			System.out.println("0) 종료");
			int sel = Utils.getIntVelue("메뉴 선택(0 ~ 6) >> ");
			if (sel == 1) {
				// 추가하는 기능 DAO
				mapList.get(Menu.INSERT).excute();
			} else if (sel == 2) {
				mapList.get(Menu.DELETE).excute();
			} else if (sel == 3) {
				mapList.get(Menu.UPDATE).excute();
			} else if (sel == 4) {
				mapList.get(Menu.PRINT).excute();
			} else if (sel == 5) {
				mapList.get(Menu.SAVE).excute();
			} else if (sel == 6) {
				mapList.get(Menu.LOAD).excute();
			}else {
				break;
			}
		}
	}
}
