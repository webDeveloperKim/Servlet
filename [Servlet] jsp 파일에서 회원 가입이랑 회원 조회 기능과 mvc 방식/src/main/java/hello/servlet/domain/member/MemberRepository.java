package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 기능 요구사항
// 회원 저장
// 회원 목록조회

// 기본 crud 기능하는 클래스
// 싱글톤 패턴을 적용한 회원 저장소 클래스
public class MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	private static final MemberRepository instance = new MemberRepository();
	
	public static MemberRepository getInstance() {
		return instance;
	}
	
	public MemberRepository() {}
	
	// 회원 등록
	public Member save(Member member) {
		member.setId(++sequence); // 회원등록 시점에 아이디 자동생성
		store.put(member.getId(), member);
		return member;
	}
	
	// 회원 아이디로 조회
	public Member findById(Long id) {
		return store.get(id);
	}
	
	// 모든 회원 조회
	public List<Member> findAll(){
		return new ArrayList<>(store.values());
	}
	
	// 값 초기화
	public void clearStore() {
		store.clear();
	}
}
